package lang.string.test;

public class TestString6 {
    public static void main(String[] args) {
        String str = "start hello java, hello spring, hello jpa";
        String key = ",";
        int index = 0;
        int count = 0;
        while (true) {
            index = str.indexOf(key, index + 1);
            if (index == -1) break;
            count++;
        }

        System.out.println("count = " + count);
    }
}
