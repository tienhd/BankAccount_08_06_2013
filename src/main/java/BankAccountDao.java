import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/8/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDao {
    public ArrayList<BankAccountDTO> listBankAccount = new ArrayList<BankAccountDTO>() ;

    public BankAccountDao () {
        listBankAccount.clear();
    }

    public void save(BankAccountDTO bankAccountDTO) {
        listBankAccount.add(bankAccountDTO);
    }

    public BankAccountDTO getAccount(String accountNumber) {
        return null;
    }
}
