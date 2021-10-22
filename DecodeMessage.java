
/**
 * DCP : Problem #7 [Medium]
 * This problem was asked by Facebook.
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decode-able. For example, '001' is not allowed.
 */

public class DecodeMessage {
    public static void main(String[] args) {
        String message = "12721";

        int result = calculateDecodingWays(message);
        System.out.println("Number of ways to decode " + message + " = " + result);
    }

    public static int calculateDecodingWays(String message)
    {
        int ways1 = (message.charAt(0) == '0') ? 0 :1;
        int ways2 = 1;

        for(int i = 1; i < message.length(); i++)
        {
            int waysCurr = 0;
            int oneDigit = Integer.parseInt(message.substring(i, i + 1));
            int twoDigits = Integer.parseInt(message.substring(i - 1, i + 1));

            if(oneDigit > 0)
                waysCurr += ways1;
            if(twoDigits > 9 && twoDigits < 27)
                waysCurr += ways2;

            ways2 = ways1;
            ways1 = waysCurr;
        }

        return ways1;
    }

/*    public static int calculateDecodingWays(String message)
    {
        int[] ways = new int[message.length() + 1];
        ways[0] = 1;
        ways[1] = (message.charAt(0) == '0') ? 0 :1;

        for(int i = 2; i <= message.length(); i++)
        {
            if(Integer.parseInt(message.substring(i - 1, i)) > 0)
                ways[i] += ways[i - 1];
            if(Integer.parseInt(message.substring(i - 2, i)) > 9 && Integer.parseInt(message.substring(i - 2, i)) < 27)
                ways[i] += ways[i - 2];
        }
        return ways[message.length()];
    }

 */
}
