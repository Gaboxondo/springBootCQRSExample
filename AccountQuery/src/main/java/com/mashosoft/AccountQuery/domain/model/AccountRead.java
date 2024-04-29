package com.mashosoft.AccountQuery.domain.model;

import com.mashosoft.AccountQuery.domain.model.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.domain.model.events.CloseAccountEvent;
import com.mashosoft.AccountQuery.domain.model.events.DepositMoneyEvent;
import com.mashosoft.AccountQuery.domain.model.events.WithdrawMoneyEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRead {
    private String id;
    private String accountHolder;
    private Date creationDate;
    private Double openingBalance;
    private Integer version;

    public AccountRead(AccountOpenedEvent accountOpenedEvent) {
        AccountRead accountRead = new AccountRead();
        accountRead.setId( accountOpenedEvent.getId() );
        accountRead.setAccountHolder( accountOpenedEvent.getAccountHolder() );
        accountRead.setCreationDate( accountOpenedEvent.getCreationDate() );
        accountRead.setOpeningBalance( accountOpenedEvent.getOpeningBalance() );
        accountRead.setVersion( accountOpenedEvent.getVersion() );
    }


    public void applyChanges(CloseAccountEvent accountOpenedEvent){

    }

    public void applyChanges(DepositMoneyEvent accountOpenedEvent){

    }

    public void applyChanges(WithdrawMoneyEvent accountOpenedEvent){

    }
}
