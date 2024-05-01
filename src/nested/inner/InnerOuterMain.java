package nested.inner;

public class InnerOuterMain {
    public static void main(String[] args) {
        InnerOuter outer = new InnerOuter();

        // 생성할 때는 인스턴스가 필요하다.
        InnerOuter.Inner inner = outer.new Inner();

        inner.print();
    }
}
