/**
 * @author Heo, Jin Han
 * @since 2018-02-26
 */
public class OopExample {

  public static void main(String[] args) {
    final CalculatorService calculatorService = new CalculatorService();
    final int additionResult = calculatorService.calculate('+',1, 1);
    System.out.println(additionResult);

    final int subtractionResult = calculatorService.calculate('-', 1, 1);
    System.out.println(subtractionResult);
  }
}

class CalculatorService {
  public int calculate(char calculation, int num1, int num2) {
    if (calculation == '+') {
     return num1 + num2;
    } else  if (calculation == '-') {
      return num1 - num2;
    } else {
      throw new IllegalArgumentException("Unknown calculation:" + calculation);
    }
  }
}