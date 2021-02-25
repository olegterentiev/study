import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {

            final int INDEX_NAME = 0;
            final int INDEX_SURNAME = 1;
            final int INDEX_EMAIL = 2;
            final int INDEX_PHONE = 3;

        try {
            String[] components = data.split("\\s+");
            if (components.length != 4) {
                throw new IllegalArgumentException("wrong format \n" + "Correct format : add Василий Петров vasily.petrov@gmail.com +79215637722");
            }
            if (!Pattern.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}", components[INDEX_EMAIL])) {
                throw new IllegalArgumentException("wrong format email \n" + "Correct format : vasily.petrov@gmail.com");
            }
            if (!Pattern.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", components[INDEX_PHONE])) {
                throw new IllegalArgumentException("wrong format telephone number \n" + "Correct format : +79215637722");
            }
            String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
            storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}