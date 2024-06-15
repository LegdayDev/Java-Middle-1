## 자바 중급 1편

### 열거형 - ENUM
> 1. 열거형 - 리팩토링 3
> 2. 문제 및 정리
---
### 1. 열거형 - 리팩토링 3
> 리펙토링 마지막으로는 할인율 계산을 하는 DiscountService 코드만 남았다.

- 현재 할인율 계산을 할 때 `Grade` 가 가지고 있는 데이터인 `discountPercent`의 값을 가져와 사용한다.
- 객체 지향 관점에서 볼 때 `Grade` 자신의 데이터를 외부에 노출하는 것 보다는, `Grade` 클래스가 ***자신의 할인율을 어떻게 계산하는지 스스로 관리하는 것이 캡슐화 원칙***에 더 맞다.
    ```java
    public class DiscountService {
        public int discount(Grade grade, int price) {
            return price * grade.getDiscountPercent() / 100;
        }
    }
    ```
- 즉, 위 로직이 `Grade` 안에 있는게 훨씬 좋다.
  ```java
  public enum Grade {
      BASIC(10), GOLD(20), DIAMOND(30);
  
      private final int discountPercent;
  
      Grade(int discountPercent) {
          this.discountPercent = discountPercent;
      }
  
      public int getDiscountPercent() {
          return discountPercent;
      }
  
      // 비즈니스 로직 추가
      public int dicount(int price) {
          return price * discountPercent / 100;
      }
  }
  ```
  - 기존의 `DiscountService` 에 있던 `dicount()`메서드가 `Grade` 내부로 들어왔다.
- 그럼 `DiscountService` 에 `discount()`도 아래와 같이 바뀐다.
  ```java
  public class DiscountService {
      public int discount(Grade grade, int price) {
          return grade.dicount(price);
      }
  }
  ```
- `main()` 도 문제 없이 잘 돌아간다.
  ```java
  public class EnumRefMain3_1 {
      public static void main(String[] args) {
          int price = 10000;
  
          DiscountService discountService = new DiscountService();
          int basic = discountService.discount(Grade.BASIC, price);
          int gold = discountService.discount(Grade.GOLD, price);
          int diamond = discountService.discount(Grade.DIAMOND, price);
  
          System.out.println("BASIC 등급의 할인 금액: " + basic);
          System.out.println("GOLD 등급의 할인 금액: " + gold);
          System.out.println("DIAMOND 등급의 할인 금액: " + diamond);
      }
  }
  ```
  ![img.png](../resources/images/chap05/img13.png)

#### DiscountService 제거
- 이제 할인율 계산을 `Grade` 에서 하는데 굳이 `DiscountService가` 없어도 문제가 없다.
  ```java
  public class EnumRefMain3_2 {
      public static void main(String[] args) {
          int price = 10000;
  
          System.out.println("BASIC 등급의 할인 금액: " + Grade.BASIC.dicount(price));
          System.out.println("GOLD 등급의 할인 금액: " + Grade.GOLD.dicount(price));
          System.out.println("DIAMOND 등급의 할인 금액: " + Grade.DIAMOND.dicount(price));
      }
  }
  ```
  - 더이상 `main()` 에서도 `DiscountService` 없이 `Grade` 만 사용해도 된다.

#### 출력 중복 제거
- main() 메서드에서는 비슷한 출력을 계속하기 때문에 이를 메서드로 빼서 리팩토링한다.
  ```java
  public class EnumRefMain3_3 {
      public static void main(String[] args) {
          int price = 10000;
  
          printDiscount(Grade.BASIC, price);
          printDiscount(Grade.GOLD, price);
          printDiscount(Grade.DIAMOND, price);
      }
  
      private static void printDiscount(Grade grade, int price) {
          System.out.println(grade.name() + " 등급의 할인 금액: " + grade.dicount(price));
      }
  }
  ```
  ![img.png](../resources/images/chap05/img14.png)

#### ENUM 목록
- `Grade` 에 새로운 등급이 추가되더라도 기
- 존 `main()` 코드는 변경 없이 모든 등급의 할인을 출력해보자.
  ```java
  public class EnumRefMain3_4 {
      public static void main(String[] args) {
          int price = 10000;
          Grade[] grades = Grade.values();
          for (Grade grade : grades) {
              printDiscount(grade, price);
          }
      }
  
      private static void printDiscount(Grade grade, int price) {
          System.out.println(grade.name() + " 등급의 할인 금액: " + grade.dicount(price));
      }
  }
  ```
  ![img.png](../resources/images/chap05/img15.png)
  - `values()` 는 모든 ENUM 상수들을 출력해주기 때문에 새로운 등급이 추가되도 기존 `main()`은 안건들여도 된다.