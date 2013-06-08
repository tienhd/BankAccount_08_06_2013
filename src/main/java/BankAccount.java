/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/8/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    public static BankAccountDao bankAccountDao;
    public static void setBankAccountDao(BankAccountDao mockBankAccountDao) {
        bankAccountDao = mockBankAccountDao;
    }

    public static void openAccount(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        bankAccountDao.save(bankAccountDTO);
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDao.getAccount(accountNumber);
    }
}
