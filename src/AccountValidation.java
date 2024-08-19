public class AccountValidation {
    public static void validateBalanceForWithdrawal(Account account, double valueToWithdrawal){
        if (account.getBalance() <= 0 || account.getBalance() < valueToWithdrawal){
            throw new RuntimeException("Saldo na conta insuficiente");
        }
    }

    public static void validateBalanceForWithdrawalWithCurrentAccount(Current current, double valueToWithdrawal){
        double total = current.getBalance() + current.getOverdrawn() - valueToWithdrawal;
        if(total < 0){
            throw new RuntimeException("Saldo na conta insuficiente");
        }
    }

}
