package lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random();

        int randomInt = random.nextInt();
        System.out.println("randomInt = " + randomInt);

        double randomDouble = random.nextDouble(); // 0.0d ~ 1.0d
        System.out.println("randomDouble = " + randomDouble);

        boolean randomBoolean = random.nextBoolean();
        System.out.println("randomBoolean = " + randomBoolean);

        // 범위 조회
        int randomRange1 = random.nextInt(10); // 0 ~ 9 까지
        System.out.println("0 ~ 9 사이 랜덤값 = " + randomRange1);

        int randomRange2 = random.nextInt(10) + 1; // 1 ~ 10 까지
        System.out.println("1 ~ 10 사이 랜덤값 = " + randomRange2);
    }
}
