package com.notcat.patching.transformers.impl;

import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.Collections;

public class DemoTransformer implements ITransformer {

    //region Members Names
    private final String RUNNABLE_CLASS_PATH = "com.xk72.charles.XaRp";
    //endregion

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        try {

            CtClass runnableClass = classPool.get(RUNNABLE_CLASS_PATH);
            runnableClass.getDeclaredMethod("run").setBody("{}");

            return Collections.singletonList(
                    new TransformedClass(RUNNABLE_CLASS_PATH, runnableClass.toBytecode())
            );

        } catch(Exception exp) {
            exp.printStackTrace();
            return null;
        }

    }
}
