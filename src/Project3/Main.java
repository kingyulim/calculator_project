package Project3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();

        System.out.print("첫번째 값을 입력해주세요 : ");
        double firstValue = input.nextDouble();

        System.out.print("연산자를 입력해주세요 (+, -, *, /) : ");
        char symbol = input.next().charAt(0);

        OperatorEnum operator = OperatorEnum.fromSymbol(symbol);

        if(operator == null) {
            System.out.println("잘못된 연산자가 들어왔습니다.");

            return;
        }

        System.out.print("두번째 값을 입력해주세요 : ");
        double secondValue = input.nextDouble();

        if(secondValue == 0 && symbol == '/'){
            System.out.println("0으로 나눌 수 없습니다.");

            return;
        }

        double operatorValue = calculator.operate(firstValue, secondValue, operator);

        System.out.println("계산 된 값 : " + operatorValue);
    }
}
