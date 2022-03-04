import java.util.Random;

public class MoneyTransfer implements Runnable {

    private final Random random = new Random();
    private Bank someBank;

    public MoneyTransfer(Bank someBank) {
        this.someBank = someBank;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            String randomAccFrom = String.valueOf(random.nextInt(9) + 1);
            String randomAccTo = String.valueOf(random.nextInt(9) + 1);
            long amount = random.nextInt(100000);
            someBank.transfer(randomAccFrom, randomAccTo, amount);
        }
    }
}
