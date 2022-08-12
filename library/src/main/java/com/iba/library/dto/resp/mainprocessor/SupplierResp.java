package com.iba.library.dto.resp.mainprocessor;

import com.iba.library.dto.resp.SimpleIDResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierResp extends SimpleIDResp {

    private String name;

    private String address;

    private Double rating;

}
