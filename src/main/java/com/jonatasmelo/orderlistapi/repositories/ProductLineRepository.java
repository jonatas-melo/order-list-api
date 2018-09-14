package com.jonatasmelo.orderlistapi.repositories;

import com.jonatasmelo.orderlistapi.entities.ProductLine;
import org.springframework.data.repository.CrudRepository;

public interface ProductLineRepository extends CrudRepository<ProductLine, String> {
}
