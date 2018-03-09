/**
 * @author Heo, Jin Han
 * @since 2018-03-08
 */
public class Singleton {

  public static void main(String[] args) {
//    final Product2 product2 = new Product2(1L, "A", new BigDecimal("12"));
//
//    System.out.println(product2);
//
//    product2.setName("B");
//    System.out.println(product2);

    // application 안에서 하나만 존재
    // instance 하나

    // Object Identity, Equality
    // new로 생성했기 때문에 heap영역에 들어간다.
    // 다른 영역에 들어가기 때문에 false
    // Singleton 아니다.
//    final OldSingleton oldSingleton1 = new OldSingleton();
//    final OldSingleton oldSingleton2 = new OldSingleton();


    // public static final String NAME = "OldSingleton"; 일때
    // 이렇게 선언되면 OldSingleton.NAME을 컴파일러가 최적화를 통해 "OldSingleton"이라는 값으로 대체를 하기 때문에
    // OldSingleton에 접근하지 않는다.

    // public static final String NAME = new String("OldSingleton");
    // 이렇게 선언되면 new String을 할때 OldSingleton의 Evaluations 발생
    // 그래서 OldSingleton의 INSTANCE도 생성

    System.out.println("=====================================");
    System.out.println("OldSingleton");
    System.out.println();
    final String name = OldSingleton.NAME;
    System.out.println(name);

    final OldSingleton oldSingleton1 = OldSingleton.INSTANCE;
    final OldSingleton oldSingleton2 = OldSingleton.INSTANCE;

    System.out.println("oldSingleton1 == oldSingleton2: " + (oldSingleton1 == oldSingleton2));

    System.out.println("=====================================");
    System.out.println("LazySingleton");
    System.out.println();


    // NAME에 접근할때는 인스턴스를 생성하지 않는다.
    //
    final String lazyName = LazySingleton.NAME;
    System.out.println(lazyName);

    final LazySingleton lazySingleton1 = LazySingleton.getInstance();
    final LazySingleton lazySingleton2 = LazySingleton.getInstance();
    System.out.println("lazySingleton1 == lazySingleton2: " + (lazySingleton1 == lazySingleton2));

    System.out.println("=====================================");
    System.out.println("NewSingleton");
    System.out.println();

    // 권장하는 방법
    final NewSingleton newSingleton1 = NewSingleton.INSTANCE;
    final NewSingleton newSingleton2 = NewSingleton.INSTANCE;
    System.out.println("newSingleton1 == newSingleton2: " + (newSingleton1 == newSingleton2));
  }
}

class OldSingleton {

  // Compile Time Constant -> 그렇게 때문에 컴파일러가 OldSingleton 클래스에 접근하지 않는다.
  // public static final String NAME = "OldSingleton";

  // Runtime Constant
  public static final String NAME = new String("OldSingleton");
  public static final OldSingleton INSTANCE = new OldSingleton();

  private OldSingleton() {
    System.out.println("OldSingleton Hi");
  }

  public void greet(final String name) {
    System.out.println(name);
  }

}

class LazySingleton {
  public static final String NAME = new String("OldSingleton");

  // OldSingleton은 NAME에 접근할때 class 초기화가 되어서 Hi가 먼저 뜹니다.
  // LazySingleton NAME에 접근할때 nested static class로 존재하기 때문에 NAME에 접근을 한다고해도 Evaluation 발생하지 않는다.

  // class 초기화를 할려면 class에 있는 필드나 메소드에 접근할때
  private static final class LazySingletonHolder {
    private static final LazySingleton INSTANCE = new LazySingleton();
  }

  private LazySingleton() {
    System.out.println("LazySingleton Hi");
  }

  // getInstance할때 holder에 접근하기 때문에 LazySingleton이 초기화가 된다.
  public static LazySingleton getInstance() {
    return LazySingletonHolder.INSTANCE;
  }

  public void greet(final String name) {
    System.out.println(name);
  }
}

enum NewSingleton {

  INSTANCE;

  public void greet(final String name) {
    System.out.println(name);
  }
}


//interface ProductDao {
//  List<Product2> allProduct();
//}
//
//// Singleton
//class ProductService {
//
//  // Singleton
//  private ProductDao productDao;
//
//  public List<Product2> getAllProduc() {
//    return productDao.allProduct();
//  }
//}
//
//@AllArgsConstructor
//@Data
//class Product2 {
//  private Long id;
//  private String name;
//  private BigDecimal price;
//}