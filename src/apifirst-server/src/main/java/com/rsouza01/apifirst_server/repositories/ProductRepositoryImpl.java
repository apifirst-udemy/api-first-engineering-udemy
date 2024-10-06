package com.rsouza01.apifirst_server.repositories;

import java.util.Optional;
import java.util.UUID;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Locale.Category;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.rsouza01.apifirst.model.CategoryDto;
import com.rsouza01.apifirst.model.ImageDto;
import com.rsouza01.apifirst.model.ProductDto;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<UUID, ProductDto> entityMap = new HashMap<>();

    @Override
    public <S extends ProductDto> S save(S entity) {

        UUID id = UUID.randomUUID();

        ProductDto.ProductDtoBuilder productBuilder = ProductDto.builder();

        productBuilder.id(id);

        if(entity.getImages() != null) {
            productBuilder.images(entity.getImages()
                    .stream()
                    .map(image -> ImageDto.builder()
                        .id(UUID.randomUUID())
                        .url(image.getUrl())
                        .altText(image.getAltText())
                        .dateCreated(image.getDateCreated())
                        .dateUpdated(image.getDateUpdated())
                        .build())
                    .collect(Collectors.toList()));
        }

        if(entity.getCategories() != null && !entity.getCategories().isEmpty()) {
            productBuilder.categories(entity.getCategories()
                    .stream()
                    .map(category -> CategoryDto.builder()
                        .id(category.getId())
                        .category(category.getCategory())
                        .description(category.getDescription())
                        .dateCreated(category.getDateCreated())
                        .dateUpdated(category.getDateUpdated())
                        .build())
                    .collect(Collectors.toList()));
        }

        ProductDto product = productBuilder
            .description(entity.getDescription())
            .price(entity.getPrice())
            .cost(entity.getCost())
            .dimensions(entity.getDimensions())
            .dateCreated(OffsetDateTime.now())
            .dateUpdated(OffsetDateTime.now())
            .build();

        entityMap.put(id, product);

        return (S) product;
    }

    @Override
    public <S extends ProductDto> Iterable<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> findById(UUID uuid) {
        return Optional.of(entityMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return entityMap.get(uuid) != null;
    }

    @Override
    public Iterable<ProductDto> findAll() {
        return entityMap.values();
    }

    @Override
    public Iterable<ProductDto> findAllById(Iterable<UUID> uuids) {
        return StreamSupport.stream(uuids.spliterator(), false)
                .map(this::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return entityMap.size();
    }

    @Override
    public void deleteById(UUID uuid) {
        entityMap.remove(uuid);
    }

    @Override
    public void delete(ProductDto entity) {
        entityMap.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends ProductDto> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        entityMap.clear();
    }

}
