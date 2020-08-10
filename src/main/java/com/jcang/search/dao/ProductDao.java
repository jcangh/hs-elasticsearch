package com.jcang.search.dao;

import com.jcang.search.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<ProductEntity,String> {
}
