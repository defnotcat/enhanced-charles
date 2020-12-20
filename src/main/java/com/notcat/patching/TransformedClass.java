package com.notcat.patching;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TransformedClass {

    public String path;
    public InputStream transformedClass;

    public TransformedClass(String path, byte[] transformedClass) {
        this(path, new ByteArrayInputStream(transformedClass));
    }

    public TransformedClass(String path, InputStream transformedClass) {
        this.path = "/" + path.replace(".", "/") + ".class";
        this.transformedClass = transformedClass;
    }

}
