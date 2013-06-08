
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/8/13
 * Time: 1:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenAccountTest {
    BankAccountDao mockBankAccountDao = mock (BankAccountDao.class);

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        BankAccount.setBankAccountDao(mockBankAccountDao);
    }

    @Test
    public void testConnectionFromBankAccountToMockDao() {
        String accountNumber = "1234567890";
        BankAccount.openAccount(accountNumber);
        verify(mockBankAccountDao,times(1));
    }

    @Test
    public void testOpenNewAccountWithZeroBalanceAndIsPersistent() {
        String accountNumber = "1234567890";
        BankAccount.openAccount(accountNumber);

        ArgumentCaptor <BankAccountDTO> argumentList = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDao,times(2)).save(argumentList.capture());
        List<BankAccountDTO> saveRecord = argumentList.getAllValues();
        assertEquals(saveRecord.get(1).getBalance(), 0.0, 0.001);
        assertEquals(saveRecord.get(1).getAccountNumber(), accountNumber);
    }
}
