package com.mashosoft.AccountCommand.interfaces.web.adapter;

import com.mashosoft.AccountCommand.application.AccountEventSourceHandler;
import com.mashosoft.AccountCommand.domain.aggregates.AccountAggregate;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.CloseAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.DepositMoneyCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.OpenAccountCommandDTO;
import com.mashosoft.AccountCommand.interfaces.web.commandsDto.WithdrawMoneyCommandDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountCommandHandlerImpl implements AccountCommandHandler{

    private final AccountEventSourceHandler accountEventSourceHandler;

    @Override
    public void handle(OpenAccountCommandDTO openAccountCommandDTO) {
        AccountAggregate accountAggregate = new AccountAggregate( openAccountCommandDTO );
        accountEventSourceHandler.save( accountAggregate );
    }

    @Override
    public void handle(DepositMoneyCommandDTO depositMoneyCommandDTO) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( depositMoneyCommandDTO.getId() );
        accountAggregate.depositMoney( depositMoneyCommandDTO.getAmount() );
        accountEventSourceHandler.save( accountAggregate );
    }

    @Override
    public void handle(WithdrawMoneyCommandDTO withdrawMoneyCommandDTO) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( withdrawMoneyCommandDTO.getId() );
        if(withdrawMoneyCommandDTO.getAmount() > accountAggregate.getBalance()){
            throw new RuntimeException("Insuficient founds");
        }
        accountAggregate.withdrawMoney( withdrawMoneyCommandDTO.getAmount() );
        accountEventSourceHandler.save( accountAggregate );
    }

    @Override
    public void handle(CloseAccountCommandDTO closeAccountCommandDTO) {
        AccountAggregate accountAggregate = accountEventSourceHandler.getById( closeAccountCommandDTO.getId() );
        accountAggregate.closeAccount();
        accountEventSourceHandler.save( accountAggregate );

    }
}
