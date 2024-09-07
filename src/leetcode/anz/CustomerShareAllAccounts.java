package leetcode.anz;

// A set of customer/account pairs indicates which customers own which accounts.
// In your choice of programming language, write the function that finds all customers who share all the same accounts.

// {1:[10,11], 3:[10,11]}

// "10-11": [1

//On
//Onlogn
//nested O n square String

// On On
// Onlogn
// O n square
import java.util.*;
import java.util.stream.Collectors;

public class CustomerShareAllAccounts {
    public List<List<Integer>> findAllCustomers(int[] customers, int[] account) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> stored = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < customers.length; i++) {
            List<Integer> itemsList = stored.get(customers[i]);
            if (itemsList == null) {
                itemsList = new ArrayList<>();
                itemsList.add(account[i]);
                stored.put(customers[i], itemsList);
            } else {
                itemsList.add(account[i]);
            }
        }
        stored.forEach((key, value) -> {
            keys.add(key);
            List<Integer> temp = new ArrayList<>(value);
            values.add(temp.stream().sorted().collect(Collectors.toList()));
        });
        for (int i = 0; i < keys.size() - 1; i++) {
            for (int j = i+1; j < keys.size(); j++) {
                if (values.get(i).size() != values.get(j).size()) continue;
                boolean check = true;
                for (int k = 0; k < values.get(i).size(); k++) {
                    if (!Objects.equals(values.get(i).get(k), values.get(j).get(k))) {
                        check = false;
                        break;
                    }
                }
                if (check) result.add(List.of(keys.get(i), keys.get(j)));
            }
        }


        return result;
    }

    public static void main(String[] args) {
        CustomerShareAllAccounts customerShareAllAccounts = new CustomerShareAllAccounts();
        List<List<Integer>> customer = customerShareAllAccounts.findAllCustomers(
                new int[]{1, 1, 22, 3, 4, 3, 4, 5, 5, 6},
                new int[]{10,11,13,11,14,10,13,10,11,13});
        customer.forEach((list) -> {
            System.out.println("-------");
            list.forEach(System.out::println);
            System.out.println("-------");
        });
    }
}
