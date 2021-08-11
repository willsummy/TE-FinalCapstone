// Java program for the above approach
import java.io.*;
class GFG {

    // Function to convert the jumbled
    // string into digits
    static String finddigits(String s)
    {

        // Strings of digits 0-9
        String[] num
                = { "zero", "one", "two",   "three", "four",
                "five", "six", "seven", "eight", "nine" };

        // Initialize vector
        int[] arr = new int[10];

        // Initialize answer
        String ans = "";

        // Size of the string
        int n = s.length();

        // Traverse the string
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'z')
                arr[0]++;
            if (s.charAt(i) == 'w')
                arr[2]++;
            if (s.charAt(i) == 'g')
                arr[8]++;
            if (s.charAt(i) == 'x')
                arr[6]++;
            if (s.charAt(i) == 'v')
                arr[5]++;
            if (s.charAt(i) == 'o')
                arr[1]++;
            if (s.charAt(i) == 's')
                arr[7]++;
            if (s.charAt(i) == 'f')
                arr[4]++;
            if (s.charAt(i) == 'h')
                arr[3]++;
            if (s.charAt(i) == 'i')
                arr[9]++;
        }

        // Update the elements of the vector
        arr[7] -= arr[6];
        arr[5] -= arr[7];
        arr[4] -= arr[5];
        arr[1] -= (arr[2] + arr[4] + arr[0]);
        arr[3] -= arr[8];
        arr[9] -= (arr[5] + arr[6] + arr[8]);

        // Print the digits into their
        // original format
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr[i]; j++) {
                ans += (char)(i + '0');
            }
        }

        // Return answer
        return ans;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String s = "owoftnuoer";
        System.out.println(finddigits(s));
    }
}