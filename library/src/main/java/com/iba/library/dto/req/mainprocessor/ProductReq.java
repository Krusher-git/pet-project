package com.iba.library.dto.req.mainprocessor;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductReq {

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String categoryName;


}
