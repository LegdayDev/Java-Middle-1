package lang.string.builder;

public class LoopStringBuilderMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // 현재 ms 시간을 얻는다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello Java ");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("time" + (endTime - startTime) + "ms");
    }
}
