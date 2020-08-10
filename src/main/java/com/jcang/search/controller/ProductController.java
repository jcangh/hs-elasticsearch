package com.jcang.search.controller;

import com.jcang.search.entity.ProductEntity;
import com.jcang.search.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping(path = "/search/{text}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProductEntity>> search(@PathVariable("text") String text) {
        return ResponseEntity.ok(service.search(text));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody ProductEntity entity){
        service.create(entity);
        return ResponseEntity.ok().build();
    }
}