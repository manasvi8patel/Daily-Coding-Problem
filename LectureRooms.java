import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * DCP : Problem #21 [Easy]
 * This problem was asked by Snapchat.
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

// Time Complexity : O(NlogN)
// Space Complexity : O(N)


public class LectureRooms {
    public static void main(String[] args) {
        int[][] timeIntervals = {{30, 75}, {0, 50}, {60, 150}};

        int minRooms = getMinRooms(timeIntervals);
        System.out.println(minRooms);
    }

    public static int getMinRooms(int[][] timeIntervals)
    {
        if(timeIntervals.length == 0)
            return 0;

        Arrays.sort(timeIntervals, (s1, s2) -> s1[0] - s2[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);

        for (int[] interval : timeIntervals)
        {
            if(!minHeap.isEmpty() && minHeap.peek()[1] <= interval[0])
                minHeap.poll();

            minHeap.add(interval);
        }

        return minHeap.size();
    }
}
