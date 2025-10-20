package Lv3_Ex;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface CalculatorInterpace {
    //<N extends Number> List<Double> saveListReturn(ArrayList<Double> arr, N v);
    List<Double> saveListReturn(ArrayList<Double> arr, double v);
}
