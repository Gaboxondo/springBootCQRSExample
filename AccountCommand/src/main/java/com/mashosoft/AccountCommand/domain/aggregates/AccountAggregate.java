package com.mashosoft.AccountCommand.domain.aggregates;

import com.mashosoft.AccountCommand.domain.events.AccountOpenedEvent;
import com.mashosoft.AccountCommand.domain.events.CloseAccountEvent;
import com.mashosoft.AccountCommand.domain.events.DepositMoneyEvent;
import com.mashosoft.AccountCommand.domain.events.WithdrawMoneyEvent;
import com.mashosoft.AccountCommand.eventFrameworkCore.aggregates.AggregateRoot;
import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommandDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Data
public class AccountAggregate extends AggregateRoot {

    private Boolean active;
    private Double balance;
    private String accountHolder;

    public AccountAggregate(OpenAccountCommandDTO commandDTO){
        String id = UUID.randomUUID().toString();
        commandDTO.setId( id );
        applyNewEvent( AccountOpenedEvent.builder()
            .accountHolder( commandDTO.getAccountHolder() )
            .creationDate( new Date() )
            .id( commandDTO.getId() )
            .openingBalance( commandDTO.getOpeningBalance() )
            .build() );
    }

    public void apply(AccountOpenedEvent event){
        this.id = event.getId();
        this.active = true;
        this.accountHolder = event.getAccountHolder();
        this.balance = event.getOpeningBalance();
    }

    public void depositMoney(Double amount){
        if(!this.active){
            throw new IllegalStateException("Not active");
        }
        if(amount<= 0){
            throw new IllegalStateException("Amount must be greater than 0");
        }
        applyNewEvent( DepositMoneyEvent.builder()
            .id(this.id)
            .amount( amount )
            .build());
    }

    public void apply(DepositMoneyEvent event){
        this.id = event.getId();
        this.balance += event.getAmount();
    }

    public void withdrawMoney(Double amount){
        if(!this.active){
            throw new IllegalStateException("Not active account");
        }
        if(amount<= 0){
            throw new IllegalStateException("Amount must be greater than 0");
        }
        if(amount > this.getBalance()){
            throw new IllegalStateException("Insuficient founds");
        }
        applyNewEvent( WithdrawMoneyEvent.builder()
            .id(this.id)
            .amount( amount )
            .build());
    }

    public void apply(WithdrawMoneyEvent event){
        this.id = event.getId();
        this.balance -= event.getAmount();
    }

    public void closeAccount(){
        if(!this.active){
            throw new IllegalStateException("The account is already closed");
        }
        applyNewEvent( CloseAccountEvent.builder()
            .id(this.id)
            .build());
    }

    public void apply(CloseAccountEvent event){
        this.id = event.getId();
        this.active = false;
    }
}
