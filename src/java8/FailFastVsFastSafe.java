package java8;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

interface FailFast {
    static void failFast() {
        List<Integer> numbers = List.of(1,343,3);
        Iterator<Integer> iterator = numbers.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() == 2) {
//                iterator.remove(); // ok!
//            }
//            System.out.println("hehe");
//        }


        iterator = numbers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                numbers.remove(1); // exception
            }
        }
    }
}

interface FailSafe {
    static void failSafe() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            map.put("Fifth", 50);
        }
    }
}

public class FailFastVsFastSafe {
    public static void main(String[] args) {

        FailSafe.failSafe();
        FailFast.failFast();
    }
}
