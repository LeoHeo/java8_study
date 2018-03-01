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
  }

}
