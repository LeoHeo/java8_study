import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Heo, Jin Han
 * @since 2018-03-04
 */
public class StreamExamples4 {

  public static void main(String[] args) {
    final List<Product> products =
        Arrays.asList(
            new Product(1L, "A", new BigDecimal("100.50")),
            new Product(2L, "B", new BigDecimal("23.00")),
            new Product(3L, "C", new BigDecimal("31.45")),
            new Product(4L, "D", new BigDecimal("80.20")),
            new Product(5L, "E", new BigDecimal("7.50"))
        );

    // Products.price >= 30
    final BigDecimal price30 = new BigDecimal("30");
    System.out.println("product.price >= 30: " +
        products.stream()
            .filter(product -> product.getPrice().compareTo(price30) >= 0)
            .collect(toList())
    );

    System.out.println("\n================================");
    System.out.println("product.price >= 30 with collect(joining(\"\\n\")):\n" +
        products.stream()
            .filter(product -> product.getPrice().compareTo(price30) >= 0)
            .map(product -> product.toString())
            .collect(joining("\n"))
    );

    System.out.println("\n=================================");
    System.out.println("IntStream.sum: " +
        IntStream.of(1, 2, 3, 4, 5)
            .sum()
    );

    // Stream에는 sum메소드가 없다.
    // 그래서 reduce를 사용한다.
    // Element을 하나하나 줄여나가서 하나만 남기기 때문에 reduce이다.
    System.out.println("\n=================================");
    System.out.println("Total price: " +
            products.stream()
                .map(product -> product.getPrice())
                .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        // initial value, function argument을 arity라고 한다.
        // https://en.wikipedia.org/wiki/Arity
    );

    System.out.println("\n=================================");
    System.out.println("Total price of price >= 30: " +
        products.stream()
            .filter(product -> product.getPrice().compareTo(price30) >= 0)
            .map(product -> product.getPrice())
            // .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
    );

    System.out.println("\n=================================");
    System.out.println("Count of price >= 30: " +
        products.stream()
            .filter(product -> product.getPrice().compareTo(price30) >= 0)
            .count()
    );

    final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
    final OrderedItem item2 = new OrderedItem(1L, products.get(2), 3);
    final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);

    final Order order = new Order(1L, Arrays.asList(item1, item2, item3));

    System.out.println("\n=================================");
    System.out.println("order.totalPrice(): " +
        order.totalPrice()
    );
  }
}

@AllArgsConstructor
@Data
class Product {

  private Long id;
  private String name;
  private BigDecimal price;
}

@AllArgsConstructor
@Data
class OrderedItem {

  private Long id;
  private Product product;
  private int quantity;

  public BigDecimal getTotalPrice() {
    return product.getPrice().multiply(new BigDecimal(quantity));
  }
}

@AllArgsConstructor
@Data
class Order {

  private Long id;
  private List<OrderedItem> items;

  public BigDecimal totalPrice() {
    return items.stream()
        .map(item -> item.getTotalPrice())
        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));
  }
}