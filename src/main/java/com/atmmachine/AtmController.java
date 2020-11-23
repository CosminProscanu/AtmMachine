package com.atmmachine;

import com.atmmachine.exceptions.InsufficientFundsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AtmController {
    Operations operations = new Operations();

    //as requested there is only one end point which takes as a parameter the pin code of the card, and then it makes two simple operations
    @GetMapping("/atm-machine/{pinCode}")
    public String firstEndPoint(@PathVariable int pinCode) {
        User user = operations.selectUser(pinCode);

        operations.addMoney(user, 10000);
        try {
            operations.takeMoney(user, 100000);
        } catch (InsufficientFundsException e) {
            log.info("You require more funds in order to make the withdrawal: " + e.getSuma());
        }

        return "ATM Machine -check the console for further details";

    }
}
