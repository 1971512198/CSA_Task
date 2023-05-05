import com.sun.deploy.util.StringUtils;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请选择测试哪一题");
        int num = in.nextInt();
        switch (num){
            case 1:{
                System.out.println("<-------第一题------->");
                Monkey monkey = new Monkey("猴子");
                People people = new People();
                monkey.speak();
                people.speak();
                people.think();
                break;
            }
            case 2:{
                System.out.println("<-------第二题------->");
                System.out.println("请输入小车实载几人");
                Car car = new Car(in.nextInt());
                System.out.println(("请输入卡车实载几人，载重多少"));
                Truck truck = new Truck(in.nextInt(), in.nextDouble());
                car.test();
                System.out.println("------------------------");
                truck.test();
                break;
            }
            case 3:{
                System.out.println("<-------第三题------->");
                System.out.print("a=");
                String a = in.next();
                System.out.print("b=");
                String b = in.next();
                System.out.println("c=" + getSum(a, b));
                break;

            }
            case 4:{
                System.out.println("<-------第四题------->");
                int m = in.nextInt();
                int n = in.nextInt();
                System.out.println(uniquePaths(m, n));
                break;
            }
            case 5:{
                System.out.println("<-------第五题------->");
                System.out.println("请输入长度为3的字符串数组");
                String []strs = new String[3];
                for (int i = 0; i < 3; i++) {
                    strs[i] = in.next();
                }
                System.out.println(longestCommonPrefix(strs));
                break;
            }
            default:
                System.out.println("请正确输入编号！");
        }
    }
    //大数相加
    public static String  getSum(String a,String b){
        List<Integer> la = new ArrayList<Integer>();
        List<Integer> lb = new ArrayList<Integer>();
        String c = "";
        for(int i = a.length() - 1;i >= 0;--i){
            la.add(a.charAt(i) - '0');
        }
        for(int i = b.length() - 1;i >= 0;--i){
            lb.add(b.charAt(i) - '0');
        }
        int len;
        int i = 0;
        int j = 0;
        int k = 0;
        int y = 0;
        if(a.length() >= b.length())
            len = a.length() + 1;
        else
            len= b.length() + 1;
        int lc[] = new int[len];
        while(i <= a.length() - 1 && j <= b.length() - 1){
            if(la.get(i) + lb.get(j) + y >= 10){
                lc[k] = la.get(i) + lb.get(j) + y - 10;
                y = 1;
            }
            else {
                lc[k] = la.get(i) + lb.get(j) + y;
                y = 0;
            }
            i++;
            j++;
            k++;
        }
        if(a.length() < b.length()){
            for (int l = a.length(); l < len - 1; l++) {
                if(lb.get(l) + y >= 10) {
                    lc[l] = lb.get(l) + y - 10;
                    y = 1;
                }
                else {
                    lc[l] = lb.get(l) + y;
                    y = 0;
                }
            }
        }
        else{
            for (int l = b.length(); l < len - 1; l++) {
                if(la.get(l) + y >= 10) {
                    lc[l] = la.get(l) + y - 10;
                    y = 1;
                }
                else {
                    lc[l] = la.get(l) + y;
                    y = 0;
                }
            }
        }
        if(y == 1) {
            lc[len - 1] = 1;
            for (int m = lc.length - 1; m >= 0; m--) {
                c = c + lc[m];
            }
        }
        else
            for (int m = lc.length - 2; m >= 0; m--) {
                c = c + lc[m];
            }
        return c;
    }
    //动态规划
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <= m; i++)
            dp[i][1] = 1;
        for(int i = 1; i <= n; i++)
            dp[1][i] = 1;
        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++)
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
        }
        return dp[m][n];
    }
    //相同前缀截取
    public static String longestCommonPrefix(String [] strs) {
        String ans = "";
        int len = strs.length;
        String min = "";
        for (int i = 0; i < len - 1; i++) {
            if(strs[i].length() > strs[i + 1].length()){
                min = strs[i + 1];
                strs[i + 1] = strs [i];
                strs[i] = min;
            }

        }
        for(int i = 0;i < strs[0].length();i++){
            int j = 0;
            int k = 0;
            while(j + 1 < len){
                if(strs[0].charAt(i) == strs[j + 1].charAt(i)){
                    k++;
                }
                j++;
                if(k == strs.length - 1)
                    ans += strs[0].charAt(i);
            }
        }
        return ans;
    }
}
class Monkey{
    private String name;

    public Monkey() {
    }

    public Monkey(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void  speak (){
        System.out.println("咿咿呀呀 ......");
    }
}
class People extends Monkey{
    public void  speak (){
        System.out.println("小样儿，不错嘛！会说话了！");
    }
    public void think(){
        System.out.println("别说话！认真思考！");
    }
}
class Vehicle{
    private int wheels;
    private double weight;
    public Vehicle() {
    }
    public Vehicle(int wheels, double weight) {
        this.wheels = wheels;
        this.weight = weight;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void test(){
        System.out.println("车轮的个数是:" + wheels + "\t" + "车重:" + weight);
    }
}
class Car extends Vehicle{
    private int loader;
    public Car() {
    }
    public Car(int loader) {
        this.loader = loader;
    }
    public int getLoader() {
        return loader;
    }
    public void setLoader(int loader) {
        this.loader = loader;
    }
    public void test(){
        Vehicle vehicle = new Vehicle(4, 1150.0);
        System.out.println("车轮的个数是:" + vehicle.getWheels() + "\t" + "车重:" + vehicle.getWeight());
        if(loader >= 6 )
            System.out.println("这是一辆小车，能载6人，实载" + loader + "人，你超员了！！！");
        else if(loader < 0)
            System.out.println("输入错误！");
        else
            System.out.println("这是一辆小车，能载6人，实载" + loader + "人");
    }
}
class Truck extends Vehicle{
    private int loader;
    private double payloader;
    public Truck() {
    }
    public Truck(int loader, double payloader) {
        this.loader = loader;
        this.payloader = payloader;
    }
    public int getLoader() {
        return loader;
    }
    public void setLoader(int loader) {
        this.loader = loader;
    }
    public double getPayloader() {
        return payloader;
    }
    public void setPayloader(double payloader) {
        this.payloader = payloader;
    }
    public void test() {
        Vehicle vehicle = new Vehicle(6, 15000.0);
        System.out.println("车轮的个数是:" + vehicle.getWheels() + "\t" + "车重:" + vehicle.getWeight());
        if(loader < 3 && payloader < 5000) {
            System.out.println("这是一辆卡车，能载3人，实载" + loader + "人");
            System.out.println("这是一辆卡车，核载5000kg，你已装载" + payloader + "kg");
        }
        if(loader >= 3 && payloader < 5000){
            System.out.println("这是一辆卡车，能载3人，实载" + loader + "人，你超员了！！！");
            System.out.println("这是一辆卡车，核载5000kg，你已装载" + payloader + "kg");
        }
        if(loader < 3 && payloader >= 5000){
            System.out.println("这是一辆卡车，能载3人，实载" + loader + "人");
            System.out.println("这是一辆卡车，核载5000kg，你已装载" + payloader + "kg,你超载了！！！");
        }
        if(loader >= 3 && payloader >= 5000){
            System.out.println("这是一辆卡车，能载3人，实载" + loader + "人，你超员了！！！");
            System.out.println("这是一辆卡车，核载5000kg，你已装载" + payloader + "kg,你超载了！！！");
        }
    }
}