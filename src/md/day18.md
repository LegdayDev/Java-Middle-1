## 자바 중급 1편

## 중첩 클래스, 내부클래스 - 1
> 1. 중첩 클래스, 내부 클래스란?
> 2. 정적 중첩 클래스
> 3. 정적 중첩 클래스의 활용
---
## 1. 중첩 클래스, 내부 클래스란?
- 클래스 안에 클래스를 중첩해서 정의할 수 있는데, 이것을 `중첩 클래스(Nested Class)`라 한다.</br>
    ```java
    class Outer {
        // 중첩 클래스
        class Nested {
            
        }
    }
    ```
### 중첩 클래스의 분류
> 중첩 클래스는 총 4가지(정적 중첩, 내부, 지역, 익명)가 있고, 크게 2가지(정적 중첩, 내부)로 분류된다.
> 
> ![img.png](../resources/images/chap07/img01.png)

- **정적 중첩 클래스** : 정적 변수와 같이 앞에 `static` 이 붙어있다.
    ```java
    class Outer {
        ...
        // 정적 중첩 클래스
        static class StaticNested{
            ...
        }
    }
    ```
- **내부 클래스** : 인스턴스 변수와 같이 앞에 `static` 이 붙어있지 않다.
    ```java
    class Outer{
        ...
        // 내부 클래스
        class Inner {
            
        }
    }
    ```
- **지역 클래스** : 지역 변수와 같이 코드 블럭 안에서 클래스를 정의한다.
    ```java
    class Outer{
        public void process() {
            // 지역 변수
            int localVar = 0;
            
            // 지역 클래스
            class Local {...}
            
            Local local = new Local();
        }
    }
    ```
- **익명 클래스** : 지역 클래스와 똑같지만 이름이 없는 클래스이다.

#### 중첩(Nested) 과 내부(Inner)의 차이
- `중첩(Nested)` : 어떤 다른 것이 내부에 위치하거나 포함되는 구조적인 관계
- `내부(Inner)` : 나의 내부에 있는 나를 구성하는 요소
- 쉽게 정리하면 `중첩`은 ***나의 안에 있지만 내것이 아닌 것***을 말한다. `내부`는 ***나의 내부에서 나를 구성하는 요소***를 말한다.'
> 내부 클래스들은 바깥 클래스의 인스턴스에 소속되고, 정적 중첩 클래스는 그렇지 않다.
  
#### 중첩클래스 사용 이유
- 내부 클래스를 포함한 모든 중첩 클래스는 **특정 클래스가 다른 하나의 클래스 안에서만 사용**되거나, **둘이 아주 긴밀하게 연결되어 있는 특별한 경우**에만 사용해야 한다.

---
## 2. 정적 중첩 클래스

### 정적 중첩 클래스 예제
- 우선 중첩 클래스의 인스턴스 멤버 변수는 접근이 가능하다.
- 바깥 클래스의 인스턴스 멤버에는 접근이 불가능하다.
  - 인스턴스 멤버는 클래스가 ***HEAP 메모리에 할당되기 전에는 스테틱 영역에 있는 Nested 는 알 수가 없기 때문***이다.
- 바깥 클래스의 static 변수에는 접근이 가능하다 -> 같은 스태틱 영역에 있기 때문
  ```java
  public class NestedOuter {
  
      private static int outClassValue = 3;
      private int outInstanceValue = 2;
  
      static class Nested {
          private int nestedInstanceValue = 1;
  
          public void print(){
              // 자신의 멤버에 접근
              System.out.println(nestedInstanceValue);
  
              // 바깥 클래스 인스턴스 멤버에 접근불가
              //System.out.println(outInstanceValue);
  
              // 바깥 클래스의 클래스 멤버에는 접근 가능.
              System.out.println(outClassValue );
          }
      }
  }
  ```
- 정적 중첩 클래스 생성 방법은 `new 바깥클래스.중첩클래스()` 로 생성한다.
- 정적 중첩 클래스는 바깥 클래스와 중첩클래스가 서로 관련있는 클래스가 아니기 때문에 바깥 클래스를 선언안해도 중첩 클래스만 선언 가능하다.
  ```java
  public class NestedOuterMain {
      public static void main(String[] args) {
          // NestedOuterMain outer = new NestedOuterMain();
          NestedOuter.Nested nested = new NestedOuter.Nested();
  
          nested.print();
  
          System.out.println("nestedClass = " + nested.getClass());
      }
  }
  ```
  ![img.png](../resources/images/chap07/img02.png)
- 중첩 클래스의 `print()` 함수 동작을 그림으로 보면 아래와 같다.

  ![img_1.png](../resources/images/chap07/img03.png)
---
## 3. 정적 중첩 클래스의 활용

### 정적 중첩 클래스 리팩토링 전
- `NetworkMessage` 객체는 `Network` 객체 안에서만 사용한다.
  ```java
  // Network 객체 안에서만 사용
  public class NetworkMessage {
  
      private String content;
  
      public NetworkMessage(String content) {
          this.content = content;
      }
  
      public void print(){
          System.out.println(content);
      }
  }
  
  public class Network {
    public void sendMessage(String text){
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }
  }
  ```
- 그리고 `main()` 에서는
  ```java
  public class NetworkMain {
      public static void main(String[] args) {
          Network network = new Network();
          network.sendMessage("Hello Java!");
      }
  }
  ```
  ![img_2.png](../resources/images/chap07/img04.png)
- 위 코드들의 문제점은 다른 개발자가 `Network` 관련 라이브러리를 사용하기 위해 패키지를 열었을 때 혼란을 일으킨다.
- 왜냐하면 `Network` 와 `NetworkMessage` 가 있지만 실제로 동작은 `Network` 만 하기 때문에 코드를 한참 뒤져야지 알 수 있기 때문이다.

### 정적 중첩 클래스 리팩토링 후
- 기존의 `NetworkMessage` 클래스를 `Network` 클래스의 정적 중첩 클래스로 만들었다.
- 그리고 접근 제어자를 `private` 로 설정하여 외부에서 접근을 막았다.
  ```java
  public class Network {
  
      public void sendMessage(String text) {
          NetworkMessage networkMessage = new NetworkMessage(text);
          networkMessage.print();
      }
  
      private   class NetworkMessage {
  
          private String content;
  
          public NetworkMessage(String content) {
              this.content = content;
          }
  
          public void print() {
              System.out.println(content);
          }
      }
  }
  ```
- `main()` 메서드에서 실행할 때도 문제가 없다.
  ```java
  public class NetworkMain {
      public static void main(String[] args) {
          Network network = new Network();
          network.sendMessage("Hello Java!");
      }
  }
  ```
  ![img_3.png](../resources/images/chap07/img05.png)

### 중첩 클래스의 접근
- 나의 클래스에 포함된 중첩 클래스가 아닌 다른 곳에 있는 중첩 클래스에 접근할 때는 `바깥클래스.중첩클래스` 로 접근해야 한다.
  ```java
  import nested.nested.NestedOuter;
  
  NestedOuter.Nested nested = new NestedOuter.Nested();
  ```
- 하지만 나의 클래스 안에 있는 중첩 클래스에 접근할 때는 바깥 클래스의 이름을 적지 않아도 된다.
  ```java
  public class Network {
      public void sendMessage(String text){
          NetworkMessage networkMessage = new NetworkMessage(text);
      }
      
      private static class NetworkMessage { ... }
  }
  ```