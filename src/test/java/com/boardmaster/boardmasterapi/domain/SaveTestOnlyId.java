package com.boardmaster.boardmasterapi.domain;

import com.boardmaster.boardmasterapi.domain.repository.TestEntityOnlyIdRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
@EnableJpaAuditing
public class SaveTestOnlyId {
    @Autowired
    TestEntityOnlyIdRepository repository;

    @Test
    @Transactional
    @Rollback(value = false)
    void saveTest() {

        String id = UUID.randomUUID().toString();

        TestEntityOnlyId entity = new TestEntityOnlyId();
        entity.setId(id);
        entity.setName("반가워!");
        entity.setAge(10);
        // merge 수행
        TestEntityOnlyId newEntity = repository.save(entity);
        System.out.println("id="+entity.getId());
        System.out.println("name="+entity.getName());
        System.out.println("age="+entity.getAge());

        // entity는 영속상태가 아니다.!
        entity.setName("entity는 영속상태 아니라서 변경감지가 안된다.!");
        System.out.println("id="+entity.getId());
        System.out.println("name="+entity.getName());
        System.out.println("age="+entity.getAge());

        // newEntity는 영속상태 입니다.!
        newEntity.setName("newEntity는 변경감지가 된다!");
        System.out.println("id="+newEntity.getId());
        System.out.println("name="+newEntity.getName());
        System.out.println("age="+newEntity.getAge());
    }

    @Test
    @Rollback(value = false)
    void saveTestAddPersistable() {

        String id = UUID.randomUUID().toString();

        TestEntityOnlyId entity = new TestEntityOnlyId();
        entity.setId(id);
        entity.setName("반가워!");
        entity.setAge(10);
        repository.save(entity);
    }
}
