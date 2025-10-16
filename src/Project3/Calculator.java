package Project3;

enum operatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operatorSymbol;

    operatorType(char operatorEnum) {
        this.operatorSymbol = operatorEnum;
    }

    char getOperatorSymbol() {
        return operatorSymbol;
    }
}

public class Calculator {
    <S> S calculate (S firstValue, S secondValue, operatorType operatorSymbol){
        S result = null;

        switch (operatorSymbol){
            case ADD:
                result = firstValue + secondValue;

                break;

            case SUBTRACT:
                result = firstValue - secondValue;

                break;

            case MULTIPLY:
                result = firstValue * secondValue;

                break;

            case DIVIDE:
                result = firstValue / secondValue;

                break;
        }

        return result;
    }
}
