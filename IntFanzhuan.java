import java.util.Scanner;

public class IntFanzhuan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();
        char ch = num.charAt(0);
        int r = 0;
        if (ch == '-') {
            String[] temp = num.split("-");
            r = -getReverse(temp[1]);
        }
        else if (ch == '0') { // 0123 这种不允许哈 123
            r = 0;

        }
        else {
            r = getReverse(num);
        }
        System.out.println(r);

    }

    private static int getReverse(String s) {
        // 123 -> 321
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            r = r + num * (int)Math.pow(10, i);
        }
        return r;

    }
}