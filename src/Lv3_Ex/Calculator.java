package Lv3_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private ArrayList<Double> resultArray = new ArrayList<>(); // 계산된 값 저장 배열

    /**
     * 사칙연산 메소드
     * @param firstValue
     * @param secondValue
     * @param operator
     * @return 계산된 값 반환
     * @param <N>
     */
    <N extends Number> double operatorMethod(N firstValue, N secondValue, ConstOperator operator) {
        double result = operator.operate(firstValue.doubleValue(), secondValue.doubleValue());

        resultArray.add(result);
        return result;
    }

    /**
     * 값 입력 메소드
     * @param input
     * @param prompt
     * @return 무조건 숫자만 반환
     */
    double doubleInputMethod(Scanner input, String prompt) {
        double doubleValue = 0;

        while (true) {
            System.out.print(prompt + " 값을 입력해주세요 : ");

            if (!input.hasNextDouble()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }

            double value = input.nextDouble();

            if (value < 0) {
                System.out.println("양수만 입력해주세요.");

                continue;
            }

            doubleValue = value;

            break;
        }

        return doubleValue;
    }

    /**
     * 연산자 검사 메소드
     * @param input
     * @return 연산자 반환
     */
    String operateCheckMethod (Scanner input) {
        String operatorData = "";

        while (true) {
            System.out.print("연산기호를 입력해주세요 (+ - * /) : ");
            String operator = input.nextLine();

            if (operator.length() > 1 || !"+-*/".contains(String.valueOf(operator))) {
                System.out.println("올바른 연산자가 들어오지 않았습니다.");

                continue;
            }

            operatorData = operator;

            break;
        }

        return operatorData;
    }

    /**
     * 저장된 값 배열 문자열로 뽑아오기
     * @param resultArray 뽑아올 배열
     * @return 현재 존재하는 배열 데이터 문자열로 반환
     */
    String thisArrayReturn (List resultArray) {
        String resultString = "";
        int length = resultArray.size();

        if (length == 0) {
            resultString = "값 없음";
        } else {
            for(int a = 0; a < resultArray.size(); a++){
                if (a > 0) {
                    resultString += ", ";
                }

                resultString += resultArray.get(a);
            }
        }

        return resultString;
    }

    /**
     * 계산된 값 반환 메소드
     * @return 계산된 배열 반환
     */
    ArrayList<Double> getResultArray() {
        return resultArray;
    }

    /*
    <N extends Number> ArrayList<Double> savaArrayReturn(ArrayList<Double> arr, N value) {

    }
    */


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
