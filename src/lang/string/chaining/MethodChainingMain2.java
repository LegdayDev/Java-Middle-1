package lang.string.chaining;

public class MethodChainingMain2 {
    public static void main(String[] args) {
        ValueAdder adder = new ValueAdder();
        ValueAdder adder1 = adder.add(1);
        ValueAdder adder2 = adder1.add(2);
        ValueAdder adder3 = adder2.add(3);

        System.out.println("adder3.getValue() = " + adder3.getValue());

        System.out.println("adder 참조값 : " +adder);
        System.out.println("adder1 참조값 : " +adder1);
        System.out.println("adder2 참조값 : " +adder2);
        System.out.println("adder3 참조값 : " +adder3);
    }
}
