public class Main {

    public static void main(String[] args) {

        Bank someBank = new Bank();
        someBank.createAccount();
        System.out.println("Сумма всех средств до переводов :" + someBank.getSumAllAccounts());

            Thread thread1 = new Thread(new MoneyTransfer(someBank));
            Thread thread2 = new Thread(new RequestBalance(someBank));

            thread1.start();
            thread2.start();
    }
}
