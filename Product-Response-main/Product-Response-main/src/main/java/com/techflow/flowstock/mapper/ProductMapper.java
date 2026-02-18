package com.techflow.flowstock.mapper;

import com.techflow.flowstock.domain.Product;
import com.techflow.flowstock.dto.ProductResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {
    public static Product toEntity(ProductResponseDTO dto) {
        if (dto == null) return null;

        Product p = new Product();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());

        // createdAt/updatedAt serão preenchidos pelo @PrePersist na entidade
        return p;
    }

    // Converte entidade para response DTO
    public static ProductResponseDTO toDto(Product product) {
        if (product == null) return null;

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription()
        );
    }

    // Atualiza a entidade existente a partir do request DTO (para operações update)
    // Não altera id, createdAt nem updatedAt (updatedAt será setado pelo @PreUpdate)
    public static void updateEntityFromDto(ProductResponseDTO dto, Product product) {
        if (dto == null || product == null) return;

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        // não tocar createdAt; updatedAt será atualizado pelo JPA (@PreUpdate)
    }

}
