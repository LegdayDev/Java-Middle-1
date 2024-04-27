## 자바 중급 1편

### 불변 객체 학습
> 1. 불변 객체 - 도입
> 2. 불변 객체 - 예제
> 3. 불변 객체 - 값 변경
> 4. 정리
---
### 불변 객체 - 도입
> 객체의 공유 자체는 자바에서 컴파일 에러를 내지 않는다! 왜냐하면 **공유 자체에는 문제가 없기 때문이다.**
> 문제의 ***직접적인 원인은 공유된 객체의 값을 변경***하는것이 원인이다.

#### 불변 객체의 도입
- **객체의 상태(객체 내부의 값, 필드 멤버 변수)가 변하지 않는 객체**를 `불변 객체(Immutable Object)`라 한다.
- 이전의 만든 [Address 클래스](https://github.com/LegdayDev/Java-Middle-1/blob/master/src/lang/immutable/address/Address.java) 를 상태가 변하지 않는 불변 클래스로 만든다.
  - `value` 필드를 수정못하게 `final` 로 바꿨다.(필드 수정이 안되기 때문에 `setValue()` 메서드도 삭제)
  - 꼭 final 키워드가 아니더라도 필드를 수정못하게 바꾸기만 하면된다 !!
      ```java
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
      ```
- 만약 다른개발자 객체를 공유하여 필드를 변경할려고 하면 에러가 뜰 것이다.
    ```java
    public class RefMain2 {
        public static void main(String[] args) {
            ImmutableAddress a = new ImmutableAddress("Manchester");
            ImmutableAddress b = a; // 참조값 대입을 막을 수 있는 방법은 없다!!(Java 문법상 문제없음)
    
            System.out.println("a = " + a);
            System.out.println("b = " + b);
    
    //        b.setValue("London"); // 컴파일에러 !! setValue() 메서드가 없기 떄문에 수정불가 !!
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
    ```
  ![img.png](../resources/images/chap02/img08.png)
- 그렇게 되면 개발자는 새로운 객체를 만들어 사용하게 된다

    ![img.png](../resources/images/chap02/img09.png)
- _**불변이라는 단순한 제약을 사용하여 사이드 이펙트를 막을 수 있다 !**_
> `가변(Mutable)객체` 와 `불변(Immutable)객체` </br>가변은 이름 그대로 처음 만든 이후 상태가 변할 수 있고, 불변은 처음 만든 이후 상태가 변하지 않는 뜻이다.
---
### 2. 불변 객체 - 예제
- 우선 가변(Mutable)객체인 Address 를 공유하는 예제 코드이다.
  ```java
  public class MemberV1 {
      private String name;
      private Address address;
  
      public MemberV1(String name, Address address) {
          this.name = name;
          this.address = address;
      }
  
      public Address getAddress() {
          return address;
      }
  
      public void setAddress(Address address) {
          this.address = address;
      }
  
      @Override
      public String toString() {
          return "MemberV1{" +
                  "name='" + name + '\'' +
                  ", address=" + address +
                  '}';
      }
  }
  
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
  ```
  ![img.png](../resources/images/chap02/img10.png)
- **가변객체를 사용할 때 공유객체의 필드를 변경할 때 사이드 이펙트가 발생**한다.
- 아래 코드는 불변(Immutable)객체인 ImmutableAddress 를 공유하는 예제이다.
  ```java
  public class MemberV2 {
      private String name;
      private ImmutableAddress address;
  
      public MemberV2(String name, ImmutableAddress address) {
          this.name = name;
          this.address = address;
      }
  
      public ImmutableAddress getAddress() {
          return address;
      }
  
      public void setAddress(ImmutableAddress address) {
          this.address = address;
      }
  
      @Override
      public String toString() {
          return "MemberV2{" +
                  "name='" + name + '\'' +
                  ", address=" + address +
                  '}';
      }
  }
  
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
  ```
  ![img.png](../resources/images/chap02/img11.png)
- 불변객체의 값을 변경할 수 없어서 새로운 객체를 넣어서 변경했다. 즉, 사이드 이펙트를 막았다 !!
---
### 3. 불변 객체 - 값 변경
> 이전까지 공유객체의 값 변경에 따르는 사이드이펙트를 막기위해 불변객체를 사용했다. 만약 _불변객체를 사용하지만 꼭 값을 변경해야 하는 경우가 있다!!_- 

- 아래 코드는 불변객체의 값을 변경할 수 있는 add() 라는 메서드를 구현하고 기존의 값을 유지해서 불변객체의 특성을 지키는 클래스이다.
  ```java
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
  ```
  - `add()` 메서드를 통해 `value` 값을 증가시키게 되면 ***기존의 value 를 더하는게 아닌 value 를 더한값을 가지는 객체를 만들어 반환***시켜준다.
  - 즉, **원래 있던 value 필드는 변경하지 않기 떄문에 불변을 유지가능**하게 된다.
- 테스트를 해보면 기존의 값을 더해서 새로운 객체를 받으면 기존값과 신규값 둘 다 확인가능하다.
  ```java
  public class ImmutableMain {
      public static void main(String[] args) {
          ImmutableObj obj1 = new ImmutableObj(10);
          ImmutableObj obj2 = obj1.add(20);
  
          // 계산 이후에도 기존 값과 신규값 확인가능
          System.out.println("obj1.getValue() = " + obj1.getValue());
          System.out.println("obj.getValue() = " + obj2.getValue());
      }
  }
  ```
  ![img.png](../resources/images/chap02/img12.png)
- 실행 순서를 메모리 구조로 확인해보면 아래와 같다.

  ![img.png](../resources/images/chap02/img13.png)
---
### 4. 정리
> 이전까지 불변객체의 내용을 중요하게 얘기하고 많이 했던 이유는 `String` 클래스 떄문이다.</br>
> 자바에서 가장 많이 사용되는 `String` 클래스가 불변객체이다.

- 클래스를 불변으로 설계하는 이유는 더 많다.
  - 캐시 안정성
  - 멀티 쓰레드 안정성
  - Entity 값 타입(JPA 에서 사용)