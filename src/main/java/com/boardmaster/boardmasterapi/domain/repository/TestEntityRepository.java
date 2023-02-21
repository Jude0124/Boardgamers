package com.boardmaster.boardmasterapi.domain.repository;

import com.boardmaster.boardmasterapi.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, String> {
}
