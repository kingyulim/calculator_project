package Test.Project3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();
        while (true) {
            System.out.print("첫번째 값을 입력해주세요 : ");
            if (!input.hasNextDouble()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }
            double firstValue = input.nextDouble();


            System.out.print("연산자를 입력해주세요 (+, -, *, /) : ");
            char symbol = input.next().charAt(0);

            OperatorEnum operator = OperatorEnum.fromSymbol(symbol);

            if(operator == null) {
                System.out.println("잘못된 연산자가 들어왔습니다.");

                continue;
            }

            System.out.print("두번째 값을 입력해주세요 : ");
            if (!input.hasNextDouble()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }

            double secondValue = input.nextDouble();

            if(secondValue == 0 && symbol == '/'){
                System.out.println("0으로 나눌 수 없습니다.");

                continue;
            }

            double operatorValue = calculator.operate(firstValue, secondValue, operator);

            System.out.println("계산 된 값 : " + operatorValue);

            input.nextLine(); // 이거 안 넣으면 종료 문구가 뜨지 않음.

            System.out.print(".\n.\n.\n.\n.\n.\n 더 진행 하시겠습니까? (종료 : exit) : ");
            String exitCommand = input.nextLine().trim();

            if (exitCommand.equals("exit")) {
                System.out.println("계산기를 종료 합니다.");

                break;
            }
        }
    }
}
