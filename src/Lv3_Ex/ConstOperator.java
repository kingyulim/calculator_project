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

    abstract double operate(double firstValue, double secondValue);


    static ConstOperator operateConstReturn (String symbol) {
        for (ConstOperator data : ConstOperator.values()) {
            if(data.operateString.equals(symbol)){
                return data;
            }
        }

        throw new IllegalArgumentException("잘못된 연산자입니다");
    }
}
