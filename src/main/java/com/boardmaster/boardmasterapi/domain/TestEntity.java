package com.boardmaster.boardmasterapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter @Getter
public class TestEntity {

    @Id
    private String id;
    private String name;
}
