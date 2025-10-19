package Lv3;

enum ConstOperator {
    ADD{
        @Override
        double operate(double firstValue, double secondValue) {
           return firstValue + secondValue;
        }
    },
    SUB{
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue - secondValue;
        }
    },
    MUL{
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue * secondValue;
        }
    },
    DIV{
        @Override
        double operate(double firstValue, double secondValue) {
            return firstValue / secondValue;
        }
    };

    abstract double operate(double firstValue, double secondValue);
}
