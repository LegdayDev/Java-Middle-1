package lang.string.test;

public class TestString11 {
    public static void main(String[] args) {
        String str = "Hello Java";
        StringBuilder sb = new StringBuilder();
        str = sb.append(str).reverse().toString();
        System.out.println(str);
    }
}