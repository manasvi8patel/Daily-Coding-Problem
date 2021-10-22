import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * DCP : Problem #53 [Medium]
 * This problem was asked by Apple.
 * Implement a queue using two stacks.
 * Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods: enqueue, which inserts an element into the queue, and dequeue, which removes it.
 */

// Time Complexity : Amortized O(m) - for m operations; Worst-case O(n)
// In the worst case scenario when second stack is empty, the algorithm pops n elements from first stack and pushes n elements to second stack, where n is the queue size. This gives 2n operations, which is O(n). But when second stack is not empty the algorithm has O(1) time complexity.
// Space Complexity : O(n)

public class QueueImplementationUsingStacks<T> {
    private Deque<T> enqStack = new LinkedList<>();
    private Deque<T> deqStack = new LinkedList<>();

  public static void main(String[] args) {
    QueueImplementationUsingStacks<Integer> obj = new QueueImplementationUsingStacks<Integer>();
    obj.enqueue(11);
    obj.enqueue(21);
    System.out.println(obj.dequeue());
    obj.enqueue(23);
    obj.enqueue(44);
    System.out.println(obj.dequeue());
    System.out.println(obj.dequeue());
    System.out.println(obj.dequeue());
//    System.out.println(obj.dequeue());
  }

  public void enqueue(T data)
  {
      enqStack.addFirst(data);
  }

  public T dequeue()
  {
      if (deqStack.isEmpty())
      {
          while (!enqStack.isEmpty())
          {
              deqStack.addFirst(enqStack.removeFirst());
          }
      }

      if (!deqStack.isEmpty())
          return deqStack.removeFirst();

      throw new NoSuchElementException("Cannot remove from an empty queue.");
  }
}
