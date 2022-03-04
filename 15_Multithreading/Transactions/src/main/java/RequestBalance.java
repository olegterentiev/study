public class RequestBalance implements Runnable {

    private Bank someBank;

    public RequestBalance(Bank someBank) {
        this.someBank = someBank;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("Баланс аккаунта " + i + " :" + someBank.getBalance(String.valueOf(i)));
        }
    }
}
