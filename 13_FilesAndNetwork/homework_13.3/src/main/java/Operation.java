class Operation {

    static final String FILE_OPERATION = "data/movementList.csv";

    private String accountType;
    private String accountNumber;
    private String currently;
    private String transactionDate;
    private String operationReference;
    private String operationDescription;
    private String income;
    private String expense;

    Operation(String accountType, String accountNumber, String currently, String transactionDate, String operationReference, String operationDescription, String income, String expense) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currently = currently;
        this.transactionDate = transactionDate;
        this.operationReference = operationReference;
        this.operationDescription = operationDescription;
        this.income = income;
        this.expense = expense;
    }

    String getAccountType() {
        return accountType;
    }

    String getAccountNumber() {
        return accountNumber;
    }

    String getCurrently() {
        return currently;
    }

    String getTransactionDate() {
        return transactionDate;
    }

    String getOperationReference() {
        return operationReference;
    }

    String getOperationDescription() {
        return operationDescription;
    }

    String getExpense() {
        return expense;
    }

    String getIncome() {
        return income;
    }

    public String toString(){
        return accountType + accountNumber + currently + transactionDate + operationReference + operationDescription + income + expense;
    }
}
