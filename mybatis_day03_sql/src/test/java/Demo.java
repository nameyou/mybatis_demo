import java.util.ArrayList;
import java.util.Calendar;

public class Demo {
    public static void main(String[] args) {
        /*
            获取最值
         */
//        getValue(1, 2, 3, "大");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2020);





    }

    private static void getValue(int i, int i1, int i2, String str) {
        if (str.equals("大")) {
            // TODO 调用获取最大值的方法
            System.out.println(str);
        } else if (str.equals("小")) {
            // TODO 调用获取最小值的方法
            System.out.println(str);
        } else {
            System.out.println("输入字符不合法。。。");
        }
    }
}
