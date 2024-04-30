package com.mashosoft.AccountCommand.interfaces.web.controller;

import com.mashosoft.AccountCommand.interfaces.adapter.AccountInterfaceAdapter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/readDb")
@AllArgsConstructor
@Slf4j
public class DatabaseController {

    private final AccountInterfaceAdapter accountInterfaceAdapter;


    @PostMapping("/republishEvents")
    @ResponseStatus(HttpStatus.OK)
    public String republishEvents(){
        log.info( "Request received for reconstruct the database" );
        accountInterfaceAdapter.restoreDbRepublishingEvents();
        return "All events have been republish, please be sure to had drop the read database before";
    }
}
