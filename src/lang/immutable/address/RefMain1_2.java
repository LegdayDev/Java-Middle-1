package lang.immutable.address;

public class RefMain1_2 {
    public static void main(String[] args) {
        // 참조형 : 하나의 인스턴스를 공유한다.
        Address a = new Address("서울"); // x001
        Address b = new Address("서울"); // x002

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b.setValue("부산");
        System.out.println("a = " + a); // 사이드 이펙트가 발생하지 않는다 !
        System.out.println("b = " + b);
    }
}
