import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        DecimalFormat format = new DecimalFormat(",###.##");
        Movements movements = new Movements(Operation.FILE_OPERATION);
        String expense = format.format(movements.getExpenseSum());
        String income = format.format(movements.getIncomeSum());
        ArrayList<String> listExpense = movements.listExpense();

        System.out.println("Сумма расходов:  " + expense + " руб");
        System.out.println("Сумма доходов:  " + income + " руб" + "\n");
        System.out.println("Суммы расходов по организациям:");
        Stream<String> str = listExpense.stream();
        str.forEach(System.out::println);
    }
}
