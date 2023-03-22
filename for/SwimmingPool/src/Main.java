public class Main {
    public static void main(String[] args) {

        int volume = 1200;

        int fillingSpeed = 30; //30 litres per minute

        int devastationSpeed = 10; //10 litres per minute

        int volumeNow = 0;

        int count = 0;


        while (true){

            count = count + 1;
            volumeNow = volumeNow + fillingSpeed - devastationSpeed;
            System.out.println(volumeNow + "    " + count);

            if(volumeNow >= volume){
                System.out.println("Колличество итераций цикла: " + count);
                break;
            }
        }
    }
}