package lang.string.immutable;

public class StringImmutable2 {
    public static void main(String[] args) {
        String str = "hello";
        String str2 = str.concat(" java"); // String 은 불변객체기 때문에 String 타입의 반환값이 있다 !!
        System.out.println("str2 = " + str2);
    }
}
