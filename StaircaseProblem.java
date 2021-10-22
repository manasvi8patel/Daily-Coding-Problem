
/**
 * DCP : Problem #12 [Hard]
 * This problem was asked by Amazon.
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 * For example, if N is 4, then there are 5 unique ways:
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */

public class StaircaseProblem {
    public static void main(String[] args) {
 //       int N = 11; //3; //2; //1; //-1; //0;//4;

//        int result = calculateUniqueWays(N);
//        System.out.println(result);

        int n = 6;//4;//2;//0;//4;//6;      // total stairs
        int[] x = {2, 4, 6};//{1, 3, 5};       // step size options

        int result = calculateUniqueWaysForX(n, x);
        System.out.println(result);

    }

    public static int calculateUniqueWays(int n)
    {
        if(n < 1)
            return 0;
        if(n == 1 || n == 2)
            return n;

        int ways1 = 1, ways2 = 2, result = 0;

        for(int i = 3; i <= n; i++)
        {
            result = ways1 + ways2;

            ways1 = ways2;
            ways2 = result;
        }
        return result;
    }

    public static int calculateUniqueWaysForX(int n, int[] x)
    {
        if(n <= 0)
            return 0;

        int[] numberOfWays = new int[n + 1];
        numberOfWays[0] = 1;

        for(int stairNum = 1; stairNum <= n; stairNum++)
        {
            for(int stepSize : x)
            {
                if(stairNum >= stepSize)
                    numberOfWays[stairNum] += numberOfWays[stairNum - stepSize];
            }
        }
        return numberOfWays[n];
    }
}
