public class AccountValidation {
    // Todos os metodos dessa classe precisam de exception ou runtimeExceptions
    // Nenhum metodo aqui precisa de retorno (ou seja, todos void)

    //validacao se possui saldo na conta para transferencias e saques
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
    // validacao se tem saldo em cheque especial para transferencias sem saldo (apenas para contas corrente)

}
