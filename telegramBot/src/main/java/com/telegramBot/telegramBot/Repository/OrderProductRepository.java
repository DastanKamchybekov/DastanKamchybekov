package com.telegramBot.telegramBot.Repository;

import com.telegramBot.telegramBot.Entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "orderProduct", path = "orderProduct")
public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {

}
