package thread.homework4;

public class RedEnvelope implements Runnable{
    static int money = 100;//總金額
    static double l1 = Math.random();//獲取隨機機率
    static double l2 = Math.random();//獲取隨機機率
    static double min = Math.min(l1,l2);//取小
    static double max = Math.max(l1,l2);//取大

    static double probabilityA = min;
    static double probabilityB = max-min;

    static int getMoneyA = (int) Math.round(probabilityA * money);
    static int getMoneyB = (int) Math.round(probabilityB * money);
    static int getMoneyC = (int) (money - getMoneyB - getMoneyA);//用總金額減去前兩名的金額  防止出現101或99
    @Override
    public void run() {
        try{
               
        }finally {

        }
    }
}
