package Lv3;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            String operator = calculator.operateCheckMethod(input);

            /**
             * 두번째 값 설정
             */
            double secondValue = calculator.doubleInputMethod(input, "두번째");
            input.nextLine();

            /**
             * 연산 시작
             */
            double sumValue = 0;
            try {
                sumValue = calculator.operatorMethod(firstValue, secondValue, operator);
            } catch(ArithmeticException e) {
                System.out.println(e.getMessage());

                continue;
            }

            /**
             * 연산 결과 출력
             */
            ArrayList<Double> getResultList = calculator.getResultArray();
            String resultString = calculator.thisArrayReturn(getResultList);

            System.out.println("===================\n저장된 값 : " + resultString + "\n===================");

            System.out.println("결과 : " + firstValue + " " + operator + " " + secondValue + " = " + sumValue + "\n===================");

            /**
             * 수정 삭제 실행
             */
            while (true) {
                System.out.print("수정이나 삭제할 커멘트를 입력해주세요 없다면 엔터를 눌러 다음으로 넘어갑니다.\n(수정 : edit) (삭제 : del) : ");
                String setCommendInput = input.nextLine();

                if(setCommendInput.equalsIgnoreCase("edit")) {
                    while (true) {
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
                        System.out.println("===================\n수정완료 현재 저장된 값 : " + calculator.thisArrayReturn(calculator.getResultArray()) + "\n===================");

                        break;
                    }

                    continue;
                }else if(setCommendInput.equalsIgnoreCase("del")) {
                    while (true) {
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
                        System.out.println("===================\n삭제완료 현재 저장된 값 : " + calculator.thisArrayReturn(calculator.getResultArray()) + "\n===================");

                        break;
                    }

                    continue;
                } else {
                    break;
                }
            }

            ArrayList<Double> lastArrList = calculator.getResultArray();
            if(lastArrList.size() > 1) {
                System.out.print("===================\n저장된 값중 내가 지정한 큰 결과값들을 출력 하시겠습니까?\n없다면 엔터를 눌러주세요.\n(출력 커멘드 : yes) : ");
                String maxValueCommendInput = input.nextLine();

                if (maxValueCommendInput.equalsIgnoreCase("yes")) {
                    while (true) {
                        System.out.print("값을 지정해주세요 : ");

                        if(!input.hasNextDouble()){
                            System.out.println("숫자만 입력해주세요.");
                            input.next();

                            continue;
                        }

                        int maxValueInput = input.nextInt();
                        input.nextLine();

                        if(maxValueInput < 0){
                            System.out.println("양수만 입력해주세요");

                            continue;
                        }

                        List<Double> saveList = lastArrList.stream().sorted().filter(n -> n > maxValueInput).collect(Collectors.toList());

                        String savaListString = calculator.thisArrayReturn(saveList);

                        System.out.println("===================\n" + savaListString + "\n===================");

                        System.out.print("더 지정 하시겠습니까?\n더 지정하시려면 엔터를 눌러주세요.\n(나가기 커멘드 : exit) : ");
                        String savaListExit = input.nextLine();

                        if (savaListExit.equalsIgnoreCase("exit")) break;
                    }
                }
            }

            System.out.print(".\n.\n.\n.\n.\n.\n종료 하시겠습니까 계속 진행 하시려면 엔터를 눌러주세요.\n(종료 커맨드 : exit) : ");
            String exitCommend = input.nextLine();

            if (exitCommend.equalsIgnoreCase("exit")) {
                System.out.println("===================\n계산기를 종료 합니다.");

                break;
            } else {
                cnt++;
            }
        }
    }
}
