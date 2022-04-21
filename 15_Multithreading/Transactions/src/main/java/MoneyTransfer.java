import java.util.Random;

public class MoneyTransfer implements Runnable{
    private final Random random = new Random();
    private Bank someBank;

    MoneyTransfer(Bank someBank) {
        this.someBank = someBank;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {
            String randomAccFrom = String.valueOf(random.nextInt(99) + 1);
            String randomAccTo = String.valueOf(random.nextInt(99) + 1);
            long amount = random.nextInt(52000);
            if (randomAccFrom.equals(randomAccTo)){
                continue;
            }
            someBank.transfer(randomAccFrom, randomAccTo, amount);
        }
    }
}
