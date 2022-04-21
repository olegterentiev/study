import junit.framework.TestCase;
import java.util.*;

public class BankTest extends TestCase {

    private Bank someBank = new Bank();
    private long moneyBefore;

    @Override
    public void setUp() throws Exception {

        someBank.createAccount();
        moneyBefore = someBank.getSumAllAccounts();
        System.out.println("ОБщая сумма до переводов : " + moneyBefore);
        List<Thread> threadList = new ArrayList();

        for (int i = 0; i < 15; i++) {
            threadList.add(new Thread(new MoneyTransfer(someBank)));
        }

        threadList.forEach(Thread::start);

        for (Thread thread : threadList) {
            thread.join();
        }
    }

    public void testGetSumAllAccounts() {
        double actual = moneyBefore;
        double expected = someBank.getSumAllAccounts();
        assertEquals(actual, expected);
        System.out.println(" Общая сумма после переводов : " + expected);
        System.out.println(moneyBefore + "   <->   " + expected);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
