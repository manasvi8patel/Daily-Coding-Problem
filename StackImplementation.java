import java.util.Deque;
import java.util.LinkedList;

/**
 * DCP : Problem #43 [Easy]
 * This problem was asked by Amazon.
 * Implement a stack that has the following methods:
 * push(val), which pushes an element onto the stack
 * pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
 * max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
 * Each method should run in constant time.
 */

// Time Complexity : O(1)
// Space Complexity : O(N) - with Approach 1 ; O(1) - best case with Approach 2

// This class is used in Approach 2
class MaxWithCount{
    public Integer max;
    public Integer count;

    public MaxWithCount(Integer max, Integer count)
    {
        this.max = max;
        this.count = count;
    }
}

public class StackImplementation {

    // Approach 1 - For each entry in stack, we cache the maximum stored at or below that entry into 'maximum'. And when we pop, we also remove the corresponding cached value from 'maximum'
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> maximum = new LinkedList<>();

    public void push(Integer val)
    {
        stack.addFirst(val);

        if(maximum.isEmpty())
            maximum.addFirst(val);
        else
            maximum.addFirst(Math.max(val, maximum.peekFirst()));
    }

    public Integer pop()
    {
        if(stack.isEmpty())
            return null;

        maximum.removeFirst();
        return stack.removeFirst();
    }

    public Integer max()
    {
        if(maximum.isEmpty())
            return null;

        return maximum.peek();
    }

    // Approach 2 - We cache the number of occurrences of each maximum value along with the maximum value itself.
    // Results in improved Best-case Space Complexity.
    // When the number of distinct keys is small or the maximum changes infrequently, the additional Space complexity is O(1) in the best case.
    // However, the worst-case additional space complexity is still o(n), which occurs when each key pushed is greater than all keys in the primary stack.
    Deque<Integer> stackForImprovedSpace = new LinkedList<>();
    Deque<MaxWithCount> auxiliaryStack = new LinkedList<>();

    public void pushForImprovedSpace(Integer val)
    {
        stackForImprovedSpace.addFirst(val);
        if(auxiliaryStack.isEmpty())
        {
            auxiliaryStack.addFirst(new MaxWithCount(val, 1));
        }
        else
        {
            // If an element being pushed is smaller than the maximum element already in the stack, then we don't record it because it can never be the maximum.
            if(Integer.compare(val, auxiliaryStack.peekFirst().max) == 0)
                auxiliaryStack.peekFirst().count++;
            else if(Integer.compare(val, auxiliaryStack.peekFirst().max) > 0)
                auxiliaryStack.addFirst(new MaxWithCount(val, 1));
        }
    }

    public Integer popForImprovedSpace()
    {
        if(stackForImprovedSpace.isEmpty())
            return  null;

        Integer poppedElement = stackForImprovedSpace.removeFirst();
        if(poppedElement.equals(auxiliaryStack.peekFirst().max))
        {
            auxiliaryStack.peekFirst().count--;

            if(auxiliaryStack.peek().count.equals(0))
                auxiliaryStack.removeFirst();
        }
        return poppedElement;
    }

    public Integer maxForImprovedSpace()
    {
        if(auxiliaryStack.isEmpty())
            return null;

        return auxiliaryStack.peekFirst().max;
    }

  public static void main(String[] args) {
        //Approach - 1
      StackImplementation stackObj = new StackImplementation();
      stackObj.push(5);
      System.out.println(stackObj.max());
      stackObj.push(4);
      System.out.println(stackObj.max());
      stackObj.push(1);
      System.out.println(stackObj.max());
      stackObj.push(7);
      System.out.println(stackObj.max());
      stackObj.push(3);
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());
      stackObj.push(2);
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());
      stackObj.push(8);
      System.out.println(stackObj.max());
      stackObj.pop();
      System.out.println(stackObj.max());

    // Approach 2 - Space complexity improved
    System.out.println("Space complexity improved :");
      StackImplementation stackObjImproved = new StackImplementation();
      stackObjImproved.pushForImprovedSpace(5);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.pushForImprovedSpace(4);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.pushForImprovedSpace(1);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.pushForImprovedSpace(7);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.pushForImprovedSpace(3);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.pushForImprovedSpace(2);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.pushForImprovedSpace(8);
      System.out.println(stackObjImproved.maxForImprovedSpace());
      stackObjImproved.popForImprovedSpace();
      System.out.println(stackObjImproved.maxForImprovedSpace());
  }
}
