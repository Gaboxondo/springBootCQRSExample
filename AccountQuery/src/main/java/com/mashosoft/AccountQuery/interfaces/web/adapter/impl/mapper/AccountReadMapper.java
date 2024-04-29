package com.mashosoft.AccountQuery.interfaces.web.adapter.impl.mapper;

import com.mashosoft.AccountQuery.domain.model.AccountRead;
import com.mashosoft.AccountQuery.interfaces.web.dto.AccountReadDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountReadMapper {

    public AccountReadDTO fromDomainToDTO(AccountRead accountRead){
        return AccountReadDTO.builder()
            .id( accountRead.getId() )
            .accountHolder( accountRead.getAccountHolder() )
            .creationDate( accountRead.getCreationDate() )
            .balance( accountRead.getBalance() )
            .version( accountRead.getVersion() )
            .build();
    }
}
