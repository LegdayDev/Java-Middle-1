package lang.object;

// 명시적으로 상속을 받으므로 Object 를 상속받지 않는다.
public class Child extends Parent{
    public void childMethod(){
        System.out.println("Child.childMethod");
    }
}
