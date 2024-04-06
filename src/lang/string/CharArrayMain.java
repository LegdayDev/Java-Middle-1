package lang.string;

public class CharArrayMain {
    public static void main(String[] args) {
        char a = 'a'; // 반드시 문자 1개만 담을 수 있다.
        System.out.println("a = " + a);

        // 여러개를 담기 위해 배열이 피룡
        char[] charArr = new char[]{'h', 'e', 'l', 'l', 'o'};
        System.out.println(charArr);

        // 문자열은 String 을 사용하는게 편하다.
        String str = "hello";
        System.out.println("str = " + str);
    }
}
