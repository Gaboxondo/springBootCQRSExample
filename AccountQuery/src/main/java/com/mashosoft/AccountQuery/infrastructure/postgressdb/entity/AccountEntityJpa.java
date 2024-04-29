package com.mashosoft.AccountQuery.infrastructure.postgressdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntityJpa {

    @Id
    private String id;
    @Column
    private String accountHolder;
    @Column
    private Date creationDate;
    @Column
    private Double openingBalance;
    @Column
    private Integer version;
}
