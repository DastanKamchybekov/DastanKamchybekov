package com.telegramBot.telegramBot.Services;

import com.telegramBot.telegramBot.Entity.Category;
import com.telegramBot.telegramBot.Entity.ClientOrder;
import com.telegramBot.telegramBot.Entity.Product;
import com.telegramBot.telegramBot.Entity.Сlient;
import com.telegramBot.telegramBot.Repository.CategoryRepository;
import com.telegramBot.telegramBot.Repository.ClientRepository;
import com.telegramBot.telegramBot.Repository.OrderRepository;
import com.telegramBot.telegramBot.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EntityServiceImpl implements EntitiesService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Сlient> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Сlient getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Сlient getClientByName(String name) {
        Сlient client = new Сlient();
        client.setFullName(name);
        return clientRepository.findOne(Example.of(client)).orElse(null);
    }

    @Override
    public List<ClientOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public ClientOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<ClientOrder> getOrdersByStatus(Integer status) {
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setStatus(status);
        return orderRepository.findAll(Example.of(clientOrder));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product getProductsByName(String name) {
        Product product = new Product();
        product.setDescription(name);
        return productRepository.findOne(Example.of(product)).orElse(null);
    }

    @Override
    public List<Product> getCategoryProducts(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        Product product = new Product();
        product.setCategory(category);
        return productRepository.findAll(Example.of(product));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ClientOrder> getClientOrdersByName(String name) {
        Сlient client = new Сlient();
        client.setFullName(name);
        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setClient(client);
        return orderRepository.findAll(Example.of(clientOrder));
    }

    @Override
    public List<Product> getClientProducts(Long id) {
        return productRepository.getClientProducts(id);
    }

    @Override
    public List<Product> getTopPopularProducts() {
        return productRepository.getTopPopular();
    }
}
