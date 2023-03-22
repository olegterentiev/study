import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int value = new Scanner (System.in).nextInt();

        for(int i = 1 ; i <= value ; i++){
            int work;
            for (int z = 1 ; z <= value ; z++){
                work = i * z;
                if(work == value){
                    System.out.println(i + "*" + z);
                }
            }
        }
    }
}