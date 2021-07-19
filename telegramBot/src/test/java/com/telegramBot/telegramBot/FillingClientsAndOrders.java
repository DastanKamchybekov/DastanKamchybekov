package com.telegramBot.telegramBot;

import com.telegramBot.telegramBot.Entity.ClientOrder;
import com.telegramBot.telegramBot.Entity.OrderProduct;
import com.telegramBot.telegramBot.Entity.Product;
import com.telegramBot.telegramBot.Entity.Сlient;
import com.telegramBot.telegramBot.Repository.OrderProductRepository;
import com.telegramBot.telegramBot.Repository.OrderRepository;
import com.telegramBot.telegramBot.Services.EntitiesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FillingClientsAndOrders {

    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    EntitiesService entitiesService;

    private void CreateAndSaveOrderProduct(Product product, ClientOrder order){
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setCountProduct(1);
        orderProduct.setProduct(product);
        orderProduct.setOrder(order);
        orderProductRepository.save(orderProduct);
    }


    private ClientOrder CreateAndSaveOrder(Double total, Integer status, Сlient client){
        ClientOrder order = new ClientOrder();
        order.setTotal(total);
        order.setClient(client);
        order.setStatus(status);
        orderRepository.save(order);
        return order;
    }


    @Test
    public void createOrders(){
        Сlient client1 = entitiesService.getClientById(1L);
        Сlient client2 = entitiesService.getClientById(2L);
        ClientOrder order1 = CreateAndSaveOrder(100.00,0,client1);
        ClientOrder order2 = CreateAndSaveOrder(200.00,0,client2);
        ClientOrder order3 = CreateAndSaveOrder(1200.00,0,client2);
        Product product1 = entitiesService.getProductById(17L);
        Product product2 = entitiesService.getProductById(18L);
        Product product3 = entitiesService.getProductById(19L);
        Product product4 = entitiesService.getProductById(20L);
        Product product5 = entitiesService.getProductById(21L);
        Product product6 = entitiesService.getProductById(22L);
        CreateAndSaveOrderProduct(product1,order1);
        CreateAndSaveOrderProduct(product2,order1);
        CreateAndSaveOrderProduct(product3,order1);
        CreateAndSaveOrderProduct(product1,order2);
        CreateAndSaveOrderProduct(product4,order2);
        CreateAndSaveOrderProduct(product6,order2);
        CreateAndSaveOrderProduct(product5,order3);
        CreateAndSaveOrderProduct(product4,order3);
        CreateAndSaveOrderProduct(product1,order3);
        CreateAndSaveOrderProduct(product2,order3);
    }
}
