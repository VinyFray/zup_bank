import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppSystem {
    private List<Account> accounts;

    public AppSystem() {
        this.accounts = new ArrayList<>();
    }

    public void run(){
        int control = 0;
        while (control == 0){
            int option = IO.menu();
            if(option == 1){
                createAccount();
            } else if (option == 2) {
                System.out.println(this);
            } else if (option == -1) {
                control = 100000;
            } else if (option == 3) {
                withdrawal();
            }
        }
    }

    public void createAccount(){
        int accountNumber = (int) (Math.random() * 1000000);
        int agencyNumber = (int) (Math.random() * 1000);
        double balance = 100;
        Account account = null;

        int option = IO.input("Digite 1 para conta corrente, ou 2 para poupança").nextInt();
        if (option == 1){
            account = new Current(balance, accountNumber, agencyNumber, createCustumer());
        }else if (option == 2){
            account = new Saving(balance, accountNumber, agencyNumber, createCustumer());
        }

        accounts.add(account);
    }

    public Customer createCustumer(){
        String name = IO.input("Digite o Nome Completo").nextLine();
        String cpf = IO.input("Digite o CPF").nextLine();

        String date = IO.input("Digite a data de nascimento no formato padrão de preferencia DD/mm/yyyy").next();
        Date birthDate = DateManipulator.createDateByString(date);
        String email = IO.input("Digite o email de contato").next();
        String phoneNumber = IO.input("Digite o numero de celular para contato").next();

        return new Customer(name, cpf, birthDate, email, phoneNumber,
                new Address(null, null, null)
        );
    }

    private Account findAccount(int agency, int accountNumber){
        for (Account account : accounts){
            if (account.getAccountNumber() == accountNumber && account.getAgencyNumber() == agency){
                return account;
            }
        }
        throw new RuntimeException("Account not find");
    }

    private void withdrawal(){
        try{
            int agency = IO.input("Digite numero da agencia").nextInt();
            int accountNumber = IO.input("Digite numero da conta ").nextInt();
            Account account = findAccount(agency, accountNumber);

            double value = IO.input("Digite o valor para saque").nextDouble();
            account.withdrawalCash(value);
            System.out.println("Saque realizado");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "AppSystem{" +
                "accounts=" + accounts +
                '}';
    }
}
