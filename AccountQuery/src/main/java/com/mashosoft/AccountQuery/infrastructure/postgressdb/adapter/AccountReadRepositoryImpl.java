package com.mashosoft.AccountQuery.infrastructure.postgressdb.adapter;

import com.mashosoft.AccountQuery.domain.model.AccountRead;
import com.mashosoft.AccountQuery.domain.repository.AccountReadRepository;
import com.mashosoft.AccountQuery.infrastructure.postgressdb.entity.AccountEntityJpa;
import com.mashosoft.AccountQuery.infrastructure.postgressdb.repository.AccountJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountReadRepositoryImpl implements AccountReadRepository {

    private final AccountJpaRepository accountJpaRepository;
    private final AccountDbMapper accountDbMapper;

    @Override
    public AccountRead getAccountReadFromDatabaseById(String id) {
        AccountEntityJpa accountEntityJpa = accountJpaRepository.findById( id ).orElse( null );
        if(accountEntityJpa == null){
            return null;
        }
        return accountDbMapper.fromDbToDomain( accountEntityJpa );
    }

    @Override
    public AccountRead save(AccountRead accountRead) {
        AccountEntityJpa accountEntityJpa = accountDbMapper.fromDomainToDb( accountRead );
        accountJpaRepository.save( accountEntityJpa );
        return accountRead;
    }

    @Override
    public AccountRead delete(AccountRead accountRead) {
        AccountEntityJpa accountEntityJpa = accountDbMapper.fromDomainToDb( accountRead );
        accountJpaRepository.delete( accountEntityJpa );
        return accountRead;
    }
}
