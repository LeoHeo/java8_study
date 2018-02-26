import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Heo, Jin Han
 * @since 2018-02-26
 */
public class CalculatorServiceTest {

  @Test
  public void testCalculateAddition() {
    Calculation calculation = new Addition();

    final int actual = calculation.calculate(1, 1);

    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testCalculateSubtraction() {
    Calculation calculation = new Subtraction();

    final int actual = calculation.calculate(1, 1);

    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void testCalculateMultiplication() {
    Calculation Calculation = new Multiplication();

    final int actual = Calculation.calculate(2, 2);

    assertThat(actual).isEqualTo(4);
  }

  @Test
  public void testCalculateDivision() {
    Calculation calculation = new Division();

    final int actual = calculation.calculate(9, 3);

    assertThat(actual).isEqualTo(3);
  }
}