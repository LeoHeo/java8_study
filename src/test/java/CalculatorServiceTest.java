import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Heo, Jin Han
 * @since 2018-02-26
 */
public class CalculatorServiceTest {

  @Test
  public void testCalculateAddition() throws Exception {
    CalculatorService calculatorService = new CalculatorService();

    final int actual = calculatorService.calculate('+', 1, 1);

    assertThat(actual).isEqualTo(2);
  }

  @Test
  public void testCalculateSubtraction() throws Exception {
    CalculatorService calculatorService = new CalculatorService();

    final int actual = calculatorService.calculate('-', 1, 1);

    assertThat(actual).isEqualTo(0);
  }
}