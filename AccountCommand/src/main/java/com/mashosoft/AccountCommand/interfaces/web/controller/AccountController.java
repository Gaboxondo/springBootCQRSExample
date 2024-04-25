package com.mashosoft.AccountCommand.interfaces.web.controller;

import com.mashosoft.AccountCommand.interfaces.web.adapter.AccountCommandHandler;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyCommandDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/v1/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountCommandHandler accountCommandHandler;


    @PostMapping
    public ResponseEntity<String> openAccount(@RequestBody OpenAccountCommandDTO openAccountCommandDTO){
        //Move it properly later
        String id = UUID.randomUUID().toString();
        openAccountCommandDTO.setId( id );
        accountCommandHandler.handle( openAccountCommandDTO );
        return new ResponseEntity<>( id,HttpStatus.CREATED );
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<String> depositMoney(@RequestBody DepositMoneyCommandDTO depositMoneyCommandDTO,
        @PathVariable("id") String id){
        depositMoneyCommandDTO.setId( id );
        accountCommandHandler.handle( depositMoneyCommandDTO );
        return new ResponseEntity<>( "OK",HttpStatus.CREATED );
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<String> withdrawMoney(@RequestBody WithdrawMoneyCommandDTO withdrawMoneyCommandDTO,
        @PathVariable("id") String id){
        withdrawMoneyCommandDTO.setId( id );
        accountCommandHandler.handle( withdrawMoneyCommandDTO );
        return new ResponseEntity<>( "OK",HttpStatus.CREATED );
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<String> closeAccount(@RequestBody CloseAccountCommandDTO closeAccountCommandDTO,
        @PathVariable("id") String id){
        closeAccountCommandDTO.setId( id );
        accountCommandHandler.handle( closeAccountCommandDTO );
        return new ResponseEntity<>( "OK",HttpStatus.CREATED );
    }
}
