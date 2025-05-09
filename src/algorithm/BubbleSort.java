package algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numArr = {1,5,2,4,3};
        for (int i = 0; i < numArr.length-1; i++) {
            for (int j = 0; j < numArr.length-i-1; j++) {
                if(numArr[j] > numArr[j+1]){
                    int temp = numArr[j+1];
                    numArr[j+1] = numArr[j];
                    numArr[j] = temp;
                }
            }
        }
        for (int i : numArr) {
            System.out.print(i+" ");
        }
    }
}
