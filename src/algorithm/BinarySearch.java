package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numArr = {1,2,3,4,5};
        System.out.println(binarySearch(0, numArr));
    }
    public static int binarySearch(int number,int[] numArr){
        int max = numArr.length-1;
        int min = 0;
        while(true){
            if(min > max){
                return -1;
            }
            int mid = (max+min)/2;
            if(number < numArr[mid]){
                max = mid-1;
            } else if(number > numArr[mid]) {
                min = mid+1;
            } else {
                return mid;
            }
        }
    }
}
