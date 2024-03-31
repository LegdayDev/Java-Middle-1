package lang.immutable.address;

public class PrimitiveMain {
    public static void main(String[] args) {
        // 기본형 : 절대로 같은 값을 공유하지 않는다.
        int a = 10;
        int b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b=20; // b 의 값을 변경해도 a의 영향이 없다.
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
