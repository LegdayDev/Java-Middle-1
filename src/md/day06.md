## 자바 중급 1편

### String 클래스 학습
> 1. String 클래스 - 주요 메서드 
> 2. StringBuilder - 가변 String
---
### 1. String 클래스
> `String` 클래스는 문자열을 편리하게 다루기 위한 다양한 메서드를 제공한다.</br>
> 너무 많기 때문에 필요할 때 _검색하거나 API 문서를 통해서 원하는 기능을 찾는 것이 좋다._

#### 문자열 정보 조회
|함수명|설명|
|---|---|
|`length()`|문자열의 길이를 반환|
|`isEmpty()`|문자열이 비어 있는지 확인|
|`isBlank()`|문자열이 비어 있는지 확인(길이가 0 이거나 공백만 있는경우, Java 11)|
|`charAt(int index)`|지정된 인덱스에 있는 문자를 반환한다.|

#### 문자열 비교
|함수명|설명|
|---|---|
|`equals(Object object)`|두 문자열이 동일한지 비교|
|`equalsIgnoreCase(String anotherString)`|두 문자열을 대소문자 구분 없이 비교한다|
|`compareTo(String anotherString)`|두 문자열을 사전 순으로 비교한다|
|`compareToIgnoreCase(String str)`|두 문자열을 대소문자 구분 없이 사전적으로 비교한다|
|`startsWith(String prefix)`|문자열이 특정 접두사로 시작하는지 확인한다|
|`endsWith(String suffix)`|문자열이 특정 접미사로 끝나는지 확인한다|

#### 문자열 검색
|함수명|설명|
|---|---|
|`contains(CharSequence s)`|문자열이 특정 문자열을 포함하고 있는지 확인한다|
|`indexOf(String ch)` / `indexOf(String ch, int fromIndex)`|문자열이 처음 등장하는 위치를 반환한다|
|`lastIndexOf(String ch)`|문자열이 마지막으로 등장하는 위치를 반환한다|

#### 문자열 조작 및 변환
|함수명|설명|
|---|---|
|`substring(int beginIndex)` / `subString(int beginIndex, int endIndex)`|문자열의 부분 문자열을 반환한다|
|`concat(String str)`|문자열의 끝에 다른 문자열을 붙인다.|
|`replace(CharSequence target, CharSequence replacement)`|특정 문자열을 새 문자열로 대체한다.|
|`replaceAll(String regex, String replacement)`|문자열에서 정규 표현식과 일치하는 부분을 새 문자열로 대체한다|
|`replaceFirst(String regex, String replacement)`|문자열에서 정규 표현식과 일치하는 첫 번째 부분을 새 문자열로 대체한다|
|`toLowerCase()` / `toUpperCase()`|문자열을 소문자/대문자로 변환한다|
|`strip()`|공백과 유니코드 공백을 포함해서 제거한다(Java 11)|

#### 문자열 분할 및 조합
|함수명|설명|
|---|---|
|`split(String regex)`|문자열을 정규 표현식을 기준으로 분할한다|
|`join(CharSequence delimiter, CharSequence ... elements)`|주어진 구분자로 여러 문자열을 결합한다.|

#### 기타 유틸리티
|함수명|설명|
|---|---|
|`valueOf(Object obj)`|다양한 타입을 문자열로 반환한다|
|`toCharArray()`|문자열을 문자 배열로 변환한다|
|`format(String format, Object... args)`|형식 문자열과 인자를 사용하여 새로운 문자열을 생성한다|
|`matches(String regex)`|문자열이 주어진 정규 표현식과 일치하는지 확인한다|

> 참고 : `CharSequence` 는 `String`, `StringBuilder` 의 상위타입이다. 문자열을 처리하는 다양한 객체를 받을 수 있다.
---
### 2. StringBuilder - 가변 String
> String 클래스가 불변객체기 때문에 단점이 있다. 아래는 예시이다.
- `A` 와 `B` , `C`, `D` 를 더하는 예제이다.
    ```java
    String str = "A" + "B" + "C" + "D";
    String str = new String("A") + new String("B") + new String("C") + new String("D");
    String str = new String("AB") + new String("C") + new String("D");
    String str = new String("ABC")+ new String("D");
    String str = new String("ABCD");
    ```
- 수많은 객체가 사용되지 않고 버려지고 결국 `new String("ABCD")` 만 사용된다.
- ***불변인 String 클래스의 단점은 문자를 더하거나 변경할 떄 마다 계속해서 새로운 객체를 생성***해야 한다는 점이다.
- 즉, **컴퓨터의 CPU, 메모리를 더 많이 소모**하게 된다.

#### StringBuilder
- 불변 `String` 의 단점을 해결하기 위해서는 가변 `String` 이 존재하면 된다.
- `StringBuilder` 는 가변 `String` 을 제공하기 때문에 `String` 의 단점을 해결할 수 있다.
- `StringBuilder` 내부에는 `final` 이 아닌 변경가능한 `byte[]` 를 가지고 있다.
  ```java
  public final class StringBuilder {
      char[] value; // Java 9 이전
      byte[] value; // Java 9 이후
  
      // 여러 메서드
      public StringBuilder append(String str) {...}
  
      public int length() {...}
  }
  ```
- StringBuilder 는 다양한 메서드를 지원한다.
  - `append()` : 여러 문자열 추가
  - `insert()` : 특정 위치에 문자열 삽임
  - `delete()` : 특정 범위의 문자열 삭제
  - `reverse()` : 문자열 뒤집기
  - `toString()` : `StringBuilder` 를 `String` 으로 생성하여 반환
  ```java
  public class StringBuilderMain1_1 {
      public static void main(String[] args) {
          StringBuilder sb = new StringBuilder();
          sb.append("A");
          sb.append("B");
          sb.append("C");
          sb.append("D");
  
          System.out.println("sb = " + sb);
  
          sb.insert(4, "Java");
          System.out.println("insert = " + sb);
  
          sb.delete(4, 8);
          System.out.println("delete = " + sb);
  
          sb.reverse();
          System.out.println("reverse() = " + sb);
  
          String str = sb.toString();
          System.out.println("str = " + str);
      }
  }
  ```
  ![img.png](../images/chap03/img10.png)

> 즉, `StringBuilder` 로 문자열을 변경하고 ***문자열 변경이 끝나면 안전한(불변) String 으로 변환***하는 것이 좋다



