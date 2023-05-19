//学生类
public class Student {
    private String name;
    private String ID;
    private double ChineseScore;
    private double MathScore;
    public Student() {
    }
    public Student(String name, String ID, double chineseScore, double mathScore) {
        this.name = name;
        this.ID = ID;
        ChineseScore = chineseScore;
        MathScore = mathScore;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public double getChineseScore() {
        return ChineseScore;
    }
    public void setChineseScore(double chineseScore) {
        ChineseScore = chineseScore;
    }
    public double getMathScore() {
        return MathScore;
    }
    public void setMathScore(double mathScore) {
        MathScore = mathScore;
    }
    public double sum(){
        return getChineseScore() + getMathScore();
    }
}