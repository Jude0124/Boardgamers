package com.boardmaster.boardmasterapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Setter @Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class TestEntityOnlyId implements Persistable<String> {

    @Id
    private String id;
    private String name;
    private Integer age;
    @CreatedDate
    private LocalDateTime createDate;

    //id가 null이 아니고, createDate가 null이면 true
    @Override
    public boolean isNew() {
        return id != null && createDate == null;
    }
}
