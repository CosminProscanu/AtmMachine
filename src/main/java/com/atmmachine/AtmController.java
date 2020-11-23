package com.atmmachine;

import com.atmmachine.exceptions.InsufficientFundsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtmController {
        Operations operations = new Operations();

        @GetMapping("/atm-machine")
    public String firstEndPoint(){
            User user = operations.selectUser(1111);

            operations.addMoney(user,10000);
            try {
                operations.takeMoney(user, 100000);
            } catch (InsufficientFundsException e) {
                System.out.println("Va lipsesc fondurile necesare pt a realiza retragerea " + e.getSuma());
                e.printStackTrace();
            }

            return "ATM Machine" + "\n account details";

    }
}
