import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Movements {

    private String pathMovementsCsv;

    Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
    }

    double getExpenseSum() throws IOException {
        double sum = 0.0;
        ArrayList<Operation> expense = loadFileOperation();
        for (Operation ex : expense) {
            sum += Double.parseDouble(ex.getExpense());
        }
        return sum;
    }

    double getIncomeSum() {

        double sum = 0.0;
        try {
            ArrayList<Operation> income = loadFileOperation();
            for (Operation in : income) {
                sum += Double.parseDouble(in.getIncome());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sum;
    }

    ArrayList<String> listExpense() throws IOException {
        ArrayList<String> listEnd = new ArrayList<>();
        ArrayList<Operation> list = loadFileOperation();
        for (Operation op : list) {
            if (op.getOperationDescription().contains("/")) {
                String formatDescription = op.getOperationDescription().substring(op.getOperationDescription().indexOf("/") + 1).substring(0, op.getOperationDescription().indexOf("/") + 3);
                if (!op.getExpense().equals("0")) {
                    String description = formatDescription + "\t\t" + op.getExpense() + " руб";
                    listEnd.add(description);
                }
            } else {
                String formatDescription = op.getOperationDescription().substring(op.getOperationDescription().indexOf("\\") + 1).substring(0, op.getOperationDescription().indexOf("\\") + 3);
                if (!op.getExpense().equals("0")) {
                    String description = formatDescription + "\t\t" + op.getExpense() + " руб";
                    listEnd.add(description);
                }
            }

        }
        return listEnd;
    }

    private ArrayList<Operation> loadFileOperation() throws IOException {

        ArrayList<Operation> operations = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
        for (String line : lines) {
            line = line.replaceAll("\"", "");
            String[] fragments = line.split(",");

            if (line.startsWith("Тип")) {
                continue;
            }

            if (fragments.length != 8) {
                if (fragments[8].equals("0")) {
                    fragments[6] = String.join(".", fragments[6], fragments[7]);
                    fragments[7] = fragments[8];
                } else {
                    fragments[7] = String.join(".", fragments[7], fragments[8]);
                }
                operations.add(new Operation(fragments[0], fragments[1], fragments[2], fragments[3], fragments[4], fragments[5], fragments[6], fragments[7]));
            } else {
                operations.add(new Operation(fragments[0], fragments[1], fragments[2], fragments[3], fragments[4], fragments[5], fragments[6], fragments[7]));
            }
        }
        return operations;
    }
}
