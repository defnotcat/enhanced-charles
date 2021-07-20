package com.notcat.patching.transformers.impl;

import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.ArrayList;
import java.util.Collections;

public class DemoTransformer implements ITransformer {

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        ArrayList<TransformedClass> transformedClasses = new ArrayList<>();

        try {

            // Close runnable
            CtClass runnableClass = classPool.get("com.xk72.charles.e");
            runnableClass.getDeclaredMethod("run").setBody("{}");
            transformedClasses.add(TransformedClass.from(runnableClass));

            // Startup splash window
            runnableClass = classPool.get("com.xk72.charles.gui.Y");
            runnableClass.getDeclaredMethod("run").setBody("{}");
            transformedClasses.add(TransformedClass.from(runnableClass));

            return transformedClasses;

        } catch(Exception exp) {
            exp.printStackTrace();
            return null;
        }

    }
}
