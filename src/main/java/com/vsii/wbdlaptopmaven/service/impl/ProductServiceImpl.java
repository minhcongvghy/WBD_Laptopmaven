package com.vsii.wbdlaptopmaven.service.impl;

import com.vsii.wbdlaptopmaven.model.Product;
import com.vsii.wbdlaptopmaven.repository.IProductRepository;
import com.vsii.wbdlaptopmaven.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
