package algorithm;

public class Fibonacci3 {
    public static void main(String[] args) {
        System.out.println(addNum(3));
    }
    public static int addNum(int num){
        if(num == 1){
            return 1;
        } else if (num == 2) {
            return 2;
        } else {
            return addNum(num-1) + addNum(num-2);
        }
    }
}
