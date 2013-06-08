import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

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


}
