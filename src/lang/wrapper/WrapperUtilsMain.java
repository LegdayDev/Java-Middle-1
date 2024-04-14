package lang.wrapper;

public class WrapperUtilsMain {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10); // Primitive -> Wrapper
        Integer i2 = Integer.valueOf("10"); // String -> Wrapper

        int i3 = Integer.parseInt("10"); // String -> Primitive

        // 비교
        int compareResult = i1.compareTo(20); // 10 과 20을 비교하기 때문에 왼쪽값 기준으로 결과 출력
        System.out.println("compareResult = " + compareResult);

        // 산술연산
        System.out.println("sum: " + Integer.sum(10, 20));
        System.out.println("min: " + Integer.min(10, 20));
        System.out.println("max: " + Integer.max(10, 20));
    }
}
