package Lv3_Ex;

enum ConstOperator {
    ADD("+"){
        @Override
        double operate(double firstValue, double secondValue) {
           return firstValue + secondValue;
        }
    },
    SUB("-"){
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue - secondValue;
        }
    },
    MUL("*"){
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue * secondValue;
        }
    },
    DIV("/"){
        @Override
        double operate(double firstValue, double secondValue) {
            if (secondValue == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");

            return firstValue / secondValue;
        }
    };

    private final String operateString;

    ConstOperator(String symbol){
        this.operateString = symbol;
    }

    /**
     * 계산식 추상화 생성
     * @param firstValue
     * @param secondValue
     * @return 재정의 된 각 상수의 값 반환
     */
    abstract double operate(double firstValue, double secondValue);

    /**
     * 연산기호 반환 공용 class
     * @param symbol
     * @return 내가 입력한 심볼 키 값 반환
     */
    static ConstOperator operateConstReturn (String symbol) {
        for (ConstOperator data : ConstOperator.values()) {
            if(data.operateString.equals(symbol)){
                return data;
            }
        }

        throw new IllegalArgumentException("잘못된 연산자입니다");
    }
}
