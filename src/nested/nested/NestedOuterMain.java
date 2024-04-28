package nested.nested;

public class NestedOuterMain {
    public static void main(String[] args) {
        NestedOuterMain outer = new NestedOuterMain();
        NestedOuter.Nested nested = new NestedOuter.Nested();

        nested.print();

        System.out.println("nestedClass = " + nested.getClass());
    }
}
