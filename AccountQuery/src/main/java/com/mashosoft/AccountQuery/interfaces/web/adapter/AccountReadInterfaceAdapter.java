package com.mashosoft.AccountQuery.interfaces.web.adapter;

import com.mashosoft.AccountQuery.interfaces.web.dto.AccountReadDTO;

public interface AccountReadInterfaceAdapter {

    public AccountReadDTO getAccountById(String id);
}
