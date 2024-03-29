package lang.object.tostring;

public class ToStringMain2 {
    public static void main(String[] args) {
        Car car = new Car("Model Y");
        Dog dog1 = new Dog("뽀삐", 2);
        Dog dog2 = new Dog("삐삐", 5);

        System.out.println(car.toString());
        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        // Object 다형성 활용
        ObjectPrinter.print(car);
        ObjectPrinter.print(dog1);
        ObjectPrinter.print(dog2);
        
        // 객체의 참조값 직접 출력
        String refValue = Integer.toHexString(System.identityHashCode(dog1)); // 참조값을 16진수로 변환 !
        System.out.println("refValue = " + refValue);

    }
}
