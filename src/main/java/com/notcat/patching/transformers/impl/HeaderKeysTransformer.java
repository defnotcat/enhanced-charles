package com.notcat.patching.transformers.impl;

import com.notcat.patching.ClassInjector;
import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.ArrayList;

public class HeaderKeysTransformer implements ITransformer {

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        try {

            ArrayList<TransformedClass> transformedClasses = new ArrayList<>();

            ClassInjector.inject("com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$HeaderKeys",
                    classPool, transformedClasses);

            return transformedClasses;

        } catch(Exception exp) {
            exp.printStackTrace();
            return null;
        }

    }
}
