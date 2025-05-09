package algorithm;

public class Fibonacci2 {
    public static void main(String[] args) {
        System.out.println(ladder(20));
    }
    public static int ladder(int num){
       if(num == 1){
           return 1;
       } else if (num == 2) {
           return 2;
       } else if (num == 3) {
           return 3;
       } else {
           return ladder(num-1)+ladder(num-2)+ladder(num-3);
       }
    }
}
