import java.util.*;

class Process {
    int pid;
    int burstTime;
    int remainingTime;

    Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class rr {

    public static void rrScheduling(List<Process> processes, int timeQuantum) {
        Queue<Process> readyQueue = new LinkedList<>();
        readyQueue.addAll(processes);

        int currentTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.poll();

            if (process.remainingTime > timeQuantum) {
                process.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
                readyQueue.add(process);
            } else {
                currentTime += process.remainingTime;
                int waitTime = currentTime - process.burstTime;
                int turnaroundTime = currentTime;

                totalWaitTime += waitTime;
                totalTurnaroundTime += turnaroundTime;

                System.out.println("Process " + process.pid + " - Wait Time: " + waitTime +
                        ", Turnaround Time: " + turnaroundTime);

                process.remainingTime = 0;
            }
        }

        int numProcesses = processes.size();
        System.out.println("Average Wait Time: " + (float) totalWaitTime / numProcesses);
        System.out.println("Average Turnaround Time: " + (float) totalTurnaroundTime / numProcesses);
    }

    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
                new Process(1, 10),
                new Process(2, 5),
                new Process(3, 8)
        );

        int timeQuantum = 2;
        rrScheduling(processes, timeQuantum);
    }
}

