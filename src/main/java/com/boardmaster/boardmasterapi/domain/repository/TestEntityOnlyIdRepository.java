package com.boardmaster.boardmasterapi.domain.repository;

import com.boardmaster.boardmasterapi.domain.TestEntityOnlyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityOnlyIdRepository extends JpaRepository<TestEntityOnlyId, String> {
}
