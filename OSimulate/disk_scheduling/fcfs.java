import java.util.*;

public class fcfs {

    public static void fcfsDiskScheduling(List<Integer> requests, int head) {
        int seekCount = 0;

        for (int curTrack : requests) {
            int distance = Math.abs(curTrack - head);
            seekCount += distance;
            head = curTrack;
        }

        System.out.println("Total Seek Operations: " + seekCount);
    }

    public static void main(String[] args) {
        List<Integer> requests = Arrays.asList(82, 170, 43, 140, 24, 16, 190);
        int head = 50;

        fcfsDiskScheduling(requests, head);
    }
}
