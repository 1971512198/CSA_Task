import java.util.Scanner;
public class HuiwenJudge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        isPalindrome(num);
    }
    public static void isPalindrome(int num) {
        boolean flag = false;
        int sum = 0;
        int m;
        int a = num;
        while(num != 0){
            m = num % 10;
            sum = sum * 10 +m;
            num = (num - m) / 10;
        }
        if(a == sum)
            flag = true;

        if (flag)
            System.out.println("是的");

        else
            System.out.println("不是");
    }
}
