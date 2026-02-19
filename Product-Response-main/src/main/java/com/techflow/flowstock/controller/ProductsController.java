package com.techflow.flowstock.controller;

import com.techflow.flowstock.dto.ProductResponseDTO;
import com.techflow.flowstock.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDTO create(@Valid @RequestBody ProductResponseDTO dto) {
        return productService.create(dto);
    }

    @PutMapping("/alterar")
    public ProductResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ProductResponseDTO dto
    ) {
        return productService.uptade(id, dto);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/listar")
    public List<ProductResponseDTO> findAll() {
        return productService.findAll();
    }

    @DeleteMapping("/remover")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
