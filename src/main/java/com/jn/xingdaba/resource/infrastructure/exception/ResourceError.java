package com.jn.xingdaba.resource.infrastructure.exception;

import com.jn.core.exception.JNError;

public interface ResourceError extends JNError {
    default int getServiceCode() {
        return 3;
    }
}
