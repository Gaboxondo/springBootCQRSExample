package com.mashosoft.AccountQuery.domain.entity;

import com.mashosoft.AccountQuery.domain.events.AccountOpenedEvent;
import com.mashosoft.AccountQuery.domain.events.DepositMoneyEvent;
import com.mashosoft.AccountQuery.domain.events.WithdrawMoneyEvent;
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
    private Double balance;
    private Integer version;

    public AccountRead(AccountOpenedEvent accountOpenedEvent) {
        this.setId( accountOpenedEvent.getId() );
        this.setAccountHolder( accountOpenedEvent.getAccountHolder() );
        this.setCreationDate( accountOpenedEvent.getCreationDate() );
        this.setBalance( accountOpenedEvent.getOpeningBalance() );
        this.setVersion( accountOpenedEvent.getVersion() );
    }

    public void applyChanges(DepositMoneyEvent depositMoneyEvent){
        this.balance += depositMoneyEvent.getAmount();
        this.version = depositMoneyEvent.getVersion();
    }

    public void applyChanges(WithdrawMoneyEvent withdrawMoneyEvent){
        this.balance -= withdrawMoneyEvent.getAmount();
        this.version = withdrawMoneyEvent.getVersion();
    }
}
