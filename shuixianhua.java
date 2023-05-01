public class shuixianhua {
    public static void main(String[] args) {
        ShuiXianHua();
    }
    public static void ShuiXianHua() {
        for(int i = 100;i <= 999;i++){
            int a = i % 10;
            int b = ((i - a) / 10) % 10;
            int c = (((i - a) / 10) - b) / 10;
            if(i == a * a * a + b * b * b + c * c * c)
                System.out.print(i + " ");
        }
    }
}
