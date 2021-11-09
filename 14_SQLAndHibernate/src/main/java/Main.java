
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest1234";
        System.out.printf("%-40s | %15s %n", "Название курса", "среднее значение");
        System.out.println("-----------------------------------------------------------");
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(subscription_date) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) AS avg FROM PurchaseList WHERE year(subscription_date) = 2018 GROUP BY course_name;");

            while (resultSet.next()) {
                String courseName = resultSet.getString(1);
                String avg = resultSet.getString(2);
                System.out.printf("%-40s | %15s %n", courseName, avg);
            }
            resultSet.close();
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
