public class Account {

    private long money;
    private String accNumber;
    private boolean status = true;

    boolean isStatus() {
        return status;
    }

    void setStatus(boolean status) {
        this.status = status;
    }

    Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    long getMoney() {
        if (status) {
            return money;
        } else {
            return money;
        }
    }

    void setMoney(long money) {
        this.money = money;
    }

    private String getAccNumber() {
        return accNumber;
    }

    public String toString() {
        return " номер счёта : " + this.getAccNumber() + " сумма = " + this.getMoney() + this.isStatus() + " \n";
    }
}
