package com.notcat.patching.transformers;

import com.notcat.patching.TransformedClass;
import javassist.ClassPool;

public interface ITransformer {

    Iterable<TransformedClass> transform(ClassPool classPool);

}
