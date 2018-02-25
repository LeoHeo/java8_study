import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

/**
 * @author Heo, Jin Han
 * @since 2018-02-25
 */
public class WhyJava8 {

  public static void main(String[] args) {
  }

  public static String joinStringBeforeJava8(List<Integer> numbers) {
    // 1 : 2 : 3 : 4 : 5를 만들어보자

    // Java 8 이전
    StringBuilder sb = new StringBuilder();

    for (Integer number : numbers) {
      sb.append(number).append(" : ");
    }

    int stringLength = sb.length();
    if (stringLength != 0) {
      sb.delete(stringLength - 3, stringLength);
    }

//    int size = numbers.size();
//    for (int i=0; i< size; i++) {
//      sb.append(numbers.get(i));
//      if (i != size -1) {
//        sb.append(" : ");
//      }x
//    }

    return sb.toString();
  }

  public static String joinStringAboveJava8(List<Integer> numbers) {
    final String result = numbers.stream()
        .map(String::valueOf)
        .collect(joining(" : "));

    return result;
  }
}
