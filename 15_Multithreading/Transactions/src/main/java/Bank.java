import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();
    private volatile long sum = 0;
    private volatile int count = 10;
    private boolean fraud;

    public void createAccount() {
        accounts = new Hashtable<>();
        for (int i = 1; i < count; i++) {
            String num = String.valueOf(i);
            accounts.put(num, new Account(random.nextInt(1000000), num));
            System.out.println(accounts.get(num));
        }
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {

        try {
            if (amount > 50000) {
                fraud = isFraud(fromAccountNum, toAccountNum, amount);
                System.out.println(" Выполняется перевод с аккаунта " + fromAccountNum + " в аккаунт " + toAccountNum + " Сумма больше 50000 : " + amount + fraud);
            }
            if (amount > 50000 && fraud) {
                final long fromLockMoney = accounts.get(fromAccountNum).getMoney();
                final long toLockMoney = accounts.get(toAccountNum).getMoney();


                synchronized (accounts){
                accounts.get(fromAccountNum).setStatus(false);
                accounts.get(toAccountNum).setStatus(false);
                accounts.get(fromAccountNum).setMoney(fromLockMoney);
                accounts.get(toAccountNum).setMoney(toLockMoney);
                }


                System.out.println("Счет : " + fromAccountNum + " с суммой " + fromLockMoney + " Заблокирован \n" + "Счет : " + toAccountNum + " с суммой " + toLockMoney + " Заблокирован" );
            } else {
                Account from = accounts.get(fromAccountNum);
                Account to = accounts.get(toAccountNum);
                if(amount > from.getMoney()){
                    System.out.println("Недостаточно средств на счёте : " + fromAccountNum);
                } else {

                synchronized (from){
                    synchronized (to){
                        System.out.println("Сумма до перевода from: "+ fromAccountNum + " : " + from.getMoney() + "  Сумма до перевода to : " + toAccountNum + " : " + to.getMoney());
                        long fromMoney = from.getMoney() - amount;
                        long toMoney = to.getMoney() + amount;
                        from.setMoney(fromMoney);
                        to.setMoney(toMoney);
                        System.out.println("Сумма после перевода from: "+ fromAccountNum + " : " + from.getMoney() + "  Сумма после перевода to : " + toAccountNum + " : " + to.getMoney());
                        System.out.println("Cумма перевода = " + amount);
                    }
                }}
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public synchronized long getBalance(String accountNum) {

        long money = accounts.get(accountNum).getMoney();
        return money;
    }

    public synchronized long getSumAllAccounts() {
        for (int i = 1; i < count; i++) {
            String num = String.valueOf(i);
            sum += accounts.get(num).getMoney();
        }
        return sum;
    }
}
