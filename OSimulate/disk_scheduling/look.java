import java.util.*;

public class look {

    public static void Look(List<Integer> requests, int head, boolean direction) {
        int seekCount = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> seekSequence = new ArrayList<>();

        // Separate requests into left and right of head
        for (int request : requests) {
            if (request < head)
                left.add(request);
            else if (request > head)
                right.add(request);
        }

        // Sort both ends
        Collections.sort(left);
        Collections.sort(right);

        // Direction: true = right (up), false = left (down)
        if (direction) {
            // Move toward higher tracks first
            for (int curTrack : right) {
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
            // Then to the lowest requests
            for (int i = left.size() - 1; i >= 0; i--) {
                int curTrack = left.get(i);
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
        } else {
            // Move toward lower tracks first
            for (int i = left.size() - 1; i >= 0; i--) {
                int curTrack = left.get(i);
                seekSequence.add(curTrack);
                seekCount += Math.abs(curTrack - head);
                head = curTrack;
            }
            // Then to the higher requests
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
        boolean direction = true; // true = move right first; false = move left first

        Look(requests, head, direction);
    }
}
