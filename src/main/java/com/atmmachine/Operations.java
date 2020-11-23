package com.atmmachine;

import com.atmmachine.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;

public class Operations {

    public Operations(){};

    private User user;

    @Autowired
    public Operations(User user){
        this.user = user;
    }

    public User selectUser(int pinCode){
        switch (pinCode){
            case 1234:
                return new User(1234,"John","Johnson", 5000);
            case 0000:
                return new User(0000,"Dave","Johnson", 10000);

            case 1111:
                return new User(1111,"Sam","Johnson", 3400);

            default:
                return null;

        }
    }

    public int addMoney(User user, int sum) {
        CalculateValues calculateValues = (s) -> {return s + user.getAccountValue();};
        user.setAccountValue(calculateValues.calculate(sum));
        System.out.println("Sum added" + user.getAccountValue());
        return user.getAccountValue();
    }

    public int takeMoney(User user, int suma) throws InsufficientFundsException {
        int depozit = user.getAccountValue();
        if(suma < depozit){
            CalculateValues calculateValues = (s) -> {return depozit - s;};
            user.setAccountValue(calculateValues.calculate(suma));
            System.out.println("Sum taken: " + suma + " Total balance: " + depozit);
            return user.getAccountValue();
        }else{
            int necesar = suma-depozit;
            throw new InsufficientFundsException(necesar);
        }


    }
}
