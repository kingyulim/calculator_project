package Project3;

enum OperatorEnum {
    // 속성
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

    private final char symbol;



    //생성자
    OperatorEnum(char a) {
        this.symbol = a;
    }



    // 기능
    /**
     * 사칙연산 추상화 메소드
     * @param a 첫번째로 계산될 인자
     * @param b 두번째로 계산될 인자
     * @return 각각의 사칙연산이 된 값 반환
     */
    abstract double OperatorValue(double a, double b);

    /**
     * OperatorEnum 상수 키 값에 할당된 값을 반환 하는 메소드
     * @param symbol
     * @return +, -, *, / 이 들어오면 거기에 맞는 상수가 반환 될 것이고 아무것도 맞지 않다면 null을 반환
     */
    static OperatorEnum fromSymbol(char symbol) {
        if (symbol == '+') {
            return ADD;
        } else if (symbol == '-') {
            return SUBTRACT;
        } else if (symbol == '*') {
            return MULTIPLY;
        } else if (symbol == '/') {
            return DIVIDE;
        }

        return null;
    }
}
