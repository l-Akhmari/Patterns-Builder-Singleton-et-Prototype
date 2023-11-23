package org.example.model;

public class BankAccount {
    private Long accountId;
    private double balance;
    private String currency;
    private AccountType type;
    private AccountStatus status;

    public BankAccount(Long accountId, double balance, String currency, AccountType type, AccountStatus status) {
        this.accountId = accountId;
        this.balance = balance;
        this.currency = currency;
        this.type = type;
        this.status = status;
    }

    public BankAccount() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }

    public static class AccountBuilder{
        private BankAccount bankAccount= new BankAccount();

        public AccountBuilder accoutId(Long id){
            bankAccount.accountId=id;
            return this;
        }
        public AccountBuilder balance(double balance){
            bankAccount.balance=balance;
            return this;
        }
        public AccountBuilder currency(String currency){
            bankAccount.currency=currency;
            return this;
        }
        public AccountBuilder type(AccountType accountType){
            bankAccount.type=accountType;
            return this;
        }
        public AccountBuilder status(AccountStatus status){
            bankAccount.status=status;
            return this;
        }
        public BankAccount Build(){
            return this.bankAccount;
        }

    }
}
