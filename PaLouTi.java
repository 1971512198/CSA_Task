
import java.util.Scanner;
public class PaLouTi {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n =sc.nextInt();
            System.out.println(climb(n));
        }
        public static int climb(int n){
            if(n == 1)
                return 1;
            if(n == 2)
                return 2;
            return climb(n - 1) + climb(n - 2);
        }
}

