import java.util.*;

public class fifo {

    public static void fifo(List<Integer> pages, int frameSize) {
        Set<Integer> memoryFrames = new HashSet<>();
        Queue<Integer> pageQueue = new LinkedList<>();

        int pageFaults = 0;

        for (int page : pages) {
            // If the memory is not full
            if (memoryFrames.size() < frameSize) {
                if (!memoryFrames.contains(page)) {
                    memoryFrames.add(page);
                    pageQueue.add(page);
                    pageFaults++;
                }
            } else {
                // Memory is full, check if page is not in memory
                if (!memoryFrames.contains(page)) {
                    int oldestPage = pageQueue.poll();
                    memoryFrames.remove(oldestPage);

                    memoryFrames.add(page);
                    pageQueue.add(page);
                    pageFaults++;
                }
            }
        }

        System.out.println("Total Page Faults: " + pageFaults);
    }

    public static void main(String[] args) {
        List<Integer> pages = Arrays.asList(1, 3, 0, 3, 5, 6);
        int frameSize = 3;

        fifo(pages, frameSize);
    }
}
