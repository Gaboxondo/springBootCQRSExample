package com.mashosoft.AccountCommand.domain.aggregates;

import com.mashosoft.AccountCommand.domain.commands.OpenAccountCommand;
import com.mashosoft.AccountCommand.domain.events.model.AccountEventTypes;
import com.mashosoft.AccountCommand.domain.events.model.AccountUpdateEvent;
import com.mashosoft.AccountCommand.eventFrameworkCore.aggregates.AggregateRoot;
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

    public AccountAggregate(OpenAccountCommand commandDTO){
        String id = UUID.randomUUID().toString();
        commandDTO.setId( id );
        applyNewEvent( AccountUpdateEvent.builder()
            .operation( AccountEventTypes.ACCOUNT_CREATED.name() )
            .accountHolder( commandDTO.getAccountHolder() )
            .creationDate( new Date() )
            .id( commandDTO.getId() )
            .openingBalance( commandDTO.getOpeningBalance() )
            .build() );
    }

    public void depositMoney(Double amount){
        if(!this.active){
            throw new IllegalStateException("Not active");
        }
        if(amount<= 0){
            throw new IllegalStateException("Amount must be greater than 0");
        }
        applyNewEvent( AccountUpdateEvent.builder()
            .operation( AccountEventTypes.DEPOSIT_MONEY.name() )
            .id(this.id)
            .amount( amount )
            .build());
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
        applyNewEvent( AccountUpdateEvent.builder()
            .id(this.id)
            .operation( AccountEventTypes.WITHDRAW_MONEY.name() )
            .amount( amount )
            .build());
    }

    public void closeAccount(){
        if(!this.active){
            throw new IllegalStateException("The account is already closed");
        }
        applyNewEvent( AccountUpdateEvent.builder()
            .operation( AccountEventTypes.ACCOUNT_CLOSED.name() )
            .id(this.id)
            .build());
    }

    public void apply(AccountUpdateEvent event){
        if(AccountEventTypes.ACCOUNT_CREATED.name().equals( event.getOperation())) {
            this.id = event.getId();
            this.active = true;
            this.accountHolder = event.getAccountHolder();
            this.balance = event.getOpeningBalance();
        } else if(AccountEventTypes.ACCOUNT_CLOSED.name().equals( event.getOperation())){
            this.id = event.getId();
            this.active = false;
        } else if(AccountEventTypes.DEPOSIT_MONEY.name().equals( event.getOperation())){
            this.id = event.getId();
            this.balance += event.getAmount();
        }else if(AccountEventTypes.WITHDRAW_MONEY.name().equals( event.getOperation())){
            this.id = event.getId();
            this.balance -= event.getAmount();
        }
    }
}
