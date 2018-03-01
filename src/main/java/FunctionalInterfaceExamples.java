import java.util.function.Consumer;
import java.util.function.Function;

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
  }

}
