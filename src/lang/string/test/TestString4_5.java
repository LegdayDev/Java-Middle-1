package lang.string.test;

public class TestString4_5 {
    public static void main(String[] args) {
        String str = "hello.txt";

        String filename = str.substring(0, str.indexOf(".txt"));
        String extName = str.substring(str.indexOf(".txt"));
        System.out.println(filename);
        System.out.println(extName);
    }
}
