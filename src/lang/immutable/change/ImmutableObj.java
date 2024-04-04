package lang.immutable.change;

public class ImmutableObj {
    private final int value;

    public ImmutableObj(int value) {
        this.value = value;
    }

    public ImmutableObj add(int addValue){
        // 기존의 있던 value 값은 유지된다 !! 새로운 객체를 반환
        return new ImmutableObj(value + addValue);
    }

    public int getValue() {
        return value;
    }
}
