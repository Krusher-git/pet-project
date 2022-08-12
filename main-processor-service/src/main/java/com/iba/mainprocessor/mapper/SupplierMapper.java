package com.iba.mainprocessor.mapper;

import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import com.iba.mainprocessor.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierResp toResponse(final Supplier supplier);

}
