package com.mashosoft.AccountCommand.interfaces.web.controller;

import com.mashosoft.AccountCommand.interfaces.adapter.AccountInterfaceAdapter;
import com.mashosoft.AccountCommand.interfaces.web.dto.AccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.dto.DepositMoneyDTO;
import com.mashosoft.AccountCommand.interfaces.web.dto.OpenAccountDTO;
import com.mashosoft.AccountCommand.interfaces.web.dto.WithdrawMoneyDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/accounts")
@AllArgsConstructor
public class AccountCommandController {

    private final AccountInterfaceAdapter accountInterfaceAdapter;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO openAccount(@RequestBody OpenAccountDTO openAccountDTO){
        return accountInterfaceAdapter.createAccount( openAccountDTO );
    }

    @PutMapping("/{id}/deposit")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO depositMoney(@RequestBody DepositMoneyDTO depositMoneyDTO, @PathVariable("id") String id){
        return accountInterfaceAdapter.depositMoney(id, depositMoneyDTO );
    }

    @PutMapping("/{id}/withdraw")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO withdrawMoney(@RequestBody WithdrawMoneyDTO withdrawMoneyDTO, @PathVariable("id") String id){
        return accountInterfaceAdapter.withdrawMoney(id, withdrawMoneyDTO );
    }

    @PutMapping("/{id}/close")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO closeAccount(@PathVariable("id") String id){
        return accountInterfaceAdapter.closeAccount(id );
    }
}
