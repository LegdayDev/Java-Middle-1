package lang.wrapper.test;

public class WrapperTest4 {
    public static void main(String[] args) {
        String str = "100";

        Integer integar1 = Integer.valueOf(str);
        int intValue = integar1;
        Integer integer2 = intValue;

        System.out.println("integar1 = " + integar1);
        System.out.println("intValue = " + intValue);
        System.out.println("integer2 = " + integer2);
    }
}
