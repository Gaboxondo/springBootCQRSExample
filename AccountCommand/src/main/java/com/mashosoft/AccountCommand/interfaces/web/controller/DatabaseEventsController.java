package com.mashosoft.AccountCommand.interfaces.web.controller;

import com.mashosoft.AccountCommand.interfaces.web.adapter.AccountInterfaceAdapter;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.controller.dto.WithdrawMoneyDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/readDb")
@AllArgsConstructor
public class DatabaseEventsController {

    private final AccountInterfaceAdapter accountInterfaceAdapter;


    @PostMapping("/republishEvents")
    @ResponseStatus(HttpStatus.OK)
    public String openAccount(){
        accountInterfaceAdapter.restoreDbRepublishingEvents();
        return "All events have been republish, please be sure to had drop the read database before";
    }
}
