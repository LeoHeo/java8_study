/**
 * @author Heo, Jin Han
 * @since 2018-02-26
 */
public class OopExample {

  public static void main(String[] args) {
    final CalculatorService calculatorService = new CalculatorService(new Addition());
    final int additionResult = calculatorService.calculate(1, 1);
    System.out.println(additionResult);

    final int subtractionResult = calculatorService.calculate(1, 1);
    System.out.println(subtractionResult);
  }
}

interface Calculation {
  int calculate(int num1, int num2);
}

class Addition implements Calculation {

  @Override
  public int calculate(int num1, int num2) {
    return num1 + num2;
  }
}

class Subtraction implements Calculation {

  @Override
  public int calculate(int num1, int num2) {
    return num1 - num2;
  }
}

class Multiplication implements Calculation {

  @Override
  public int calculate(int num1, int num2) {
    return num1 * num2;
  }
}

class Division implements Calculation {

  @Override
  public int calculate(int num1, int num2) {
    return num1 / num2;
  }
}

class CalculatorService {
  // composition
  private final Calculation calculation;

  CalculatorService(final Calculation calculation) {
    this.calculation = calculation;
  }

  public int calculate(int num1, int num2) {
    return calculation.calculate(num1, num2);
  }
}