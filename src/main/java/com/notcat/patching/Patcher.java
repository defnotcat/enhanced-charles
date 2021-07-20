package com.notcat.patching;

import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.MethodGraph;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Patcher {

    public Path inputPath;
    public ClassPool classPool;
    public Exception lastException;

    public Patcher(String inputPath) {
        this(Paths.get(inputPath));
    }

    public Patcher(Path inputPath) {
        this.inputPath = inputPath;
        this.classPool = ClassPool.getDefault();
    }

    public boolean initialize() {
        try {
            classPool.insertClassPath(inputPath.toString());
            return true;
        } catch (Exception exp) {
            lastException = exp;
        }
        return false;
    }

    public boolean applyTransformers(Path outputPath, ITransformer... transformers) {

        try {

            if (Files.exists(outputPath))
                Files.delete(outputPath);

            Files.copy(inputPath, outputPath);

            for (ITransformer transformer : transformers) {

                Iterable<TransformedClass> transformedClasses;
                if ((transformedClasses = transformer.transform(classPool)) == null) {
                    System.out.printf("Transformer: %s failed\n",
                            transformer.getClass().getSimpleName());
                    continue;
                }

                JarWriter jarWriter = new JarWriter(outputPath);

                transformedClasses.forEach(transformedClass -> {
                    if (!jarWriter.write(transformedClass.path, transformedClass.transformedClass))
                        System.out.printf("Transformed class '%s' couldn't be written to file\n", transformedClass.path);
                });

                jarWriter.close();

            }

            return true;

        } catch (Exception exp) {
            exp.printStackTrace();
            lastException = exp;
        }

        return false;

    }

}
