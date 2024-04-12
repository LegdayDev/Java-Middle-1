package lang.wrapper;

public class MyIntegerNullMain0 {
    public static void main(String[] args) {
        int[] intArr = {-1, 0, 1, 2, 3};

        System.out.println(findValue(intArr, -1)); // -1 이 있으니까 반환
        System.out.println(findValue(intArr, 0));
        System.out.println(findValue(intArr, 1));
        System.out.println(findValue(intArr, 100)); // 100은 없으므로 -1 반환
    }

    private static int findValue(int[] intArr, int target) {
        for (int value : intArr) {
            if (value == target) return value;
        }
        return -1; // 뭐라도 반환해야 한다.
    }
}
