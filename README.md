# 계산기 만들기
Java를 활용한 사칙연산 계산기 프로젝트

---

# 요구사항
- 어떤 계산기 기능이 필요한지 명확히 합니다.
- 예를 들어, 기본적인 사칙연산(덧셈, 뺄셈, 곱셈, 나눗셈), 괄호 사용, 제곱근, 제곱 등.
- 사용자 인터페이스 방식 결정 : 콘솔 기반인지, GUI(그래픽 사용자 인터페이스) 기반인지.
- 예외 처리 : 0으로 나누기와 같은 오류를 어떻게 처리할지 결정합니다.
---

# 필수 기능
**Lv 1.**

    1. 계산기는 2개의 숫자를 받을 수 있고 사칙연산 될 문자를 받을 수 있다.
    2. 계산기는 exit을 입력할 때까지 계속해서 값을 받고 연산 결과를 반환한다.
**Lv 2.**

    1. 계산된 결과 값들을 기록하는 컬렉션을 만든다.
    2. 컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.
**Lv 3.**

    1. 양의 정수만 받을 수 있었지만, 이제부터는 실수도 받을 수 있게 수정한다.
    2. 결과가 저장되어 있는 컬렉션을 조회하는 기능을 만든다.
    3. 그 때 특정 값보다 큰 결과 값을 출력할 수 있도록 한다.

---
# Lv 1. 클래스 없이 기본적인 연산을 수행할 수 있는 계산기 만들기
## 1️⃣ 양의 정수 입력 받기

- Scanner로 양의 정수 2개(0 포함)를 입력받는다.
- 각각 따로 입력받아 변수에 저장한다.
````java
System.out.print("첫 번째 숫자를 입력하세요: ");
int num1 = sc.nextInt();
System.out.print("두 번째 숫자를 입력하세요: ");
int num2 = sc.nextInt();
````
## 2️⃣ 사칙연산 기호 입력 받기

- Scanner로 사칙연산 기호(+, -, *, /)를 입력받는다.

- 입력값을 charAt(0)으로 문자형 변수에 저장한다.

````java
System.out.print("연산 기호를 입력하세요: ");
char operator = sc.next().charAt(0);
````
## 3️⃣ 입력값으로 계산 수행 및 결과 출력

- if 또는 switch 문을 사용해 연산자를 구분한다.

- 연산 결과를 출력한다.

- 0으로 나누는 경우 예외 처리한다.
````java
if (operator == '/' && num2 == 0) {
    System.out.println("나눗셈 연산에서 0으로 나눌 수 없습니다.");
} else {
    // 연산 수행
}
````
## 4️⃣ 반복문으로 계속 계산 가능하게 만들기

- while (true) 문을 사용해 계산을 반복한다.

- “exit”을 입력하면 반복 종료한다.
````java
System.out.print("계속하시겠습니까? (exit 입력 시 종료): ");
String cmd = sc.next();
if (cmd.equalsIgnoreCase("exit")) break;
````

## ⚙️ 요약 구조 흐름
1. 숫자 2개 입력
2. 연산 기호 입력
3. 제어문으로 계산
4. 결과 출력
5. “exit” 입력 시 종료, 아니면 반복
---
# Lv 2. 클래스를 적용해 기본적인 연산을 수행할 수 있는 계산기 만들기
## 1️⃣ Calculator 클래스 생성

- 역할: 실제 사칙연산 수행 및 결과 저장 담당

- 구현 내용:

    - 사칙연산 후 결과를 반환하는 calculate() 메서드 구현

    - 연산 결과를 저장하는 컬렉션 필드(ArrayList 등) 생성

- 예시:
````java
public class Calculator {
private ArrayList<Integer> results = new ArrayList<>();

    public int calculate(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0)
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                result = num1 / num2;
                break;
        }
        results.add(result);
        return result;
    }
}
````

## 2️⃣ App 클래스(main 메서드)에서 Calculator 사용

- 역할: **입력 / 반복 / 출력 / 종료 제어 담당**

- 구현 내용:

   - Calculator 객체 생성 후 연산 수행 요청

    - 결과 출력 및 반복문으로 계속 계산 가능하게

- 예시:
````java
Calculator cal = new Calculator();
while (true) {
// 숫자 2개 + 연산자 입력
// cal.calculate(num1, num2, operator);
// 결과 출력
// "exit" 입력 시 종료
}
````
## 3️⃣ 캡슐화 적용

- Calculator의 결과 리스트를 private으로 숨기기

- 외부에서 접근 시 Getter / Setter로만 가능하게 함

````java
public ArrayList<Integer> getResults() { return results; }
public void setResults(ArrayList<Integer> results) { this.results = results; }
````


## 4️⃣ 결과 삭제 기능 추가

- Calculator에 가장 먼저 저장된 결과값을 삭제하는 removeResult() 메서드 추가
````java
public void removeResult() {
    if (!results.isEmpty()) results.remove(0);
}
````

- App 클래스에서 이 메서드를 호출할 수 있도록 추가

## ⚙️ 전체 흐름 요약

- Calculator 클래스
- calculate() : 연산 수행 + 결과 저장
- getResults() / setResults() : 캡슐화 처리
- removeResult() : 첫 번째 결과 삭제
- App 클래스
- Scanner로 입력받기
- Calculator 호출로 연산 처리
- 결과 출력
- “exit” 입력 전까지 반복
- 삭제 기능도 메뉴로 실행 가능
---

# Lv 3. Enum, 제네릭, 람다 & 스트림을 이해한 계산기
## 1️⃣ Enum으로 연산자 관리

- 사칙연산(➕, ➖, ✖️, ➗)을 Enum 타입으로 정의한다.

- 각 연산자는 고유한 계산 로직을 가진다.

- Calculator 클래스는 이 Enum을 사용하여 연산을 수행한다.
```java
enum ConstOperator {
    ADD("+"){
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue + secondValue;
        }
    },
    SUB("-"){
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue - secondValue;
        }
    },
    MUL("*"){
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue * secondValue;
        }
    },
    DIV("/"){
        @Override
        double operate(double firstValue, double secondValue) {
            if (secondValue == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");

            return firstValue / secondValue;
        }
    };

    private final String operateString;

    ConstOperator(String symbol){
        this.operateString = symbol;
    }

    /**
     * 계산식 추상화 생성
     * @param firstValue
     * @param secondValue
     * @return 재정의 된 각 상수의 값 반환
     */
    abstract double operate(double firstValue, double secondValue);

    /**
     * 연산기호 반환 공용 class
     * @param symbol
     * @return 내가 입력한 심볼 키 값 반환
     */
    static ConstOperator operateConstReturn (String symbol) {
        for (ConstOperator data : ConstOperator.values()) {
            if(data.operateString.equals(symbol)){
                return data;
            }
        }

        throw new IllegalArgumentException("잘못된 연산자입니다");
    }
}
```


## 2️⃣ 제네릭으로 여러 타입 지원

- 기존에는 int 타입만 계산 가능했음.

- 제네릭(T extends Number) 을 사용해 int, double 등 다양한 숫자 타입 처리 가능하게 수정한다.

```java
<N extends Number> double operatorMethod(N firstValue, N secondValue, ConstOperator operator) {
    double result = operator.operate(firstValue.doubleValue(), secondValue.doubleValue());

    resultArray.add(result);
    return result;
}
```


## 3️⃣ 람다 & 스트림으로 결과 필터링

- 저장된 결과값 중에서 입력받은 기준값보다 큰 값들만 조회한다.

- 이때 Stream과 Lambda를 사용한다.

```java
List<Double> saveList = lastArrList.stream().sorted().filter(n -> n > maxValueInput).collect(Collectors.toList());

String savaListString = calculator.thisArrayReturn(saveList);
```

## ✅ 정리

| 항목 | 구현 포인트 |
|------|--------------|
| **연산자 관리** | Enum을 사용해 연산자 로직을 구조화 |
| **데이터 타입 유연성** | 제네릭 `<T extends Number>` 사용 |
| **결과 조회 기능** | 람다 & 스트림으로 조건 필터링 구현 |
| **예외 처리** | 0으로 나누는 경우 예외 발생 처리 |

---

## 주 학습 내용 정리
- **기본 입력 & 제어문**  
  Scanner로 사용자 입력을 받고, if/switch 문으로 연산 제어를 수행.  
  반복문을 이용해 `exit` 입력 전까지 연산을 지속할 수 있도록 구현.

- **클래스 구조화**  
  Calculator 클래스를 만들어 연산 로직과 데이터 저장을 분리하여 구조화된 코드 작성.

- **캡슐화 (Encapsulation)**  
  컬렉션 필드를 `private`으로 선언하고, Getter/Setter 메서드를 통해 간접 접근 구현.

- **컬렉션 활용**  
  `ArrayList`를 사용해 연산 결과를 저장하고, 가장 오래된 결과를 삭제하는 기능 추가.

- **Enum (열거형)**  
  연산자(+, -, *, /)를 Enum으로 정의하여 연산 로직을 구조적이고 명확하게 관리.

- **제네릭 (Generics)**  
  `<T extends Number>`를 사용하여 int, double 등 다양한 타입을 처리할 수 있도록 확장.

- **람다 & 스트림 (Lambda & Stream)**  
  저장된 결과 중 입력값보다 큰 결과만 필터링하여 출력하는 기능을 람다식과 스트림으로 구현.

- **예외 처리 (Exception Handling)**  
  0으로 나누는 경우 `ArithmeticException`을 발생시켜 프로그램의 안정성 확보.
