package com.notcat.patching.transformers.impl;

import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.Collections;

public class HeaderOrderTransformer implements ITransformer {

    //region Members Names
    private final String CLASS_PATH = "com.xk72.proxy.http.MfoV";
    //endregion

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        try {

            classPool.importPackage("java.util");
            classPool.importPackage("java.io");
            classPool.importPackage("com.xk72.proxy");

            CtClass ctClass = classPool.get(CLASS_PATH);
            ctClass.getDeclaredMethod("XdKP", new CtClass[]{
                    classPool.get("com.xk72.proxy.Fields"),
                    classPool.get("boolean")
            }).insertBefore("{boolean var3 = $1.getField(\"Transfer-Encoding\") != null && $1.getField(\"Transfer-Encoding\").equalsIgnoreCase(\"chunked\");\n" +
                    "      byte[] var4 = this.wuFV.getReceivingBuffer();\n" +
                    "      if (var4 != null && var4.length != this.wuFV.getReceivingBufferLength()) {\n" +
                    "         byte[] var5 = new byte[this.wuFV.getReceivingBufferLength()];\n" +
                    "         System.arraycopy(var4, 0, var5, 0, this.wuFV.getReceivingBufferLength());\n" +
                    "         var4 = var5;\n" +
                    "      }\n" +
                    "\n" +
                    // Patch
                    "      Fields tempFields = new Fields();" +
                    "      if (!var3 && var4 != null) {\n" +
                    "         for(int headerIndex = 0; headerIndex < $1.getFieldCount(); headerIndex++) {" +
                    "               String key = $1.getFieldName(headerIndex);" +
                    "               String value = $1.getFieldValue(headerIndex);" +
                    "               if(key.equalsIgnoreCase(\"Content-Length\")) value = String.valueOf(var4.length);" +
                    "               tempFields.setField(key, value);" +
                    "         }" +
                    "           $1 = tempFields;" +
                    "      }\n" +
                    "\n" +
                    "      if (!$2) {\n" +
                    "         this.wuFV.setRequestBeginTime(new Date());\n" +
                    "      }\n" +
                    "\n" +
                    "      boolean var9 = var4 != null;\n" +
                    "      this.eCYm($1, $2, var9);\n" +
                    "      Object var6 = null;\n" +
                    "      if (var9) {\n" +
                    "         com.xk72.proxy.io.VOPs var7 = new com.xk72.proxy.io.VOPs(this.sLDE.Hylk());\n" +
                    "         if (var3) {\n" +
                    "            var6 = new com.xk72.proxy.io.OEqP(new com.xk72.proxy.io.CHDR(var7));\n" +
                    "         } else {\n" +
                    "            var6 = new com.xk72.proxy.io.CHDR(var7);\n" +
                    "         }\n" +
                    "\n" +
                    "         ((OutputStream)var6).write(var4, 0, var4.length);\n" +
                    "         if (!$2) {\n" +
                    "            this.wuFV.setRequestSize((long)((int)var7.XdKP()));\n" +
                    "         }\n" +
                    "      } else if (!$2) {\n" +
                    "         this.wuFV.setRequestSize(0L);\n" +
                    "      }\n" +
                    "\n" +
                    "      this.sLDE.Hylk().QNPA();\n" +
                    "      if (var6 != null) {\n" +
                    "         ((OutputStream)var6).close();\n" +
                    "      }\n" +
                    "\n" +
                    "      this.sLDE.Hylk().flush();\n" +
                    "      if (!$2) {\n" +
                    "         this.wuFV.setRequestCompleteTime(new Date(System.currentTimeMillis()));\n" +
                    "      } if(true) return;}"); // had to use insertBefore because setBody throws a ClassFormatError when running for some odd reasons

            return Collections.singletonList(
                    new TransformedClass(CLASS_PATH, ctClass.toBytecode())
            );

        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }
    }
}
