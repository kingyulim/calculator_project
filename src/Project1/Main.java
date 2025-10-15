package Project1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("첫번째 값을 입력해주세요 : ");
            if (!input.hasNextInt()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }

            int firstValue = input.nextInt();
            input.nextLine();

            System.out.print("두번째 값을 입력해주세요 : ");
            if (!input.hasNextInt()) {
                System.out.println("숫자만 입력해주세요.");
                input.next();

                continue;
            }

            int secondValue = input.nextInt();
            input.nextLine();

            System.out.print("사칙연산 기호를 입력해주세요(+, -, *, /) : ");
            char operator = input.next().charAt(0);
            input.nextLine();

            int calValue = 0; // 최종 값 저장
            switch (operator) {
                case '+':
                    calValue = firstValue + secondValue;

                    break;

                case '-':
                    calValue = firstValue - secondValue;

                    break;

                case '*':
                    calValue = firstValue * secondValue;

                    break;

                case '/':
                    if (secondValue == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");

                        continue;
                    }
                    calValue = firstValue / secondValue;

                    break;

                default:
                    System.out.println("잘못된 연산자입니다.");

                    continue;
            }

            System.out.println("결과 : " + calValue);

            System.out.print(".\n.\n.\n.\n.\n더 진행 하시겠습니까? (종료 : exit) : ");
            String exitCommand = input.nextLine().trim();

            if (exitCommand.equals("exit")) {
                System.out.println("계산기를 종료 합니다.");

                break;
            }
        }
    }
}
