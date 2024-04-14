package lang.system;

import java.util.Arrays;

public class SystemMain {
    public static void main(String[] args) {
        // 현재 시간(ms)
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis + " ms");

        // 현재 시간(nano)
        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano + " nano");

        // 환경 변수를 읽는다.
        System.out.println("\ngetenv = " + System.getenv());

        // 시스템 속성을 읽는다(Java 가 사용하는 시스템 속성)
        System.out.println("\nproperties = " + System.getProperties());
        System.out.println("\nJava version: " + System.getProperty("java.version"));

        // 배열을 고속으로 복사(기존 복사는 인덱스 하나하나 접근했지만 고속복사는 한꺼번에 복사하기 때문에 2배 이상 빠르다)
        char[] originalArray = {'h', 'e', 'l', 'l', 'o' };
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);

        // 배열 출력(그냥 출력하면 참조값이 나오기 때문에 Arrays.toString()으로 감싸서 출력)
        System.out.println("\ncopiedArray = " + Arrays.toString(copiedArray));

        // 프로그램 종료
        System.exit(0);
    }
}
