public class MaxMin {
    public static void main(String[] args) {
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        arraysDemo(array);
    }
    public static void arraysDemo(int array[]) {

        int max = array[0];
        int min = array[0];
        for(int i = 0;i < array.length;i++)
        {
            if(max < array[i])
                max = array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if(min > array[i])
                min = array[i];
        }
        int sum = max + min;
        System.out.println("打印两个最值 " + "max: " + max +" " + "min: " + min);
        System.out.println("max + min = " + sum);
    }
}
