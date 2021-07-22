package session7.account;

public class CurrentAccount extends BankAccount {
    private int overdraft;

    public CurrentAccount(long accountNr, String name, int overdraft) {
        super(accountNr, name);
        this.overdraft = overdraft;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public double getBalance(){
        return super.getBalance() + overdraft;
    }

//    public String withdraw(int amount){
//        if(amount <= 0){
//            return String.format("WITHDRAW: Amount must be positive [%d]", amount);
//        }
//
//        if(amount > balance+overdraft){
//            return String.format("WITHDRAW: Insufficient amount. Balance: %.2f, amount: %d, diff: %.2f",
//                    getBalance(), amount, amount - getBalance());
//        }
//        balance -= amount;
//        return String.format("WITHDRAW: Amount [%d] withdrawn successfully", amount);
//    }

    @Override
    public String toString() {
        return super.toString()+String.format(", overdarft: %d",overdraft);
    }
}
