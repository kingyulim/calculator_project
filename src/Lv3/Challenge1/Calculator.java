package Lv3.Challenge1;

import java.util.ArrayList;
import java.util.Date;

public class Calculator {
    private ArrayList<Double> resultArray = new ArrayList<>(); // 계산된 값 저장 배열

    ConstOperator add = ConstOperator.ADD;
    ConstOperator sub = ConstOperator.SUB;
    ConstOperator mul = ConstOperator.MUL;
    ConstOperator div = ConstOperator.DIV;

    /**
     * 사칙연산 메소드
     * @param firstValue
     * @param secondValue
     * @param operator
     * @return 계산된 값 반환
     * @param <N>
     */
    <N extends Number> double operatorMethod(N firstValue, N secondValue, char operator) {
        double result = 0;

        switch (operator) {
            case '+':
                result = add.operate(firstValue.doubleValue(), secondValue.doubleValue());

                break;

            case '-':
                result = sub.operate(firstValue.doubleValue(), secondValue.doubleValue());

                break;

            case '*':
                result = mul.operate(firstValue.doubleValue(), secondValue.doubleValue());

                break;

            case '/':
                result = div.operate(firstValue.doubleValue(), secondValue.doubleValue());

                break;
        }

        resultArray.add(result);
        return result;
    }

    /**
     * 계산된 값 반환 메소드
     * @return 계산된 배열 반환
     */
    ArrayList<Double> getResultArray() {
        return resultArray;
    }

    /**
     * 계산된 값 수정 메소드
     * @param index 배열 번호
     * @param newValue 수절 할 값
     */
    void updateResultArray(int index, double newValue) {
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
