package nested;

public class ShadowingMain {
    public int value = 1;

    class Inner {
        public int value = 2;

        void go() {
            int value = 3;
            System.out.println("value = " + value); // 지역변수가 우선순위를 잡는다.
            System.out.println("this.value = " + this.value); // 자신의 인스턴스 멤버 전근
            System.out.println("ShadowingMain.this.value = " + ShadowingMain.this.value); // 바깥 클래스 인스턴스 멤버 전근
        }
    }

    public static void main(String[] args) {
        ShadowingMain main = new ShadowingMain();
        Inner inner = main.new Inner();
        inner.go();
    }
}
