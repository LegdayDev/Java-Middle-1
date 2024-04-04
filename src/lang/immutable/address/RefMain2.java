package lang.immutable.address;

public class RefMain2 {
    public static void main(String[] args) {
        ImmutableAddress a = new ImmutableAddress("Manchester");
        ImmutableAddress b = a; // 참조값 대입을 막을 수 있는 방법은 없다!!(Java 문법상 문제없음)

        System.out.println("a = " + a);
        System.out.println("b = " + b);

//        b.setValue("London"); // 컴파일에러 !! setValue() 메서드가 없기 떄문에 수정불가 !!
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
