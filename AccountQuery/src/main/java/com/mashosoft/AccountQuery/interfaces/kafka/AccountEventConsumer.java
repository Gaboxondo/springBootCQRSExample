package com.mashosoft.AccountQuery.interfaces.kafka;

import com.mashosoft.AccountQuery.interfaces.kafka.dto.AccountOpenedEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.CloseAccountEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.DepositMoneyEventDTO;
import com.mashosoft.AccountQuery.interfaces.kafka.dto.WithdrawMoneyEventDTO;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer {

    public void consume(AccountOpenedEventDTO accountOpenedEventDTO, Acknowledgment ack){

    }

    public void consume(CloseAccountEventDTO closeAccountEventDTO, Acknowledgment ack){

    }

    public void consume(DepositMoneyEventDTO depositMoneyEventDTO, Acknowledgment ack){

    }

    public void consume(WithdrawMoneyEventDTO withdrawMoneyEventDTO, Acknowledgment ack){

    }
}
