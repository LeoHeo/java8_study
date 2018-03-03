import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Heo, Jin Han
 * @since 2018-03-03
 */
public class StreamExamples2 {

  public static void main(String[] args) {
    Stream.of(1, 2, 3, 4, 5)
          .forEach(i -> System.out.println(i));


    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//    final List<Integer> result = new ArrayList<>();

    Integer result = null;
    for (final Integer number: numbers) {
      if (number > 3 && number < 9) {
        final Integer newNumber = number * 2;
        if (newNumber > 10) {
        // if (newNumber > 20) {
          // result.add(newNumber);
          result = newNumber;
          break;
        }
      }
    }

    // 20일때는 NullPointException
    System.out.println("Imperative Result: " + result.toString());

    // 효율적으로 Lazy하게 처리하기 때문에 효율적
    System.out.println("Functional Result: " +
      numbers.stream()
            .filter(number -> number > 3)
            .filter(number -> number < 9)
            .map(number -> number * 2)
            .filter(number -> number > 10)
            .findFirst()
    );
  }

}
