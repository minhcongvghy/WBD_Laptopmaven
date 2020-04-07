package com.vsii.wbdlaptopmaven.service;

import com.vsii.wbdlaptopmaven.model.Product;

import java.util.Optional;

public interface IProductService {

    Optional<Product> findById(Long id);

    Iterable<Product> findAll();

    Product save(Product product);

    void delete(Long id);
}
