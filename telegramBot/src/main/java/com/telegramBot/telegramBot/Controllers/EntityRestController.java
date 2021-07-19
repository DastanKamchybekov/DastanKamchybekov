package com.telegramBot.telegramBot.Controllers;

import com.telegramBot.telegramBot.Entity.Category;
import com.telegramBot.telegramBot.Entity.ClientOrder;
import com.telegramBot.telegramBot.Entity.Product;
import com.telegramBot.telegramBot.Entity.Сlient;
import com.telegramBot.telegramBot.Services.EntitiesService;
import com.telegramBot.telegramBot.Services.EntityServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntityRestController {
    private final EntitiesService entitiesService;

    public  EntityRestController(EntityServiceImpl entitiesService){
        this.entitiesService = entitiesService;
    }

    @GetMapping("/rest/clients")
    public List<Сlient> getAllClients() {
        return entitiesService.getAllClients();
    }

    @RequestMapping(value = "/rest/clients",params = {"id"})
    public Сlient getClientById(@RequestParam Long id) {
        return entitiesService.getClientById(id);
    }

    @RequestMapping(value = "/rest/clients",params = {"name"})
    public Сlient getClientByName(@RequestParam String name) {
        return entitiesService.getClientByName(name);
    }

    @GetMapping("/rest/orders")
    public List<ClientOrder> getAllOrders() {
        return entitiesService.getAllOrders();
    }

    @RequestMapping(value = "/rest/orders",params = {"id"})
    public ClientOrder getOrderById(@RequestParam Long id) {
        return entitiesService.getOrderById(id);
    }

    @RequestMapping(value = "/rest/orders",params = {"status"})
    public List<ClientOrder> getOrdersByStatus(@RequestParam Integer status) {
        return entitiesService.getOrdersByStatus(status);
    }

    @GetMapping("/rest/products")
    public List<Product> getAllProducts() {
        return entitiesService.getAllProducts();
    }

    @RequestMapping(value = "/rest/products",params = {"id"})
    public Product getProductById(@RequestParam Long id) {
        return entitiesService.getProductById(id);
    }

    @RequestMapping(value = "/rest/products",params = {"name"})
    public Product getProductsByName(@RequestParam String name) {
        return entitiesService.getProductsByName(name);
    }

    @RequestMapping(value = "/rest/products",params = {"categoryId"})
    public List<Product> getCategoryProducts(@RequestParam Long categoryId) {
        return entitiesService.getCategoryProducts(categoryId);
    }

    @GetMapping("/rest/categories")
    public List<Category> getAllCategories() {
        return entitiesService.getAllCategories();
    }

    @RequestMapping(value = "/rest/listClientOrders",params = {"clientName"})
    public List<ClientOrder> getClientOrdersByName(@RequestParam String name) {
        return entitiesService.getClientOrdersByName(name);
    }

    @RequestMapping(value = "/rest/listClientProducts",params = {"clientId"})
    public List<Product> getClientProducts(@RequestParam Long clientId) {
        return entitiesService.getClientProducts(clientId);
    }

    @GetMapping("/rest/topPopularProducts")
    public List<Product> getTopPopularProducts() {
        return entitiesService.getTopPopularProducts();
    }
}
