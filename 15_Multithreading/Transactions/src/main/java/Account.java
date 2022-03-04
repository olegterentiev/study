public class Account {

    private long money;
    private String accNumber;
    boolean status = true;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public Account() {
    }

    public long getMoney() {
        if (status) {
            return money;
        } else {
            return money;
        }
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String toString() {
        return " номер счёта : " + this.getAccNumber() + " сумма = " + this.getMoney() + " \n";
    }
}
