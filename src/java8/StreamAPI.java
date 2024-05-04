package java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(now, ZoneId.systemDefault());
        long date = zdt.toInstant().toEpochMilli();
        List<String> productList = List.of("a", "b");
        Stream<String> streamOfCollection = productList.stream();
        boolean check = streamOfCollection
                .map(product -> product + "c")
                .anyMatch(price -> price.equals("bc"));
        LocalDateTime now1 = LocalDateTime.now();
        ZonedDateTime zdt1 = ZonedDateTime.of(now1, ZoneId.systemDefault());
        long date1 = zdt1.toInstant().toEpochMilli();
        long huy = date1 - date;
        System.out.println(huy);
        System.out.println(check);
    }
}
