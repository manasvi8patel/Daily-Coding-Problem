
/**
 * DCP : Problem #16 [Easy]
 * This problem was asked by Twitter.
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */

public class LastNOrderLogDataStructure {
    private int maxSize;
    private int[] circularQueue;
    private int currIndex;

    public LastNOrderLogDataStructure(int n)
    {
        maxSize = n;
        circularQueue = new int[n];
        currIndex = 0;
    }

    public void record(int order_id)    // variable type can be clarified from interviewer
    {
        circularQueue[currIndex] = order_id;
        currIndex = (currIndex + 1) % maxSize;
    }

    public int get_last(int i)
    {
        return circularQueue[(currIndex - i + maxSize) % maxSize];
    }
}
