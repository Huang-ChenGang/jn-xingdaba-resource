package com.jn.xingdaba.resource.infrastructure.exception;

import com.jn.core.exception.JNError;

import javax.validation.constraints.NotNull;

import static com.jn.xingdaba.resource.infrastructure.exception.ResourceSystemError.BUS_PRICE_NOT_FOUND;

public class BusPriceNotFoundException extends ResourceException {
    public BusPriceNotFoundException() {
        this(BUS_PRICE_NOT_FOUND);
    }

    public BusPriceNotFoundException(@NotNull JNError error) {
        super(error);
    }
}
