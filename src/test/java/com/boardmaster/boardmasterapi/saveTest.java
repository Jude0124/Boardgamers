package com.boardmaster.boardmasterapi;

import com.boardmaster.boardmasterapi.domain.TestEntity;
import com.boardmaster.boardmasterapi.domain.repository.TestEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest
public class saveTest {

    @Autowired
    TestEntityRepository repository;

    @Test
    void jpaSaveTest() {
        // uuid 생ㅇㅇㅇㅁㄴ
        String id = UUID.randomUUID().toString();

        TestEntity testEntity = new TestEntity();
        testEntity.setId(id);
        testEntity.setName("비영속상태 객체 생성");

        /**
         * merge를 실행합니다.
         *
         * save() 메소드에 있는
         * isNew() 메소드는
         * 엔티티의 PK가 null 이거나
         * 원시타입인 경우는 초기값(0, 0L)인 경우만 true,
         * 그외는 false 처리 됩니다.
         */
        TestEntity newEntity = repository.save(testEntity);
        System.out.println("name1="+newEntity.getName());

        /**
         * newEntity 준영속(detach) 상태가 아닙니다.
         * 비영속(new) 상태 입니다.
         * 따라서 영속(managed) 상태가 될수 없습니다.
         * 그 결과 변경감지가 일어나지 않습니다.
         */
        newEntity.setName("변경감지 확인");
        System.out.println("name2="+newEntity.getName());
    }
}
