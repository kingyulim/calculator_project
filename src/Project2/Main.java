package Project2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();

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

            int operaterValue = calculator.operater(firstValue, secondValue, operator);
            ArrayList<Integer> operaterValueArr = calculator.getResultList();

            System.out.println("저장된 값 : " + operaterValueArr);
            System.out.println("결과 : " + operaterValue);

            System.out.print("결과를 수정하시겠습니까? (yes/no) : ");
            String editAnswer = input.nextLine().trim();

            if (editAnswer.equalsIgnoreCase("yes")) {
                System.out.print("몇 번째 결과를 수정하시겠습니까? (0부터 시작) : ");

                if (!input.hasNextInt()) {
                    System.out.println("숫자만 입력해주세요.");
                    input.next();

                    continue;
                }

                int index = input.nextInt();
                input.nextLine();

                if (index < 0 || index >= operaterValueArr.size()) {
                    System.out.println("잘못된 인덱스입니다.");

                    continue;
                }

                System.out.print("새로운 값을 입력해주세요: ");

                if (!input.hasNextInt()) {
                    System.out.println("숫자만 입력해주세요.");
                    input.next();

                    continue;
                }

                int newValue = input.nextInt();
                input.nextLine();

                calculator.updateResult(index, newValue);
                System.out.println("수정 완료 현재 저장된 값: " + calculator.getResultList());
            }

            if (!calculator.getResultList().isEmpty()) {
                System.out.print("결과를 삭제하시겠습니까? (yes/no) : ");
                String removeAnswer = input.nextLine().trim();

                if (removeAnswer.equalsIgnoreCase("yes")) {
                    System.out.print("몇 번째 결과를 삭제하시겠습니까? (0부터 시작) : ");

                    if (!input.hasNextInt()) {
                        System.out.println("숫자만 입력해주세요.");
                        input.next();

                        continue;
                    }

                    int index = input.nextInt();
                    input.nextLine();

                    if (index < 0 || index >= operaterValueArr.size()) {
                        System.out.println("잘못된 인덱스입니다.");

                        continue;
                    }

                    calculator.removeResult(index);
                    System.out.println("삭제 완료 현재 저장된 값 : " + calculator.getResultList());
                }
            }

            System.out.print(".\n.\n.\n.\n.\n더 진행 하시겠습니까? (종료 : exit) : ");
            String exitCommand = input.nextLine().trim();

            if (exitCommand.equals("exit")) {
                System.out.println("계산기를 종료 합니다.");

                break;
            }
        }
    }
}
