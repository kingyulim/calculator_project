package Project3;

public class Calculator {
    <S extends Number> double operate (S firstValue, S secondValue, OperatorEnum symbol) {
        return symbol.OperatorValue(firstValue.doubleValue(), secondValue.doubleValue());
    }
}

