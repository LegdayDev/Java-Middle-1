package exception.basic.checked;

/**
 * <h2>Exception 을 상속받은 예외는 체크 예외가 된다 !</h2>
 */
public class MyCheckedException extends Exception{
    public MyCheckedException(String message) {
        super(message);
    }
}
