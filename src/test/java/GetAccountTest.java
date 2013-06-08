import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
/**
 * Created with IntelliJ IDEA.
 * User: sqv-nbt
 * Date: 6/8/13
 * Time: 2:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetAccountTest {
    BankAccountDao mockBankAccountDao = mock (BankAccountDao.class);

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        BankAccount.setBankAccountDao(mockBankAccountDao);
    }

    @Test
    public void testConnectionFromBankAccountToMockDao() {
        String accountNumber = "1234567890";
        BankAccountDTO bankAccountDTO = BankAccount.getAccount(accountNumber);
        //verify(mockBankAccountDao,times(0));
    }

    @Test
    public void testGetAccountInformation() {
        String accountNumber = "1234567890";
        BankAccountDTO bankAccountDTO = BankAccount.getAccount(accountNumber);

        ArgumentCaptor<String> accountArgument = ArgumentCaptor.forClass(String.class);
        verify(mockBankAccountDao, times(1)).getAccount(accountArgument.capture());

        assertEquals(accountArgument.getAllValues().get(0),accountNumber);

    }


}
