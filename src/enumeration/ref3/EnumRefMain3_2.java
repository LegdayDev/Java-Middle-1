 package enumeration.ref3;

public class EnumRefMain3_2 {
    public static void main(String[] args) {
        int price = 10000;

        System.out.println("BASIC 등급의 할인 금액: " + Grade.BASIC.dicount(price));
        System.out.println("GOLD 등급의 할인 금액: " + Grade.GOLD.dicount(price));
        System.out.println("DIAMOND 등급의 할인 금액: " + Grade.DIAMOND.dicount(price));
    }
}
