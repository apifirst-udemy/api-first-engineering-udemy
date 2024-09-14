package com.rsouza01.apifirst_server.repositories;

import java.util.Optional;
import java.util.UUID;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Repository;

import com.rsouza01.apifirst.model.Category;
import com.rsouza01.apifirst.model.Image;
import com.rsouza01.apifirst.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final Map<UUID, Product> entityMap = new HashMap<>();

    @Override
    public <S extends Product> S save(S entity) {

        UUID id = UUID.randomUUID();

        Product.ProductBuilder productBuilder = Product.builder();

        productBuilder.id(id);

        if(entity.getImages() != null) {
            productBuilder.images(entity.getImages()
                    .stream()
                    .map(image -> Image.builder()
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
                    .map(category -> Category.builder()
                        .id(category.getId())
                        .category(category.getCategory())
                        .description(category.getDescription())
                        .dateCreated(category.getDateCreated())
                        .dateUpdated(category.getDateUpdated())
                        .build())
                    .collect(Collectors.toList()));
        }

        Product product = productBuilder
            .description(entity.getDescription())
            .price(entity.getPrice())
            .cost(entity.getCost())
            .dimentions(entity.getDimentions())
            .dateCreated(OffsetDateTime.now())
            .dateUpdated(OffsetDateTime.now())
            .build();

        entityMap.put(id, product);

        return (S) product;
    
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(UUID uuid) {
        return Optional.of(entityMap.get(uuid));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return entityMap.get(uuid) != null;
    }

    @Override
    public Iterable<Product> findAll() {
        return entityMap.values();
    }

    @Override
    public Iterable<Product> findAllById(Iterable<UUID> uuids) {
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
    public void delete(Product entity) {
        entityMap.remove(entity.getId());
    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {
        uuids.forEach(this::deleteById);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        entityMap.clear();
    }

}
