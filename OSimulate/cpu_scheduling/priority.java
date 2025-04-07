import java.util.*;

class Process {
    int pid;
    int burstTime;
    int priority;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class priority {

    public static void priorityScheduling(List<Process> processes) {
        // Sort based on priority (lower value = higher priority)
        processes.sort(Comparator.comparingInt(p -> p.priority));

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
            new Process(1, 10, 2),
            new Process(2, 5, 0),
            new Process(3, 8, 1)
        );

        priorityScheduling(processes);
    }
}
