import java.util.*;

class Process {
    int pid;
    int burstTime;

    Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
    }
}

public class sjf {

    public static void sjfScheduling(List<Process> processes) {
        // Sort by burst time (Shortest Job First)
        processes.sort(Comparator.comparingInt(p -> p.burstTime));

        int waitTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        for (Process process : processes) {
            totalWaitTime += waitTime;
            int turnaroundTime = waitTime + process.burstTime;
            totalTurnaroundTime += turnaroundTime;

            System.out.println("Process " + process.pid + " - Wait Time: " + waitTime +
                    ", Turnaround Time: " + turnaroundTime);

            waitTime += process.burstTime;
        }

        int numProcesses = processes.size();
        System.out.println("Average Wait Time: " + (float) totalWaitTime / numProcesses);
        System.out.println("Average Turnaround Time: " + (float) totalTurnaroundTime / numProcesses);
    }

    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
                new Process(1, 6),
                new Process(2, 8),
                new Process(3, 7),
                new Process(4, 3)
        );

        // ✅ Call the SJF scheduler
        sjfScheduling(processes);
    }
}
