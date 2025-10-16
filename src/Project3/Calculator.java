package Project3;

public class Calculator {
    /**
     * 정수, 실수 계산기 메소드
     * @param firstValue 첫번쨰 인자 (정수, 실수)
     * @param secondValue 두번쨰 인자 (정수, 실수)
     * @param symbol 열거형 소환
     * @return @param symbol 에 들어온 (+ - * /) 중 해당 상수에 맞는 값 계산 해서 반환
     * @param <S>
     */
    <S extends Number> double operate (S firstValue, S secondValue, OperatorEnum symbol) {
        return symbol.OperatorValue(firstValue.doubleValue(), secondValue.doubleValue());
    }
}

