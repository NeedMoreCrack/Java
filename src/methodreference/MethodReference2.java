package methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MethodReference2 {
    public static void main(String[] args) {
        /*
            把以下數字變為int類型
            List<String> al = new ArrayList<>();
            "1","2","3","4","5"
        */
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","4","5");
        list.stream().map(Integer::parseInt).forEach(System.out::println);
    }
}
