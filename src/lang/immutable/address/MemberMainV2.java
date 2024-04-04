package lang.immutable.address;

/**
 * <h2>가변객체인 Address 를 공유하는 경우</h2>
 */
public class MemberMainV2 {
    public static void main(String[] args) {
        ImmutableAddress address = new ImmutableAddress("서울");

        MemberV2 memberA = new MemberV2("회원A", address);
        MemberV2 memberB = new MemberV2("회원B", address);

        // 회원A , 회원B 의 처음 주소는 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 요구사항 변경 !! : 회원B의 주소를 부산으로 변경
        // memberB.getAddress().setValue("부산"); 컴파일오류 !!
        memberB.setAddress(new ImmutableAddress("부산")); // 새로운 객체를 만들어 설정해야 한다 !!

        // 다시 출력
        System.out.println("memberB.address -> 부산으로 변경");
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);
    }
}
