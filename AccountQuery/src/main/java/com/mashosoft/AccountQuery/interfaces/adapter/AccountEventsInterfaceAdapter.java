package com.mashosoft.AccountQuery.interfaces.adapter;

import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.web.dto.AccountReadDTO;

public interface AccountEventsInterfaceAdapter {

    public void handle(AccountOpenedEventDTO accountOpenedEventDTO);
    public void handle(CloseAccountEventDTO closeAccountEventDTO);
    public void handle(DepositMoneyEventDTO depositMoneyEventDTO);
    public void handle(WithdrawMoneyEventDTO withdrawMoneyEventDTO);

}
