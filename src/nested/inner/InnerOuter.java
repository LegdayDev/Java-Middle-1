package nested.inner;

public class InnerOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    class Inner {
        private int innerInstanceValue = 1;

        public void print(){
            // 자기 자신 접근
            System.out.println(innerInstanceValue);

            // 외부클래스 인스턴스 멤버 접근
            System.out.println(outInstanceValue);

            // 외부클래스 스테틱 멤버 접근
            System.out.println(outClassValue);
        }
    }
}
