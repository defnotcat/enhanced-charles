package com.notcat;

import com.notcat.patching.Patcher;
import com.notcat.patching.transformers.impl.*;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        Patcher patcher = new Patcher("/users/cat/work/charles.jar");
        if (patcher.initialize())
            if (patcher.applyTransformers(
                    Paths.get("/users/cat/work/patched-charles.jar"),
                    new DemoTransformer(),
                    new JA3Transformer(),
                    new HeaderKeysTransformer(),
                    new ContextTransformer()
            ))
                System.out.println("All transformers applied successfully");
            else
                System.out.println("Failed to apply all transformers");

    }

}
