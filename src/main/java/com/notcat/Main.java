package com.notcat;

import com.notcat.patching.Patcher;
import com.notcat.patching.transformers.impl.ContextTransformer;
import com.notcat.patching.transformers.impl.DemoTransformer;
import com.notcat.patching.transformers.impl.HeaderOrderTransformer;
import com.notcat.patching.transformers.impl.JA3Transformer;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Patcher patcher = new Patcher("D:\\CharlesJA3\\charles461.jar");
        if (patcher.initialize())
            if (patcher.applyTransformers(
                    Paths.get("D:\\CharlesJA3\\output.jar"),
                    new JA3Transformer(),
                    new ContextTransformer(),
                    new DemoTransformer(),
                    new HeaderOrderTransformer()
            ))
                System.out.println("All transformers applied successfully");

    }

}
