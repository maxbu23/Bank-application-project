package com.myProjects.bankapplicationproject.repository;

import com.myProjects.bankapplicationproject.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<TransactionEntity,Long> {
}
