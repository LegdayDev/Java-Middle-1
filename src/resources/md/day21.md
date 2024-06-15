## 자바 중급 1편

## 중첩 클래스, 내부클래스 - 2
> 1. 익명 클래스 - 시작
> 2. 익명 클래스 - 활용 

---
## 익명 클래스 - 시작
> `익명 클래스(anonymous class)`는 지역 클래스의 특별한 종류의 하나이다. ***클래스의 이름이 없다는 특징***이 있다.

- 기존에 했던 `LocalOuterV2` 코드를 보면 `LocalPrinter` 클래스를 ***내부에 생성하는 부분과 선언하는 부분이 분리***되어 있는 것을 알 수 있다.
    ```java
    public class LocalOuterV2 {
        private int outInstanceVar = 3;
    
        public void process(int paramVar) {
            int localVar = 1;
    
            class LocalPrinter implements Printer{
                int value = 0;
    
                @Override
                public void print() {
                    System.out.println("value = " + value);
                    System.out.println("localVar = " + localVar);
                    System.out.println("paramVar = " + paramVar);
                    System.out.println("outInstanceVar = " + outInstanceVar);
                }
            }
    
            LocalPrinter printer = new LocalPrinter();
            printer.print();
        }
    
        public static void main(String[] args) {
            LocalOuterV2 localOuter = new LocalOuterV2();
            localOuter.process(7);
        }
    }
    ```
- 익명 클래스를 사용하면 클래스의 이름을 생략하고, 클래스의 선언과 생성을 한번에 처리할 수 있다.
  ```java
   Printer printer = new Printer() {
    int value = 0;
  
    @Override
    public void print() {
      System.out.println("value = " + value);
      System.out.println("localVar = " + localVar);
      System.out.println("paramVar = " + paramVar);
      System.out.println("outInstanceVar = " + outInstanceVar);
    }
  };
  printer.print();
  ```
- 익명 클래스는 **클래스의 본문(body)을 정의하면서 동시에 생성**한다.
- 익명 클래스는 부모 클래스를 상속 받거나, 또는 인터페이스를 구현해야 한다.

### 익명 클래스 특징
- 익명 클래스는 이름 없는 지역 클래스를 선언하면서 동시에 생성한다.
- 익명 클래스는 말 그대로 이름이 없다. 이름을 가지지 않기 때문에 생성자를 가질 수 없다.

### 익명 클래스 장점
- 익명 클래스를 사용하면 클래스를 별도로 정의하지 않고도 인터페이스나 추상 클래스를 즉석에서 구현할 수 있어 **코드가 더 간결**해진다.
- 하지만 복잡하거나 _**재사용이 필요한 경우에는 별도의 클래스를 정의하는 것이 좋다.**_
- 즉, 일회성 클래스로 사용할 때 익명클래스로 사용하면 좋다.
---
## 익명 클래스 활용
- 아래와 같이 `Dice` 클래스와 `Sum` 클래스를 내부 클래스로 선언하여 `main()` 메서드에서 각각 실행할 수 있다.
  ```java
  public class Ex1RefMainV2 {
      public static void hello(Process process) {
          System.out.println("프로그램 시작");
          process.run();
          System.out.println("프로그램 종료");
      }
  
      public static void main(String[] args) {
          class Dice implements Process {
              @Override
              public void run() {
                  int randomValue = new Random().nextInt(6) + 1;
                  System.out.println("주사위 결과 = " + randomValue);
              }
          }
  
          class Sum implements Process {
              @Override
              public void run() {
                  for (int i = 0; i < 3; i++) {
                      System.out.println("i = " + i);
                  }
              }
          }
  
          hello(new Dice());
          hello(new Sum());
      }
  }
  ```
- 위와 같은 경우에 익명클래스로 선언하면 된다 !
- `hello()` 메서드의 파라미터로 익명클래스로 전달하면서 동시에 실행하면 된다 !
  ```java
  public class Ex1RefMainV4 {
      public static void hello(Process process) {
          System.out.println("프로그램 시작");
          process.run();
          System.out.println("프로그램 종료");
      }
      public static void main(String[] args) {
          hello(new Process() {
              @Override
              public void run() {
                  int randomValue = new Random().nextInt(6) + 1;
                  System.out.println("주사위 결과 = " + randomValue);
              }
          });
          hello(new Process() {
              @Override
              public void run() {
                  for (int i = 0; i < 3; i++) {
                      System.out.println("i = " + i);
                  }
              }
          });
      }
  }
  ```
### 람다(lambda)
- 위 익명 클래스 객체를 보면 `new Proces(){}` 나 `@Override` 등 같이 써야할 게 많고 메서드 1개만 전달하면되는데 코드가 길어지는 단점이 있다.
- `Java 8` 에 들어오면서 ***람다를 통해 메서드(더 정확히는 함수)를 인수로 전달***할 수 있게 되었다! 이것을 `람다(Lambda)`라 한다.
  ```java
  public class Ex1RefMainV5 {
      public static void hello(Process process) {
          System.out.println("프로그램 시작");
          process.run();
          System.out.println("프로그램 종료");
      }
      
      public static void main(String[] args) {
          hello(() -> {
              int randomValue = new Random().nextInt(6) + 1;
              System.out.println("주사위 결과 = " + randomValue);
          });
          hello(() -> {
              for (int i = 0; i < 3; i++) {
                  System.out.println("i = " + i);
              }
          });
      }
  }
  ```