package com.boardmaster.boardmasterapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class TestEntityGeneratedValue {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
