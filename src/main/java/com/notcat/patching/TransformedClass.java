package com.notcat.patching;

import javassist.CannotCompileException;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

    public static TransformedClass from(CtClass ctClass) throws IOException, CannotCompileException {
        return new TransformedClass(ctClass.getName(), ctClass.toBytecode());
    }

}
