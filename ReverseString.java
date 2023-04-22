import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        reverseString(str);
    }

    public static void reverseString(String str) {
        char[] chars = str.toCharArray();
        int n = str.length();
        char ch[] = new char[n];
        int j = n - 1;
        for (int i = 0; i < chars.length; i++) {
            ch[j] = chars[i];
            j--;
        }
        String s1 = String.valueOf(ch);
        System.out.println(s1);
    }
}
