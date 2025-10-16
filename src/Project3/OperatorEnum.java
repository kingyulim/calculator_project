package Project3;

enum OperatorEnum {
    ADD ('+') {
        @Override
        double OperatorValue(double a, double b){
            return a + b;
        }
    },
    SUBTRACT ('-') {
        @Override
        double OperatorValue(double a, double b){
            return a - b;
        }
    },
    MULTIPLY ('*') {
        @Override
        double OperatorValue(double a, double b){
            return a * b;
        }
    },
    DIVIDE ('/') {
        @Override
        double OperatorValue(double a, double b){
            return a / b;
        }
    };

    /**
     * 사칙연산 추상화 메소드
     * @param a 첫번째로 계산될 인자
     * @param b 두번째로 계산될 인자
     * @return 각각의 사칙연산이 된 값 반환
     */
    abstract double OperatorValue(double a, double b);

    private final char symbol;

    OperatorEnum(char a) {
        this.symbol = a;
    }

    public char getOperatorSymbol() {
        return symbol;
    }

    /**
     * OperatorEnum 상수 키 값에 할당된 값을 반환 하는 메소드
     * @param symbol
     * @return +, -, *, / 이 들어오면 거기에 맞는 symbol이 반환 될 것이고 아니라면 null이 반환
     */
    static OperatorEnum fromSymbol(char symbol) {
        if (symbol == '+') {
            return ADD;
        }else if (symbol == '-') {
            return SUBTRACT;
        }else if (symbol == '*') {
            return MULTIPLY;
        }else if (symbol == '/') {
            return DIVIDE;
        }

        return null;
    }
}
