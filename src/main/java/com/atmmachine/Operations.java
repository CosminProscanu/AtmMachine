package com.atmmachine;

import com.atmmachine.exceptions.InsufficientFundsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class Operations {

    public Operations() {
    }


    private User user;

    @Autowired
    public Operations(User user) {
        this.user = user;
    }

    public User selectUser(int pinCode) {
        switch (pinCode) {
            case 1234:
                return new User(1234, "John", "Johnson", 5000);
            case 0000:
                return new User(0000, "Dave", "Johnson", 10000);
            case 1111:
                return new User(1111, "Sam", "Johnson", 3400);

            default:
                return null;

        }
    }

    public int addMoney(User user, int sum) {
        CalculateValues calculateValues = (s) -> {
            return s + user.getAccountValue();
        };
        user.setAccountValue(calculateValues.calculate(sum));
        log.info("Sum added" + user.getAccountValue());
        return user.getAccountValue();
    }

    public int takeMoney(User user, int sum) throws InsufficientFundsException {
        int deposit = user.getAccountValue();
        if (sum < deposit) {
            CalculateValues calculateValues = (s) -> {
                return deposit - s;
            };
            user.setAccountValue(calculateValues.calculate(sum));
            log.info("Sum taken: " + sum + " Total balance: " + deposit);
            return user.getAccountValue();
        } else {
            int necesarry = sum - deposit;
            throw new InsufficientFundsException(necesarry);
        }


    }
}
