import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Heo, Jin Han
 * @since 2018-03-03
 */
public class StreamExamples1 {

  public static void main(String[] args) {
    IntStream.range(1, 10).forEach(i -> System.out.print(i + " "));
    IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));

    // 21억까지 증가
    // MAX_INT
    IntStream.iterate(1, i -> i + 1)
              .forEach(i -> System.out.print(i + " "));

    // 무한히 증가
    Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
          .forEach(i -> System.out.print(i + " "));
  }

}
