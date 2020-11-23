package com.atmmachine;

import com.atmmachine.exceptions.InsufficientFundsException;
import com.atmmachine.Operations;
import com.atmmachine.User;
import org.junit.Assert;
import org.junit.Test;

public class OperationsTest {
    //we can add money
    @Test
    public void canAddMoney(){
        Operations operations = new Operations();
        User user = operations.selectUser(1111);

        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getAccountValue());
    }

    //we can take money out
    @Test(expected = InsufficientFundsException.class)
    public void canTakeMoney() throws InsufficientFundsException{
        Operations operations = new Operations();
        User user = operations.selectUser(1111);

        operations.takeMoney(user, 10000000);
    }


}
