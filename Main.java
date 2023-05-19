//测试主函数
import java.util.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        int flag = 0;
        //循环保证程序进行
        while(true){
            System.out.println("请输入你的选择");
            System.out.println("1、添加学生信息");
            System.out.println("2、查询学生信息");
            System.out.println("3、更改学生信息");
            System.out.println("4、删除学生信息");
            System.out.println("5、班级成绩查询");
            System.out.println("6、退出");
            Scanner in = new Scanner(System.in);
            int s = in.nextInt();
            //按照输入选择功能
            switch (s){
                case 1:
                {
                    list.add(sadd());
                    break;
                }
                case 2:
                {
                    System.out.println("请输入查询学生学号");
                    String sid = in.next();
                    search(sid, list);
                    break;
                }
                case 3:
                {
                    System.out.println("请输入修改学生的学号");
                    String sid = in.next();
                    alter(sid, list);
                    break;
                }
                case 4:
                {
                    System.out.println("请输入删除学生的学号");
                    String sid = in.next();
                    del(sid, list);
                    break;
                }
                case 5:
                {
                    int flag2 = 0;
                    //第二个菜单功能
                    while(true){
                        System.out.println("请输入你的选择");
                        System.out.println("1、查询学生平均成绩");
                        System.out.println("2、查询学生不及格比例");
                        System.out.println("3、查询学生及格比例");
                        System.out.println("4、查询学生优良比例");
                        System.out.println("5、退出");
                        int s1 = in.nextInt();
                        switch (s1){
                            case 1: {
                                avr(list);
                                break;
                            }
                            case 2:{
                                notpass(list);
                                break;
                            }
                            case 3:{
                                pass(list);
                                break;
                            }
                            case 4:{
                                goodpass(list);
                                break;
                            }
                            case 5:{
                                flag2 = 1;
                                break;
                            }
                            default:
                                System.out.println("操作有误，请重新输入！");
                        }
                        if(flag2 == 1)
                            break;
                    }
                }
                case 6:{
                    flag = 1;
                    break;
                }
                default:
                    System.out.println("操作有误，请重新输入！");
            }
            if(flag == 1)
                break;
        }
    }
    //添加学生信息
    public static Student sadd(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入添加学生的姓名:");
        String name = in.next();
        System.out.println("请输入添加学生学号:");
        String id = in.next();
        System.out.println("请输入添加学生的语文成绩:");
        double chinesescore = in.nextDouble();
        System.out.println("请输入添加学生的数学成绩:");
        double mathscore = in.nextDouble();
        Student student = new Student(name, id, chinesescore, mathscore);
        System.out.println("学生信息添加成功！");
        return student;
    }
    //查询学生信息
    public static void search(String sid, ArrayList<Student> list){
        int flag = 0;
        for (int i = 0; i < list.size(); i++) {
            if(sid.equals(list.get(i).getID())) {
                System.out.println("查询成功！");
                System.out.println("姓名:" + list.get(i).getName() + "\n" + "学号:" + list.get(i).getID() + "\n" + "语文成绩:" + list.get(i).getChineseScore() + "\n" + "数学成绩:" + list.get(i).getMathScore());
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            System.out.println("查无此人！");
    }
    //更改学生信息
    public static void alter(String sid, ArrayList<Student> list){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < list.size(); i++) {
            if(sid.equals(list.get(i).getID())){
                System.out.println("请输入学生姓名");
                String sname = in.next();
                list.get(i).setName(sname);
                System.out.println("请输入学生学号");
                String said = in.next();
                list.get(i).setID(said);
                System.out.println("请输入学生语文成绩");
                double sch = in.nextDouble();
                list.get(i).setChineseScore(sch);
                System.out.println("请输入学生数学成绩");
                double sma = in.nextDouble();
                list.get(i).setMathScore(sma);
            }
        }
    }
    //删除学生信息
    public static void del(String sid, ArrayList<Student> list){
        for (int i = 0; i < list.size(); i++) {
            if(sid.equals(list.get(i).getID())){
                list.remove(i);
            }
        }
    }
    //班级平均成绩
    public static void avr(ArrayList<Student> list) {
        double average = 0;
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getChineseScore() + list.get(i).getMathScore();
        }
        average = sum / list.size();
        System.out.println("班级平均成绩为: " + average);
    }
    //不及格比例
    public static void notpass(ArrayList<Student> list) {
        int chnotpass = 0;
        int manotpass = 0;
        for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getChineseScore() < 60)
                    chnotpass++;
                if(list.get(i).getMathScore() < 60)
                     manotpass++;
        }
        System.out.printf("语文的不及格比例为%.2f%%", ((double)chnotpass / list.size()) * 100);
        System.out.println();
        System.out.printf("数学的不及格比例为%.2f%%",  ((double)manotpass / list.size()) * 100);
        System.out.println();
    }
    //及格比例
    public static void pass(ArrayList<Student> list) {
        int chpass = 0;
        int mapass = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getChineseScore() >= 60)
                chpass++;
            if(list.get(i).getMathScore() >= 60)
                mapass++;
        }
        System.out.printf("语文的及格比例为%.2f%%", ((double)chpass / list.size()) * 100);
        System.out.println();
        System.out.printf("数学的及格比例为%.2f%%",  ((double)mapass / list.size()) * 100);
        System.out.println();
    }
    //优良比例
    public static void goodpass(ArrayList<Student> list) {
        int chgood = 0;
        int magood = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getChineseScore() >= 60)
                chgood++;
            if(list.get(i).getMathScore() >= 60)
                magood++;
        }
        System.out.printf("语文的优良比例为%.2f%%", ((double)chgood / list.size()) * 100);
        System.out.println();
        System.out.printf("数学的优良比例为%.2f%%",  ((double)magood / list.size()) * 100);
        System.out.println();
    }
}
