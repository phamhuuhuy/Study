package java8;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@java.lang.FunctionalInterface
interface MyFunctionInterface {
    void print(String msg);

    default void m1() {
        System.out.println("default method");
    }

    static void m2() {
        System.out.println("static method");
    }
}

public class FunctionalInterface {
    public static Integer testFunctionParam(Function<String, Integer> fuc) {
        return fuc.apply("hello moi nguoi");
    }

    public static void testConsumerParam(Consumer<String> consumer) {
        consumer.accept("hello moi nguoi consumer");
    }

    public static LocalDateTime testSupplierParam(Supplier<LocalDateTime> supplier) {
        return supplier.get();
    }
    public static void main(String[] args) {
        MyFunctionInterface myFunctionInterface =
                (String msg) -> System.out.println(msg);

        myFunctionInterface.print("hello");

        System.out.println(testFunctionParam((String s) -> s.length()));

        testConsumerParam((String s) -> System.out.println(s));

        System.out.println(testSupplierParam(() -> LocalDateTime.now()));

        Predicate<Integer> lessThanEighteen = i -> (i < 18);
        Predicate<Integer> greaterThanTen = i -> (i > 10);

        System.out.println(greaterThanTen.test(11));

        Predicate<Integer> greaterThanEighteen = lessThanEighteen.negate();

        System.out.println(greaterThanEighteen.test(20));
    }
}
