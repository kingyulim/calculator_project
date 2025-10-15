package Project2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> resultList = new ArrayList<>(); // 계산된 값을 저장 할 list

    /**
     * 각각의 연산을 담당하는 메소드
     * @param firstNumber 첫 번째 인자
     * @param secondNumber 두 번째 인자
     * @param operator 연산자 인자
     * @return 연산된 값 반환
     */
    int operater(int firstNumber, int secondNumber, char operator) {
        int resultValue = 0; // 계산된 값을 저장할 변수

        switch (operator) {
            case '+':
                resultValue = firstNumber + secondNumber;

                break;

            case '-':
                resultValue = firstNumber - secondNumber;

                break;

            case '*':
                resultValue = firstNumber * secondNumber;

                break;

            case '/':
                if (secondNumber == 0) { // 0은 나눌 수 없으니 조건 사용
                    System.out.println("0으로 나눌 수 없습니다.");

                    return 0;
                }

                resultValue = firstNumber / secondNumber;

                break;

            default: // 잘못된 연산자 입력 시 예외 처리
                System.out.println("올바르지 않은 연산자입니다.");

                return 0;
        }

        resultList.add(resultValue); // 계산된 값 저장

        return resultValue;
    }

    /**
     * 메소드에서 반환된 값들의 배열을 불러오는 메소드
     * @return calculate 계산되어 저장된 배열 반환
     */
    ArrayList<Integer> getResultList() {
        return resultList;
    }

    /**
     * 계산되어 저장된 배열을 수정하는 메소드
     * @param index 배열 인덱스 번호 인자
     * @param newValue 수정될 값 인자
     */
    void updateResult(int index, int newValue) {
        this.resultList.set(index, newValue);
    }

    /**
     * 계산되어 저장된 배열을 삭제하는 메소드
     * @param index 배열에서 삭제할 인덱스 인자
     */
    void removeResult(int index) {
        this.resultList.remove(index);
    }
}
