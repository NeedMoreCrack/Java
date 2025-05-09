package algorithm;

public class BlockSearch {
    public static void main(String[] args) {
        int[] arr = {16,5,9,12,21,18,
                     32,23,37,26,45,34,
                     50,48,61,52,73,66};
        Block b1 = new Block(21,0,5);
        Block b2 = new Block(45,6,11);
        Block b3 = new Block(73,12,17);

        Block[] blockArr = {b1,b2,b3};

        int number = 30;

        int index = getIndex(blockArr,arr,number);
        System.out.println(index);
    }
    private static int getIndex(Block[] blockArr,int[] arr,int number){

        int indexBlock = findIndexBlock(blockArr,number);

        if (indexBlock == -1){
            return -1;
        }

        int startIndex = blockArr[indexBlock].getStartIndex();
        int exdIndex = blockArr[indexBlock].getEndIndex();

        for (int i = startIndex; i < exdIndex; i++) {
            if(arr[i] == number){
                return i;
            }
        }
        return -1;
    }

    public static int findIndexBlock(Block[] blockArr,int number){
        for (int i = 0; i < blockArr.length; i++) {
            if(number <= blockArr[i].getMax()){
                return i;
            }
        }
        return -1;
    }
}

class Block {
    private int max;
    private int startIndex;
    private int endIndex;

    public Block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}