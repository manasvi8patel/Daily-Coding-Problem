import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * DCP : Problem #33 [Easy] This problem was asked by Microsoft. Compute the running median of a
 * sequence of numbers. That is, given a stream of numbers, print out the median of the list so far
 * on each new element. Recall that the median of an even-numbered list is the average of the two
 * middle numbers. For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should
 * print out: 2 1.5 2 3.5 2 2 2
 */

// Time Complexity : O(n log n)
// Space Complexity : O(n)

public class RunningMedian {
  public static void main(String[] args) {
    List<Integer> sequence = new ArrayList<>();
    sequence.addAll(Arrays.asList(2, 1, 5, 7, 2, 0, 5));

    computeRunningMedian(sequence);
  }

  public static void computeRunningMedian(List<Integer> sequence) {
    // Stores larger half of sequence seen so far
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // Stores smaller half of sequence seen so far
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    double median;

    for (Integer num : sequence) {
      // The very first element is stored in minHeap
      if (minHeap.isEmpty())
          minHeap.add(num);
      else {
        if (num >= minHeap.peek())
            minHeap.add(num);
        else
            maxHeap.add(num);
      }

      // minHeap and maxHeap must have equal number of elements if an even number of elements is read
      // Otherwise, minHeap must have one more element that maxHeap (in case odd number of elements is read)
      if (minHeap.size() > maxHeap.size() + 1)
          maxHeap.add(minHeap.remove());
      else if (maxHeap.size() > minHeap.size())
          minHeap.add(maxHeap.remove());

      median =
          (minHeap.size() == maxHeap.size())
              ? (minHeap.peek() + maxHeap.peek()) * 0.5
              : minHeap.peek();

      System.out.println(median);
    }
  }
}
