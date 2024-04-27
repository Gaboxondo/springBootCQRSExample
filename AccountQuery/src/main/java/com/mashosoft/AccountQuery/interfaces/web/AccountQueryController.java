package com.mashosoft.AccountQuery.interfaces.web;

import com.mashosoft.AccountQuery.interfaces.web.adapter.AccountReadInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.web.dto.AccountReadDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/accounts")
@AllArgsConstructor
public class AccountQueryController {

    private final AccountReadInterfaceAdapter accountReadInterfaceAdapter;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountReadDTO getAccountById(@PathVariable("id") String id){
        return accountReadInterfaceAdapter.getAccountById( id );
    }
}
