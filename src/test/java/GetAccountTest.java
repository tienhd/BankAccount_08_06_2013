import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

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

    @Test
    public void testOpenAccountThenGetTheAccountInformation() {
        String accountNumber = "1234567890";
        BankAccount.openAccount(accountNumber);

        ArgumentCaptor <BankAccountDTO> argumentList = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockBankAccountDao,times(1)).save(argumentList.capture());
        BankAccountDTO argumentDTO = argumentList.getAllValues().get(0);
        System.out.println(argumentDTO.getBalance() + " " + argumentDTO.getAccountNumber());

        when(mockBankAccountDao.getAccount(accountNumber)).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                String accountNumber2 = "1234567890";
                BankAccountDTO answerDTO = new BankAccountDTO(accountNumber2);
                return answerDTO;
            }
        });

        BankAccountDTO answerDTO = mockBankAccountDao.getAccount(accountNumber);
        System.out.println(answerDTO.getBalance() + " " + answerDTO.getAccountNumber());

        assertEquals(mockBankAccountDao.getAccount(accountNumber).getAccountNumber(), accountNumber);
        assertEquals(mockBankAccountDao.getAccount(accountNumber).getBalance(), 0, 0.001);

        assertEquals(answerDTO,argumentDTO);
    }

}
