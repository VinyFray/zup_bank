public class Current extends Account{
    private double serviceCharge;
    private double overdrawn;

    public Current(double balance, int accountNumber, int agencyNumber, Customer customer) {
        super(balance, accountNumber, agencyNumber, customer);
        this.serviceCharge = 0.032;
        this.overdrawn = 100.00;
    }

    public double getOverdrawn() {
        return overdrawn;
    }

    public void setOverdrawn(double overdrawn) {
        this.overdrawn = overdrawn;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    @Override
    public double withdrawalCash(double value) {
        AccountValidation.validateBalanceForWithdrawalWithCurrentAccount(this, value);
        double result = this.getBalance() - value;
        if(result < 0){
            this.overdrawn -= value - this.getBalance();
        }
        this.setBalance(result);
        return this.getBalance();
    }

}
