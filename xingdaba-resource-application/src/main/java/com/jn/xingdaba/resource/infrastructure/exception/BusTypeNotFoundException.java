package com.jn.xingdaba.resource.infrastructure.exception;

import com.jn.core.exception.JNError;

import javax.validation.constraints.NotNull;

import static com.jn.xingdaba.resource.infrastructure.exception.ResourceSystemError.BUS_TYPE_NOT_FOUND;

public class BusTypeNotFoundException extends ResourceException {
    public BusTypeNotFoundException() {
        this(BUS_TYPE_NOT_FOUND);
    }

    public BusTypeNotFoundException(@NotNull JNError error) {
        super(error);
    }
}
