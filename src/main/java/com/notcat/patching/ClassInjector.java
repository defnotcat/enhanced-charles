package com.notcat.patching;

import javassist.ClassPool;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ClassInjector {

    public static void inject(String clasz, ClassPool classPool, ArrayList<TransformedClass> transformedClasses) throws Exception {
        inject(Collections.singleton(clasz), classPool, transformedClasses);
    }

    public static void inject(Iterable<String> classes, ClassPool classPool, ArrayList<TransformedClass> transformedClasses) throws Exception {

        String[] elements;
        for (String classFile : classes)
            transformedClasses.add(new TransformedClass(
                    classFile,
                    new ByteArrayInputStream(classPool.makeClass(
                            ClassInjector.class.getClassLoader().getResourceAsStream("./" + (elements = classFile.split("\\."))[elements.length - 1] + ".class")
                    ).toBytecode())
            ));

    }

}
