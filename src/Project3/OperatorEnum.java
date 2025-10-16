package Project3;

enum OperatorEnum {
    ADD ('+') {
        @Override
        int OperatorValue(int a, int b){
            return a + b;
        }
    },
    SUBTRACT ('-') {
        @Override
        int OperatorValue(int a, int b){
            return a - b;
        }
    },
    MULTIPLY ('*') {
        @Override
        int OperatorValue(int a, int b){
            return a * b;
        }
    },
    DIVIDE ('/') {
        @Override
        int OperatorValue(int a, int b){
            return a / b;
        }
    };

    /**
     * 사칙연산 추상화 메소드
     * @param a 첫번째로 계산될 인자
     * @param b 두번째로 계산될 인자
     * @return 각각의 사칙연산이 된 값 반환
     */
    abstract int OperatorValue(int a, int b);

    private final char symbol;

    OperatorEnum(char symbol) {
        this.symbol = symbol;
    }

    public char getOperatorSymbol() {
        return symbol;
    }


}
