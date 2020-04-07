package com.vsii.wbdlaptopmaven.repository;

import com.vsii.wbdlaptopmaven.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
