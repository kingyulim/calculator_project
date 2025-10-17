package Lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("class를 사용 하지 않은 사칙연산 계산기 입니다.\n===================");

        while (true) {
            // 첫 번째 값
            System.out.print("첫번째 값을 입력해주세요 : ");
            if (!input.hasNextInt()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }
            int firstValue = input.nextInt();
            input.nextLine();

            if (firstValue < 0) {
                System.out.println("양수만 입력해주세요.");

                continue;
            }

            // 연산자
            System.out.print("연산기호를 입력해주세요 (+ - * /) : ");
            char operator = input.next().charAt(0);

            input.nextLine();

            // 두 번째 값
            System.out.print("두번째 값을 입력해주세요 : ");
            if (!input.hasNextInt()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }
            int secondValue = input.nextInt();
            input.nextLine();

            if (secondValue < 0) {
                System.out.println("양수만 입력해주세요.");

                continue;
            }

            // 연산 처리
            int sumValue;
            switch (operator) {
                case '+':
                    sumValue = firstValue + secondValue;

                    break;

                case '-':
                    sumValue = firstValue - secondValue;

                    break;

                case '*':
                    sumValue = firstValue * secondValue;

                    break;

                case '/':
                    if (secondValue == 0) {
                        System.out.println("0과 나눌 수 없습니다.");

                        continue;
                    }
                    sumValue = firstValue / secondValue;

                    break;

                default:
                    System.out.println("올바른 사칙연산 기호가 들어오지 않았습니다.");

                    continue;
            }

            // 결과 출력
            System.out.println("===================");
            System.out.println(firstValue + " " + operator + " " + secondValue + " = " + sumValue);
            System.out.println("===================");

            // 종료 여부
            System.out.print(".\n.\n.\n.\n.\n.\n 종료 하시겠습니까? (exit 입력 시 종료) : ");
            String exitCommand = input.nextLine();
            if (exitCommand.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");

                break;
            }
        }
    }
}
