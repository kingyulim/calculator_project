package Lv2;

import java.util.ArrayList;
import java.util.Scanner;

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
        }

        resultArray.add(result);
        return result;
    }

    /**
     * 값 입력 메소드
     * @param input
     * @param prompt
     * @return 무조건 숫자만 반환
     */
   int intInputMethod(Scanner input, String prompt) {
       while (true) {
           System.out.print(prompt + " 값을 입력해주세요 : ");

           if (!input.hasNextInt()) {
               System.out.println("숫자만 입력해주세요.");
               input.next();

               continue;
           }

           int value = input.nextInt();

           if (value < 0) {
               System.out.println("양수만 입력해주세요.");

               continue;
           }

           return value;
       }
   }

    /**
     * 연산자 검사 메소드
     * @param input
     * @return 연산자 반환
     */
   char operateCheckMethod (Scanner input) {
       while (true) {
           System.out.print("연산기호를 입력해주세요 (+ - * /) : ");

           char operator = input.next().charAt(0);
           if(!"+-*/".contains(String.valueOf(operator))) {
               System.out.println("올바른 연산자가 들어오지 않았습니다.");

               continue;
           }

           return operator;
       }
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
