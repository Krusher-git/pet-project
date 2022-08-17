package com.iba.mainprocessor.service;

import com.iba.library.dto.resp.mainprocessor.SupplierResp;
import com.iba.mainprocessor.entity.Supplier;
import com.iba.mainprocessor.mapper.SupplierMapper;
import com.iba.mainprocessor.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final SupplierMapper supplierMapper;

    @Override
    public SupplierResp getById(Long id) {
        final Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> {

                    log.error("SupplierService.SupplierRepository: Error occurred when getting supplier with id " + id);

                    return new RuntimeException("replace with smth useful");
                });

        return supplierMapper.toResponse(supplier);
    }

}
