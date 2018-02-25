import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author Heo, Jin Han
 * @since 2018-02-25
 */
public class WhyJava8Test {

  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

  @Test
  public void test_join_string_before_java8() {
    final String result = WhyJava8.joinStringBeforeJava8(numbers);

    assertEquals(result, "1 : 2 : 3 : 4 : 5");
  }

  @Test
  public void test_join_string_above_java8() {
    final String result = WhyJava8.joinStringAboveJava8(numbers);

    assertEquals(result, "1 : 2 : 3 : 4 : 5");
  }

}
