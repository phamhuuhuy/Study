package java8;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Customer {
    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

public class OptionalClass {
    public static void main(String[] args) {
        Customer customer = new Customer(1234L, "Huy", null);

        //of, empty, ofNullable
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional); // Optional.empty

        Optional<String> firstNameOptional = Optional.of(customer.getFirstName());
        System.out.println(firstNameOptional); // Optional[Huy]

        Optional<String> lastNameOptional = Optional.ofNullable(customer.getLastName());
        System.out.println(lastNameOptional); // Optional.empty

        String defaultOptional = lastNameOptional.orElse("default");
        System.out.println(defaultOptional); // default

        String defaultOptional1 = lastNameOptional.orElseGet(() -> "default");
        System.out.println(defaultOptional1); // default

        String defaultOptional2 = lastNameOptional.orElseThrow(() -> new IllegalArgumentException("No such value")); //throw error
        System.out.println(defaultOptional2);

        Optional<String> gender = Optional.of("MALE");
        gender.ifPresent((s) -> System.out.println("Value is present: " + s)); // Value is present: MALE
        emptyOptional.ifPresent((s) -> System.out.println("no value present")); // Not print

        List<String> result = List.of("abc", "def", "abcsae");
        List<String> filteredResult = Optional
                .of(result)
                .stream()
                .flatMap(Collection::stream)
                .filter(s -> s.contains("abc"))
                .collect(Collectors.toList());
        System.out.println(filteredResult);

    }
}
