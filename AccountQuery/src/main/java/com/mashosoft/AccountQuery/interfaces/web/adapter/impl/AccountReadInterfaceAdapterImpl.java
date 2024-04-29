package com.mashosoft.AccountQuery.interfaces.web.adapter.impl;

import com.mashosoft.AccountQuery.application.AccountReadService;
import com.mashosoft.AccountQuery.domain.model.AccountRead;
import com.mashosoft.AccountQuery.interfaces.web.adapter.AccountReadInterfaceAdapter;
import com.mashosoft.AccountQuery.interfaces.web.adapter.impl.mapper.AccountReadMapper;
import com.mashosoft.AccountQuery.interfaces.web.dto.AccountReadDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountReadInterfaceAdapterImpl implements AccountReadInterfaceAdapter {

    private final AccountReadService accountReadService;
    private final AccountReadMapper accountReadMapper;

    @Override
    public AccountReadDTO getAccountById(String id) {
        AccountRead accountRead = accountReadService.getAccountById( id );
        return accountReadMapper.fromDomainToDTO( accountRead );
    }
}
