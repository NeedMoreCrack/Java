package algorithm;

public class BasicSearch {
    public static void main(String[] args) {
        int[] numArr = {131,127,147,81,103,23,7,79};
        int findNum = 81;
        System.out.println(basicSearch(findNum, numArr));
    }
    public static String basicSearch(int findNum,int[] numArr){
        for (int i = 0; i < numArr.length; i++) {
            if(findNum == numArr[i]){
                return "找到："+numArr[i]+"\n索引值："+i;
            }
        }
        return findNum+"不在此陣列中";
    }
}
