package com.myProjects.bankapplicationproject.repository;

import com.myProjects.bankapplicationproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface ClientRepo extends JpaRepository<Client,Long>{

    Client findClientByEmail(String email);
}
