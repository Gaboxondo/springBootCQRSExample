package com.mashosoft.AccountQuery.infrastructure.postgressdb.repository;

import com.mashosoft.AccountQuery.infrastructure.postgressdb.entity.AccountEntityJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountEntityJpa, String> {
}
