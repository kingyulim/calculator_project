package Lv3.Challenge1;

import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Calculator calculator = new Calculator();

        System.out.println("class를 사용한 사칙연산 계산기 입니다.\n===================");

        int cnt = 0;
        while (true) {
            if (cnt > 0) {
                System.out.println("===================");
            }

            /**
             * 첫번쨰 값 설정
             */
            double firstValue = calculator.doubleInputMethod(input, "첫번째");
            input.nextLine();


            /**
             * 연산자 설정
             */
            char operator = calculator.operateCheckMethod(input);
            input.nextLine();

            /**
             * 두번째 값 설정
             */
            double secondValue = calculator.doubleInputMethod(input, "두번째");
            input.nextLine();

            /**
             * 연산 시작
             */
            double sumValue = calculator.operatorMethod(firstValue, secondValue, operator);
            if(!"+-*/".contains(String.valueOf(operator))) {
                System.out.println("올바른 사칙 연산 기호가 아닙니다.");

                continue;
            }

            if (operator == '/') {
                if (secondValue == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");

                    continue;
                }
            }

            /**
             * 연산 결과 출력
             */
            ArrayList<Double> getResultList = calculator.getResultArray();
            System.out.println("저장된 값 : " + getResultList);

            System.out.println("===================");

            System.out.println("결과 : " + firstValue + " " + operator + " " + secondValue + " = " + sumValue);

            System.out.println("===================");

            /**
             * 수정 할 값 생성
             */
            System.out.print("수정 할 값이 있습니까? (수정 커멘드 : yes) : ");
            String updateResult = input.nextLine();
            if (updateResult.equalsIgnoreCase("yes")) {
                System.out.print("수정할 번호 : ");

                if (!input.hasNextInt()) {
                    System.out.println("숫자만 입력해주세요.");
                    input.next();

                    continue;
                }

                int updateIndex = input.nextInt();
                input.nextLine();

                if (getResultList.size() <= updateIndex || updateIndex < 0) {
                    System.out.println("잘못된 인덱스 입니다.");

                    continue;
                }

                System.out.print("새로운 값을 입력해주세요 : ");

                if (!input.hasNextInt()) {
                    System.out.println("숫자만 입력해주세요.");
                    input.next();

                    continue;
                }

                int newValue = input.nextInt();
                input.nextLine();

                calculator.updateResultArray(updateIndex, newValue);
                System.out.println("===================\n수정완료 현재 저장된 값 : " + calculator.getResultArray() + "\n===================");
            }

            /**
             * 삭제 할 값 생성
             */
            System.out.print("삭제 할 값이 있습니까? (삭제 커멘트 : yes) : ");
            String removeResult = input.nextLine();
            if (removeResult.equalsIgnoreCase("yes")) {
                System.out.print("삭제할 번호 : ");

                if (!input.hasNextInt()) {
                    System.out.println("숫자만 입력해주세요.");
                    input.next();

                    continue;
                }

                int removeIndex = input.nextInt();
                input.nextLine();

                if (getResultList.size() <= removeIndex || removeIndex < 0) {
                    System.out.println("잘못된 인덱스 입니다.");

                    continue;
                }

                calculator.removeResultArray(removeIndex);
                System.out.println("===================\n삭제완료 현재 저장된 값 : " + calculator.getResultArray() + "\n===================");
            }

            System.out.print(".\n.\n.\n.\n.\n.\n 종료 하시겠습니까? (종료 커맨드 : exit) : ");
            String exitCommend = input.nextLine();

            if (exitCommend.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료 합니다.");

                break;
            } else {
                cnt++;
            }
        }
    }
}
