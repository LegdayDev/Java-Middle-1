package lang.immutable.address;

/**
 * <h2>가변객체인 Address 를 공유하는 경우</h2>
 */
public class MemberMainV1 {
    public static void main(String[] args) {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("회원A", address);
        MemberV1 memberB = new MemberV1("회원B", address);

        // 회원A , 회원B 의 처음 주소는 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 요구사항 변경 !! : 회원B의 주소를 부산으로 변경
        memberB.getAddress().setValue("부산");

        // 다시 출력
        System.out.println("memberB.address -> 부산으로 변경");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
