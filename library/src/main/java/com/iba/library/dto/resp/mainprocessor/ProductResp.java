package com.iba.library.dto.resp.mainprocessor;

import com.iba.library.dto.resp.SimpleIDResp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResp extends SimpleIDResp {

    private String name;

    private String description;

    private String categoryName;

}
