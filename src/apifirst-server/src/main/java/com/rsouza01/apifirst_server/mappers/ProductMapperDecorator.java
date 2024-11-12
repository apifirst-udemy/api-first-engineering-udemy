package com.rsouza01.apifirst_server.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.rsouza01.apifirst.model.ProductCreateDto;
import com.rsouza01.apifirst.model.ProductDto;
import com.rsouza01.apifirst.model.ProductUpdateDto;
import com.rsouza01.apifirst_server.domain.Category;
import com.rsouza01.apifirst_server.domain.Image;
import com.rsouza01.apifirst_server.domain.Product;
import com.rsouza01.apifirst_server.repositories.CategoryRepository;
import com.rsouza01.apifirst_server.repositories.ImageRepository;

public abstract class ProductMapperDecorator implements ProductMapper {

    @Autowired
    @Qualifier("delegate")
    private ProductMapper productMapperDelegate;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Product productCreateDtoToProduct(ProductCreateDto productCreateDto) {
        if (productCreateDto != null) {
            Product product = productMapperDelegate.productCreateDtoToProduct(productCreateDto);

            if (productCreateDto.getCategories() != null) {
                List<Category> categories = new ArrayList<>();

                productCreateDto.getCategories().forEach(categoryCode -> {
                    categoryRepository.findByCategoryCode(categoryCode).ifPresent(categories::add);
                });

                product.setCategories(categories);

                return product;
            }
        }

        return null;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        return productMapperDelegate.productToProductDto(product);
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        return productMapperDelegate.productDtoToProduct(productDto);
    }

    @Override
    public ProductUpdateDto productToProductUpdateDto(Product product) {
        if (product != null) {

            if (product.getCategories() != null) {
                List<String> categoryCodes = new ArrayList<>();

                product.getCategories().forEach(categoryCode -> {
                    categoryCodes.add(categoryCode.getCategoryCode());
                });

                ProductUpdateDto productUpdateDto = productMapperDelegate.productToProductUpdateDto(product);
                productUpdateDto.setCategories(categoryCodes);

                return productUpdateDto;
            }
        }
        return null;
    }

    @Override
    public Product productUpdateDtoToProduct(ProductUpdateDto productUpdateDto) {
        if (productUpdateDto != null) {
            Product product = productMapperDelegate.productUpdateDtoToProduct(productUpdateDto);

            if (productUpdateDto.getCategories() != null) {
                List<Category> categories = categoryCodesToCategories(productUpdateDto.getCategories());

                product.setCategories(categories);
            }

            if (productUpdateDto.getImages() != null) {
                product.setImages(new ArrayList<>());

                productUpdateDto.getImages().forEach(imageDto -> {
                    if (imageDto.getId() != null) {
                        imageRepository.findById(imageDto.getId()).ifPresent(image -> {
                            Image existingImage = imageRepository.findById(imageDto.getId()).get();
                            imageMapper.updateImage(imageDto, existingImage);
                            product.getImages().add(existingImage);
                        });
                    }
                });
            }

            return product;
        }

        return null;
    }

    @Override
    public void updateProduct(ProductUpdateDto productUpdateDto, @MappingTarget Product target) {
        productMapperDelegate.updateProduct(productUpdateDto, target);

        if (productUpdateDto.getImages() != null) {
            productUpdateDto.getImages().forEach(imageDto -> {
                target.setImages(new ArrayList<>());

                if (imageDto.getId() != null) {
                    imageRepository.findById(imageDto.getId()).ifPresent(image -> {
                        Image existingImage = imageRepository.findById(imageDto.getId()).get();
                        imageMapper.updateImage(imageDto, existingImage);
                        target.getImages().add(existingImage);
                    });
                }
            });
        } else {
            target.setImages(new ArrayList<>());
        }

        if (productUpdateDto.getCategories() != null) {
            List<Category> categories = categoryCodesToCategories(productUpdateDto.getCategories());
            target.setCategories(categories);
        }
    }

    private List<Category> categoryCodesToCategories(List<String> categoryCodes) {
        List<Category> categories = new ArrayList<>();

        categoryCodes.forEach(categoryCode -> {
            categoryRepository.findByCategoryCode(categoryCode).ifPresent(categories::add);
        });

        return categories;
    }
}