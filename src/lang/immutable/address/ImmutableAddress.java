package lang.immutable.address;

public class ImmutableAddress {

    final private String value; // value 필드를 변하지못하게 final 로 막는다.

    public ImmutableAddress(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Address{" +
                "value='" + value + '\'' +
                '}';
    }
}
