public class TestBank {
    public static void main(String[] args){
        BankAccount appTest = new BankAccount();

        System.out.println(appTest.test());

        appTest.deposit(200);
        double checkingBalance = appTest.getCheckingBalance();
        double savingsBalance = appTest.getSavingsBalance();
        System.out.println(checkingBalance);
        System.out.println(savingsBalance);
        appTest.withdraw(300);
        appTest.withdraw(100);
        double balance = appTest.getTotalBalance();
        System.out.println(balance);
    }
}