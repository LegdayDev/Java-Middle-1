package lang.immutable.address;

public class RefMain1_1 {
    public static void main(String[] args) {
        // 참조형 : 하나의 인스턴스를 공유한다.
        Address a = new Address("Manchester");
        Address b = a;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b.setValue("London");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
