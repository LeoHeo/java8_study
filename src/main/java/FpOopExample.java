/**
 * @author Heo, Jin Han
 * @since 2018-02-27
 */
public class FpOopExample {

  public static void main(String[] args) {
    Calculation calculation = (i1, i2) -> i1 + i2;
    final int addition = new CalculateService().calculate(calculation, 1, 2);
    System.out.println(addition);
  }
}

class CalculateService {
  public int calculate(Calculation calculation, int num1, int num2) {
    return calculation.calculate(num1, num2);
  }
}
