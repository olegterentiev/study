import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число");
        int first = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число");
        int second = new Scanner (System.in).nextInt();



        Arithmetic one = new Arithmetic(first,second);

        print(one);


    }
    public static void print(Arithmetic arithmetic){
       System.out.println(arithmetic.sum() + " - Сумма \n"
               + arithmetic.multiplication() + " - Произведение \n"
               + arithmetic.max() + " - Максимальное \n"
               + arithmetic.min() + " - Минимальное");
    }
}