import java.util.*;

public class lru {

    public static void lru(List<Integer> pages, int frameSize) {
        Map<Integer, Integer> indexes = new HashMap<>();
        List<Integer> frames = new ArrayList<>();
        int pageFaults = 0;

        for (int i = 0; i < pages.size(); i++) {
            int page = pages.get(i);

            if (frames.size() < frameSize) {
                if (!frames.contains(page)) {
                    frames.add(page);
                    pageFaults++;
                }
                indexes.put(page, i);
            } else {
                if (!frames.contains(page)) {
                    int lru = Integer.MAX_VALUE;
                    int val = -1;

                    for (int framePage : frames) {
                        if (indexes.get(framePage) < lru) {
                            lru = indexes.get(framePage);
                            val = framePage;
                        }
                    }

                    // Replace the LRU page
                    int replaceIndex = frames.indexOf(val);
                    frames.set(replaceIndex, page);
                    pageFaults++;
                }
                indexes.put(page, i);
            }
        }

        System.out.println("Total Page Faults: " + pageFaults);
    }

    public static void main(String[] args) {
        List<Integer> pages = Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2);
        int frameSize = 4;

        lru(pages, frameSize);
    }
}
