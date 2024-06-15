package exception.basic.checked;

public class Client {
    public void call() throws MyCheckedException { // 예외를 던진다. - throws
        // 문제 상황 발생하여 예외를 발생 - throw
        throw new MyCheckedException("Ex!");
    }
}
