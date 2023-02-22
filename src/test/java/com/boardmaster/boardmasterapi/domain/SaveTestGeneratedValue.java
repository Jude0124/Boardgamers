package com.boardmaster.boardmasterapi.domain;

import com.boardmaster.boardmasterapi.domain.repository.TestEntityGeneratedValueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
public class SaveTestGeneratedValue {
    @Autowired
    TestEntityGeneratedValueRepository repository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    @Rollback(value = false) // sql을 확인하기 위함
    void saveTest() {
        TestEntityGeneratedValue entity = new TestEntityGeneratedValue();
        entity.setName("안녕!");

        repository.save(entity);
        System.out.println("id="+entity.getId());
        System.out.println("name="+entity.getName());

        entity.setName("변경감지!");
        System.out.println("id="+entity.getId());
        System.out.println("name="+entity.getName());
    }
}
