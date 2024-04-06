package lang.string;

public class StringBasicMain {
    public static void main(String[] args) {
        String str1 = "hello"; // String 은 레퍼런스 타입
        String str2 = new String("hello"); // new 키워드로 생성 가능

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
    }
}
