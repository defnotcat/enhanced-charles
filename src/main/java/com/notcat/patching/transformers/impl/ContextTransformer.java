package com.notcat.patching.transformers.impl;

import com.notcat.patching.ClassInjector;
import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.ArrayList;

public class ContextTransformer implements ITransformer {

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        ArrayList<TransformedClass> transformedClasses = new ArrayList<>();

        try {

            ClassInjector.inject(
                    "com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$LoliScript",
                    classPool,
                    transformedClasses
            );

            //region Patch Context Menu

            classPool.importPackage("com.xk72.charles.gui.transaction.actions");
            classPool.importPackage("com.xk72.charles.gui.session.trees");

            String classPath;
            CtClass contextClass = classPool.get(classPath = "com.xk72.charles.gui.session.popups.TransactionPopupMenu");
            contextClass.getDeclaredMethod("prepare", new CtClass[]{
                    classPool.get("boolean")
            }).setBody("{if (!this.XdKP()) {\n" +
                    "         this.add(new CopyURLAction(this.transaction));\n" +
                    "         this.add(new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.CurlCommand(this.transaction));\n" +
                    "         this.add(new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.LoliScript(this.transaction));\n" +
                    "         if (this.transaction.getRequestSize() > 0L) {\n" +
                    "            this.add(new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.Request(this.transaction));\n" +
                    "         }\n" +
                    "\n" +
                    "         com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.Response var2 = new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.Response(this.transaction);\n" +
                    "         var2.setEnabled(this.transaction.getResponseSize() > 0L);\n" +
                    "         this.add(var2);\n" +
                    "         if (this.transaction.getRequestSize() > 0L) {\n" +
                    "            this.add(new com.xk72.charles.gui.transaction.actions.SaveBodyAction.Request(this.transaction));\n" +
                    "         }\n" +
                    "\n" +
                    "         com.xk72.charles.gui.transaction.actions.SaveBodyAction.Response var3 = new com.xk72.charles.gui.transaction.actions.SaveBodyAction.Response(this.transaction);\n" +
                    "         var3.setEnabled(this.transaction.getResponseSize() > 0L);\n" +
                    "         this.add(var3);\n" +
                    "         if (Boolean.TRUE.equals(this.transaction.getWebSocket())) {\n" +
                    "            this.add(new SaveWebSocketMessagesAction(this.transaction));\n" +
                    "         }\n" +
                    "\n" +
                    "         if (this.findDialog != null) {\n" +
                    "            this.add(new com.xk72.charles.gui.session.actions.FindInNodesAction(this.findDialog, this.transaction));\n" +
                    "         }\n" +
                    "\n" +
                    "         this.add(new ExportAction(this.transaction));\n" +
                    "         this.addSeparator();\n" +
                    "         this.add(new TransactionComposeAction(this.transaction));\n" +
                    "         this.add(new RepeatAction(this.transaction));\n" +
                    "         this.add(new AdvancedRepeatAction(this.transaction));\n" +
                    "         this.add(new ValidateAction(this.transaction));\n" +
                    "         this.add(new PublishAction(this.transaction));\n" +
                    "         if (this.transaction.getInterruptableChannel() != null) {\n" +
                    "            this.add(new TerminateAction(this.transaction));\n" +
                    "         }\n" +
                    "\n" +
                    "         this.addSeparator();\n" +
                    "         com.xk72.charles.gui.session.popups.mukF var4 = new com.xk72.charles.gui.session.popups.mukF(this);\n" +
                    "         this.add(ViewAsTypeMenu.XdKP(var4));\n" +
                    "         this.add(ViewAsTypeMenu.eCYm(var4));\n" +
                    "         this.addLocationUsingTool(new com.xk72.charles.gui.transaction.viewers.TransactionViewerContentTypeManager());\n" +
                    "         if (!(this.navigator instanceof com.xk72.charles.gui.session.tables.elVd) && !(this.navigator instanceof bAUT)) {\n" +
                    "            if (this.navigator instanceof MfoV) {\n" +
                    "               this.addSeparator();\n" +
                    "               this.add(new SwitchSequenceNavigatorAction(this.transaction, this.navigator));\n" +
                    "            }\n" +
                    "         } else {\n" +
                    "            this.addSeparator();\n" +
                    "            this.add(new SwitchStructureNavigatorAction(this.transaction, this.navigator));\n" +
                    "         }\n" +
                    "\n" +
                    "         if ($1) {\n" +
                    "            this.addSeparator();\n" +
                    "            if (this.addReorder()) {\n" +
                    "               this.addSeparator();\n" +
                    "            }\n" +
                    "\n" +
                    "            this.addFocus();\n" +
                    "            this.addIgnore();\n" +
                    "            this.addSeparator();\n" +
                    "            this.addClear();\n" +
                    "            this.addClearOthers();\n" +
                    "            if (this.transaction.getProtocol() != null && com.xk72.proxy.http.HttpUtils.AhDU(this.transaction.getProtocol())) {\n" +
                    "               this.addSeparator();\n" +
                    "               this.addSSLProxyingSelector();\n" +
                    "            }\n" +
                    "\n" +
                    "            this.addSeparator();\n" +
                    "            this.addSelectingTools();\n" +
                    "            this.addSeparator();\n" +
                    "            this.addUsingTools();\n" +
                    "         }\n" +
                    "\n" +
                    "      }\n}");

            transformedClasses.add(new TransformedClass(classPath, contextClass.toBytecode()));

            //endregion

            return transformedClasses;

        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }

    }
}
