import java.util.*;

public class scan {

    public static void scanDiskScheduling(List<Integer> requests, int head, int diskSize, boolean direction) {
        int seekCount = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seekSequence = new ArrayList<>();

        // Split requests into left and right of the head
        for (int request : requests) {
            if (request < head)
                left.add(request);
            else
                right.add(request); // includes request == head
        }

        // Add the end depending on direction
        if (direction) {
            right.add(diskSize - 1);  // Moving toward higher tracks
        } else {
            left.add(0);              // Moving toward lower tracks
        }

        Collections.sort(left);
        Collections.sort(right);

        if (direction) { // Moving right
            for (int curTrack : right) {
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
            for (int i = left.size() - 1; i >= 0; i--) {
                int curTrack = left.get(i);
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
        } else { // Moving left
            for (int i = left.size() - 1; i >= 0; i--) {
                int curTrack = left.get(i);
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
            for (int curTrack : right) {
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
        }

        System.out.println("Total Seek Operations: " + seekCount);
        System.out.println("Seek Sequence: " + seekSequence);
    }

    public static void main(String[] args) {
        List<Integer> requests = Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);
        int head = 53;
        int diskSize = 200;
        boolean direction = true; // true = moving right, false = moving left

        scanDiskScheduling(requests, head, diskSize, direction);
    }
}
