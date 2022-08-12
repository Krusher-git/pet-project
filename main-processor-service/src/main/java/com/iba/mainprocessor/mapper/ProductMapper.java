package com.iba.mainprocessor.mapper;

import com.iba.library.dto.req.mainprocessor.ProductReq;
import com.iba.library.dto.resp.mainprocessor.ProductCostAndSupplierResp;
import com.iba.library.dto.resp.mainprocessor.ProductResp;
import com.iba.mainprocessor.entity.Category;
import com.iba.mainprocessor.entity.Product;
import com.iba.mainprocessor.entity.ProductCostAndSupplier;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

//By adding componentModel as spring this interface will be registered in spring context
@Mapper(componentModel = "spring",
        uses = {ProductCostAndSupplierMapper.class})
public interface ProductMapper {
    @Mapping(source = "categoryName",
            target = "category",
            qualifiedByName = "categoryToEnumMap")
    @Mapping(target = "id", ignore = true)
    Product toEntity(final ProductReq productReq);

    @Named("categoryToEnumMap")
    default Category getCategoryByOrdinal(final String categoryName) {
        final String convertedCategoryName = categoryName.toUpperCase();

        Category category = Category.ANY;

        //Preventing illegalArgExc
        try {
            category = Category.valueOf(convertedCategoryName);
        } catch (IllegalArgumentException e) {
            //Add logger mb
        }
        return category;
    }

    @Mapping(source = "category", target = "categoryName", qualifiedByName = "categoryToStringMap")
    ProductResp toResponse(final Product product);

    @Named("categoryToStringMap")
    default String getNameFromCategory(final Category category) {
        return category.toString();
    }

}
