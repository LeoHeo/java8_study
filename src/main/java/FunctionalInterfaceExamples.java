import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Heo, Jin Han
 * @since 2018-02-28
 */
public class FunctionalInterfaceExamples {

  public static void main(String[] args) {

    final Function<String, Integer> toInt = value -> Integer.parseInt(value);

    System.out.println(toInt.apply("100"));

    final Function<Integer, Integer> identity = Function.identity();

    System.out.println(identity.apply(999));

    final Consumer<String> print = value -> System.out.println(value);
    final Consumer<String> greetings = value -> System.out.println("Hello " + value);

    // Return 값이 없기때문에 Function type 으로는 만들 수 가 없음
//    final Function<String, Void> print2 = value -> System.out.println(value);

    greetings.accept("Leo");
    print.accept("test");

    // Predicate<T>는 항상 boolean 리턴한다.
    // Function<T, Boolean>이라고 볼 수 도 있겠으나
    // Boolean은 Boxed primitive boolean이기 때문에
    // Object 생성을 따로 할 필요없이 Predicate을 이용하면 좀 더 편하다.

    Predicate<Integer> isPositive = i -> i > 0;
    System.out.println(isPositive.test(1));
    System.out.println(isPositive.test(0));
    System.out.println(isPositive.test(-1));

    List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);

    List<Integer> positiveNumbers = new ArrayList<>();
    for (Integer num: numbers) {
      if (isPositive.test(num)) {
        positiveNumbers.add(num);
      }
    }
    System.out.println("positive integers:" + positiveNumbers);

    Predicate<Integer> lessThan3 = i -> i < 3;
    List<Integer> numbersLessThan3 = new ArrayList<>();
    for (Integer num: numbers) {
      if (lessThan3.test(num)) {
        numbersLessThan3.add(num);
      }
    }
    System.out.println("less than 3 integers:" + numbersLessThan3);

    System.out.println("filter positive integers" + filter(numbers, isPositive));
    System.out.println("filter less than 3 integers" + filter(numbers, lessThan3));

    System.out.println("filter lambda less than 3 integers" + filter(numbers, i -> i > 0));
    System.out.println("filter lambda less than 3 integers" + filter(numbers, i -> i < 3));
  }

  private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
    List<T> result = new ArrayList<>();
    for (T input: list) {
      if (filter.test(input)) {
        result.add(input);
      }
    }

    return result;
  }

}
