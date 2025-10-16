package Project3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("연산자를 입력해주세요 (+, -, *, /) : ");
        char operatorChar = input.next().charAt(0);

        OperatorEnum operator = null;

        // 입력한 연산자와 일치하는 enum 찾기
        for (OperatorEnum type : OperatorEnum.values()) {
            if (type.getOperatorSymbol() == operatorChar) {
                operator = type;

                break;
            }
        }

        // 일치하는 enum이 없으면 예외 발생
        if (operator == null) {
            throw new IllegalArgumentException("잘못된 연산자입니다: " + operatorChar);
        }

        System.out.println("선택한 연산자: " + operator);

    }
}
