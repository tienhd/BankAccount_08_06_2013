/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/8/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private double balance;

    public BankAccountDTO () {
        this.balance = 0;
        this.accountNumber = "";
    }

    public BankAccountDTO (String accountNumber) {
        this.balance = 0;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber (String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BankAccountDTO) {
            BankAccountDTO BankAccountDTOObj = (BankAccountDTO) o;
            return ((balance == BankAccountDTOObj.getBalance()) && accountNumber.equals(BankAccountDTOObj.getAccountNumber()));
        }
        return false;
    }
}
