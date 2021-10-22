/**
 * DCP : Problem #29 [Easy]
 * This problem was asked by Amazon.
 * Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 * Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 */

// Time complexity : O(n)
// Space complexity : O(1)

public class RunLengthEncodeDecode {
    public static void main(String[] args) {
        String s = "M";//"";//"AAAABBBCCDAA";
        String encodedString = encode(s);
        System.out.println("Encoded String : " + encodedString);

        String decodedString = decode(encodedString);
        System.out.println("Decoded String : " + decodedString);
    }

    public static String encode(String s)
    {
        if(s.length() == 0)
            return "";

        int i = 0, j = 0;
        StringBuilder encodedSb = new StringBuilder();

        while(j <= s.length())
        {
            if(j == s.length() || s.charAt(i) != s.charAt(j)) {
                encodedSb.append(j - i).append(s.charAt(i));
                i = j;
            }
            j++;
        }
        return encodedSb.toString();
    }

    public static String decode(String s)
    {
        StringBuilder decodedSb = new StringBuilder();

        for(int i = 0, j = 1; i < s.length() && j < s.length(); i += 2, j += 2)
        {
            int count = Integer.parseInt(Character.toString(s.charAt(i)));
            while(count > 0)
            {
                decodedSb.append(s.charAt(j));
                count--;
            }
        }
        return decodedSb.toString();
    }
}
