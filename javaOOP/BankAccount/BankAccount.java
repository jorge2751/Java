class BankAccount {
    private static int numberOfAccounts = 0;
    private static int totalAmount = 0;
    private int checkingBalance;
    private int savingsBalance;

    public BankAccount(){
        BankAccount.numberOfAccounts+=1;
    }

    public String test(){
        return "Hello World!";
    }

    public void deposit(int amount){
        this.checkingBalance += amount;
        BankAccount.totalAmount += amount;
    }

    public void withdraw(int amount){
        if(amount <= this.checkingBalance){
            this.checkingBalance -= amount;
        }
        else{
            System.out.println("Insufficient funds");
        }
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public double getTotalBalance(){
        return this.savingsBalance + this.checkingBalance;
    }
}