package com.boardmaster.boardmasterapi.domain;

import com.boardmaster.boardmasterapi.domain.repository.TestEntityOnlyIdRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class MergeUpdateTest {

    @Autowired
    TestEntityOnlyIdRepository repository;

    @Test
    @Rollback(value = false)
    void testMergeUpdate() {
        String id = UUID.randomUUID().toString();

        TestEntityOnlyId testEntity = new TestEntityOnlyId();
        testEntity.setId(id);
        testEntity.setName("테스트");
        testEntity.setAge(10);
        // 트랜잭션 시작
        repository.save(testEntity);
        // 트랜잭션 종료
        System.out.println("testEntity = " + testEntity);

        TestEntityOnlyId testEntity2 = new TestEntityOnlyId();
        testEntity2.setId(id);
        testEntity2.setName("테스트2");
        // 트랜잭션 시작
        repository.save(testEntity2);
        // 트랜잭션 종료
        System.out.println("testEntity2 = " + testEntity2);

        // 조회
        Optional<TestEntityOnlyId> entityOptional = repository.findById(id);
        TestEntityOnlyId findEntity = entityOptional.get();
        System.out.println("findEntity="+findEntity);
    }
}
