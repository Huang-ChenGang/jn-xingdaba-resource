package com.jn.xingdaba.resource.infrastructure.exception;

import com.jn.core.exception.JNError;
import com.jn.core.exception.JNException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ResourceException extends JNException {

    public ResourceException(@NotNull JNError error) {
        super(error);
    }

    public ResourceException(@NotNull JNError error, Throwable cause) {
        super(error, cause);
    }

    public ResourceException(@NotNull JNError error, @NotBlank String message) {
        super(error, message);
    }
}
