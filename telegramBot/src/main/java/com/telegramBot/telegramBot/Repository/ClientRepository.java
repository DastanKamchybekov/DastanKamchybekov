package com.telegramBot.telegramBot.Repository;


import com.telegramBot.telegramBot.Entity.Сlient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientRepository extends JpaRepository<Сlient,Long> {

}
