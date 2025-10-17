package Lv2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> resultArray =  new ArrayList<>(); // 계산된 값 저장

    /**
     * 사칙연산 메소드
     * @param firstValue
     * @param secondValue
     * @param operator
     * @return
     * 1. 나눗셈때 두번째 값이 0이 들어오면 "no_zero" 반환
     * 2. 잘못된 연산자가 들어오면 "no_operator" 반환
     * 3. 정확한 사칙연산에 맞으면 계산된 "result" 반환
     */
    Object operatorMethod(int firstValue, int secondValue, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = firstValue + secondValue;

                break;

            case '-':
                result = firstValue - secondValue;

                break;

            case '*':
                result = firstValue * secondValue;

                break;

            case '/':
                if (secondValue == 0) {
                    return "no_zero";
                }
                result = firstValue / secondValue;

                break;

            default:
                return "no_operator";
        }

        resultArray.add(result);
        return result;
    }

    /**
     * 계산된 값 반환 메소드
     * @return 계산된 배열 반환
     */
    ArrayList<Integer> getResultArray() {
        return resultArray;
    }

    /**
     * 계산된 값 수정 메소드
     * @param index 배열 번호
     * @param newValue 수절 할 값
     */
    void updateResultArray(int index, int newValue) {
        this.resultArray.set(index, newValue);
    }

    /**
     * 계산된 값 삭제 메소드
     * @param index 배열 번호
     */
    void removeResultArray(int index) {
        this.resultArray.remove(index);
    }
}
