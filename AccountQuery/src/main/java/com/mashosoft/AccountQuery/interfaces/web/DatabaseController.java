package com.mashosoft.AccountQuery.interfaces.web;

import com.mashosoft.AccountQuery.interfaces.adapter.DatabaseInterfaceAdapter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/db")
@AllArgsConstructor
public class DatabaseController {

    private final DatabaseInterfaceAdapter databaseInterfaceAdapter;


    @PostMapping("/reconstruct")
    @ResponseStatus(HttpStatus.OK)
    public void reconstructDb(){
        databaseInterfaceAdapter.reconstructDb();
    }
}
