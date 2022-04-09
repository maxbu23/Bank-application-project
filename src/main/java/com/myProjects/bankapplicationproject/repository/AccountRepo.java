package com.myProjects.bankapplicationproject.repository;

import com.myProjects.bankapplicationproject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
}
