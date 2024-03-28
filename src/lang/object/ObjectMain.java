package lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        // toString() 메서드는 Object 클래스의 메서드이다.
        // toString() 은 객체의 정보를 출력해준다.
        String string = child.toString();
        System.out.println("string = " + string);
    }
}
