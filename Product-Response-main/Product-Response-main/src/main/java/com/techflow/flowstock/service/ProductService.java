package com.techflow.flowstock.service;

import com.techflow.flowstock.domain.Product;
import com.techflow.flowstock.dto.ProductResponseDTO;
import com.techflow.flowstock.mapper.ProductMapper;
import com.techflow.flowstock.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductResponseDTO create(ProductResponseDTO dto) {

        Product entity = ProductMapper.toEntity(dto);
        Product saved = productRepository.save(entity);

        return ProductMapper.toDto(saved);
    }

    @Transactional
    public ProductResponseDTO uptade(Long id, ProductResponseDTO dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found: "+ id));

        ProductMapper.updateEntityFromDto(dto, product);
        Product updated = productRepository.save(product);

        return ProductMapper.toDto(updated);
    }
    
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found: " + id));

        return ProductMapper.toDto(product);
    }


    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll() {

        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
}
    @Transactional
    public void delete(Long id) {

        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found: " + id);
        }

        productRepository.deleteById(id);
    }
}
