package com.iba.mainprocessor.service;

import com.iba.library.dto.req.mainprocessor.CartForOrderReq;
import com.iba.library.dto.req.mainprocessor.CartUpdateReq;
import com.iba.library.dto.resp.mainprocessor.CartResp;

public interface CartService {
    CartResp createCartWithUserId(final Long userId);

    CartResp getCartByUserId(final Long userId);

    CartResp updateCart(final CartUpdateReq cartUpdateReq);

    CartResp sendForProcessing(final CartForOrderReq cartForOrderReq);

}
