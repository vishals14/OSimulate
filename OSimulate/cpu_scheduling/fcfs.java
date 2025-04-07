import java.util.List;

class Process {
    int pid;        // Process ID
    int burstTime;  // Burst Time of the process

    Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
    }
}

public class fcfs {

    public static void fcfsScheduling(List<Process> processes) {
        int waitTime = 0;
        int totalWaitTime = 0;
        int totalTurnaroundTime = 0;

        for (Process process : processes) {
            totalWaitTime += waitTime;
            int turnaroundTime = waitTime + process.burstTime;
            totalTurnaroundTime += turnaroundTime;

            // Print Process details
            System.out.println("Process " + process.pid + " - Wait Time: " + waitTime + ", Turnaround Time: " + turnaroundTime);

            // Update wait time for the next process
            waitTime += process.burstTime;
        }

        int numProcesses = processes.size();
        System.out.println("Average Wait Time: " + (double) totalWaitTime / numProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / numProcesses);
    }

    public static void main(String[] args) {
        List<Process> processes = List.of(
            new Process(1, 5),
            new Process(2, 3),
            new Process(3, 8),
            new Process(4, 6)
        );

        fcfsScheduling(processes);
    }
}
