package lang.string.test;

public class TestString2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            len += arr[i].length();
            System.out.println(arr[i] + ":" + arr[i].length());
        }
        System.out.println("sum = " + len);
    }
}
