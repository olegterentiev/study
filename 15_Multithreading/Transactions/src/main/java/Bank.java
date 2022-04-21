import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Bank {

    private Map<String, Account> accounts;
    private final Random random = new Random();
    private long sum = 0;
    private int count = 100;
    private boolean fraud;

    Bank() {
    }

    void createAccount() {
        accounts = new HashMap<>();
        for (int i = 1; i < count; i++) {
            String num = String.valueOf(i);
            accounts.put(num, new Account(random.nextInt(1000000), num));
            System.out.println(accounts.get(num));
        }
    }

    private synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    void transfer(String fromAccountNum, String toAccountNum, long amount) {
        System.out.println(Thread.currentThread().getName());

        try {
            Account from = accounts.get(fromAccountNum);
            Account to = accounts.get(toAccountNum);

            if (!(from.isStatus() || to.isStatus())) {
                System.out.println("счет(а) заблокирован(ы)");
            } else {
                if (amount > from.getMoney()) {
                    System.out.println("Недостаточно средств на счёте : " + fromAccountNum + " Сумма перевода " + amount + " Остаток по счёту " + from.getMoney());
                } else {
                    if (amount > 50000) {
                        System.out.println("сумма перевода больше 50000   " + amount);
                        fraud = isFraud(fromAccountNum, toAccountNum, amount);
                    }
                    if (fraud) {
                        from.setStatus(false);
                        to.setStatus(false);
                        final long fromLockMoney = from.getMoney();
                        final long toLockMoney = to.getMoney();
                        from.setMoney(fromLockMoney);
                        to.setMoney(toLockMoney);
                        System.out.println("Статус проверки " + fraud + fromAccountNum + " и " + toAccountNum);
                        System.out.println("Счет : " + fromAccountNum + " с суммой " + fromLockMoney + " Заблокирован \n" + "Счет : " + toAccountNum + " с суммой " + toLockMoney + " Заблокирован");
                    } else {
                        Account sFrom;
                        Account sTo;
                        if (fromAccountNum.compareTo(toAccountNum) > 0) {
                            sFrom = from;
                            sTo = to;
                        } else {
                            sFrom = to;
                            sTo = from;
                        }
                        synchronized (sFrom) {
                            synchronized (sTo) {
                                System.out.println("Сумма до перевода from: " + fromAccountNum + " : " + from.getMoney() + "  Сумма до перевода to : " + toAccountNum + " : " + to.getMoney());
                                long fromMoney = from.getMoney() - amount;
                                long toMoney = to.getMoney() + amount;
                                from.setMoney(fromMoney);
                                to.setMoney(toMoney);
                                System.out.println("Сумма после перевода from: " + fromAccountNum + " : " + from.getMoney() + "  Сумма после перевода to : " + toAccountNum + " : " + to.getMoney());
                                System.out.println("Cумма перевода = " + amount);
                            }
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized long getBalance(String accountNum) {
        long money = accounts.get(accountNum).getMoney();
        return money;
    }

    long getSumAllAccounts() {
        if (sum == 0) {
            for (int i = 1; i < count; i++) {
                String num = String.valueOf(i);
                sum += accounts.get(num).getMoney();
            }
        } else {
            sum = 0;
            for (int i = 1; i < count; i++) {
                String num = String.valueOf(i);
                sum += accounts.get(num).getMoney();
            }
        }
        return sum;
    }
}
