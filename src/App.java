public class App {
    public static void main(String[] args) {

        Saving savingAccount = new Saving(
                100, 123, 456,
                new Customer("Viny", "312454", DateManipulator.createDateByString("14/07/1986"), "xablau@com", "12345",
                        new Address("1234", "Rua xablau numero 3", "12b")
                )
        );

        Current currentAccount = new Current(
                100, 123, 456,
                new Customer("Marco", "312454", DateManipulator.createDateByString("16/08/1994"), "xablau@com", "12345",
                        new Address("1234", "Rua xablau numero 3", "12b")
                )
        );

        try {
            currentAccount.withdrawalCash(201);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Saldo da conta corrente: "+currentAccount.getBalance()+"\nValor do cheque especial: "+currentAccount.getOverdrawn());
    }

}

