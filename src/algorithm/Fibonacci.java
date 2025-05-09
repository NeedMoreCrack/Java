package algorithm;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(sumAdd(1));
    }
    public static int sumAdd(int num){
        if(num == 10){
            return 1;
        } else {
            return (sumAdd(num+1)+1)*2;
        }
    }
}
