import java.util.*;

public class sstf {

    public static void sstf(List<Integer> requests, int head) {
        int seekCount = 0;
        int distance, curTrack;
        int n = requests.size();

        boolean[] visited = new boolean[n];
        List<Integer> seekSequence = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int tempDistance = Math.abs(requests.get(j) - head);
                    if (tempDistance < minDistance) {
                        minDistance = tempDistance;
                        minIndex = j;
                    }
                }
            }

            if (minIndex != -1) {
                visited[minIndex] = true;
                curTrack = requests.get(minIndex);
                distance = Math.abs(curTrack - head);
                seekCount += distance;
                head = curTrack;
                seekSequence.add(curTrack);
            }
        }

        System.out.println("Total Seek Operations: " + seekCount);
        System.out.println("Seek Sequence: " + seekSequence);
    }

    public static void main(String[] args) {
        List<Integer> requests = Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);
        int head = 53;

        sstf(requests, head);
    }
}
