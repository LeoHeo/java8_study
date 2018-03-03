import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import com.sun.xml.internal.xsom.impl.scd.Step;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Heo, Jin Han
 * @since 2018-03-03
 */
public class StreamExamples3 {

  public static void main(String[] args) {
    System.out.println("collect(toList())" +
        Stream.of(1, 2, 3, 4, 5)
          .filter(i -> i > 2)
          .map(i -> i * 2)
          .map(i -> "# " + i)
          .collect(toList()) // [# 6, # 8, # 10]
    );

    System.out.println("collect(toList())" +
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "# " + i)
            .collect(toList()) // [# 6, # 6, # 10, # 10]
    );

    // 중복제거
    System.out.println("collect(toSet())" +
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "# " + i)
            .collect(toSet()) // [# 6, # 10]
    );

    System.out.println("collect(joining())" +
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "# " + i)
            .collect(joining()) // # 6# 6# 10# 10
    );

    System.out.println("collect(joining(\",\"))" +
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "# " + i)
            .collect(joining(", ")) // # 6# 6# 10# 10
    );

    System.out.println("collect(joining(\",\", \"[\", \"]\"))" +
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "# " + i)
            .collect(joining(", ", "[", "]")) // # 6# 6# 10# 10
    );

    // Set은 순서보장이 안되기때문에 distinct로 중복제거
    System.out.println("distinct().collect(toList())" +
        Stream.of(1, 3, 3, 5, 5)
            .filter(i -> i > 2)
            .map(i -> i * 2)
            .map(i -> "# " + i)
            .distinct()
            .collect(toList())
    );

    // Integer caching이 되어서 ==를 해도 값이 나온다.
    // 기본적으로 Integer Caching은 -128 ~ 127까지이다.
    // 1, 2, 3, 4, 5를 new Integer(1)로 들어가지 않는다.
    // Integer.valueOf(1) -> Integer Object을 리턴한다.
    // Integer.valueOf는 Caching을 한다.

    //
    Integer integer3 = 3;
    System.out.println("filter(i -> i == 3).findFirst: " +
      Stream.of(1, 2, 3, 4, 5)
          .filter(i -> i == integer3)
          .findFirst()
    );

    Integer integer127 = 127;
    System.out.println("filter(i -> i == 3).findFirst: " +
        Stream.of(1, 2, 3, 4, 5, 127)
            .filter(i -> i == integer127)
            .findFirst()
    );

    Integer integer128 = 128;
    System.out.println("filter(i -> i == 3).findFirst: " +
        Stream.of(1, 2, 3, 4, 5, 128)
            .filter(i -> i == integer128)
            .findFirst()
    );

    // 128은 캐싱이 안되기때문에 새로운 Object를 생성
    // 같은 메모리 레퍼런스를 가지기 않기 때문에
    // 그래서 == 가 안나온다.
    System.out.println("i.equals(integer128).findFirst: " +
        Stream.of(1, 2, 3, 4, 5, 128)
            .filter(i -> i.equals(integer128))
            .findFirst()
    );

    // 기존의 foreach는 External Iterator
    final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    for (Integer number: numbers) {
      System.out.println(number);
    }

    // Stream의 forEach는 Internal Iterator
    Stream.of(1, 2, 3, 4, 5)
        .forEach(i -> System.out.println(i));

  }

}
