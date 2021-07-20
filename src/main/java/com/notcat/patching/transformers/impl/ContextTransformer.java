package com.notcat.patching.transformers.impl;

import com.notcat.patching.ClassInjector;
import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ContextTransformer implements ITransformer {

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        ArrayList<TransformedClass> transformedClasses = new ArrayList<>();

        try {

            ClassInjector.inject("com.xk72.charles.gui.transaction.actions.CopyToClipboardAction$LoliScript",
                    classPool, transformedClasses);

            //region Patch Context Menu

            classPool.importPackage("com.xk72.charles.gui.transaction.actions");
            classPool.importPackage("com.xk72.charles.gui.session.trees");
            classPool.importPackage("javax.swing");
            classPool.importPackage("com.xk72.charles.gui.transaction.actions");

            String classPath;
            CtClass contextClass = classPool.get(classPath = "com.xk72.charles.gui.session.popups.TransactionPopupMenu");
            contextClass.getDeclaredMethod("prepare", new CtClass[]{
                    classPool.get("boolean")
            }).setBody("{if (a())\n" +
                    "      return; \n" +
                    "    add((Action)new CopyURLAction((ModelNode)this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.CurlCommand(this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.LoliScript(this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.HeaderKeys(this.transaction));\n" +
                    "    if (this.transaction.getRequestSize() > 0L)\n" +
                    "      add((Action)new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.Request(this.transaction)); \n" +
                    "    com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.Response response = new com.xk72.charles.gui.transaction.actions.CopyToClipboardAction.Response(this.transaction);\n" +
                    "    response.setEnabled((this.transaction.getResponseSize() > 0L));\n" +
                    "    add((Action)response);\n" +
                    "    if (this.transaction.getRequestSize() > 0L)\n" +
                    "      add((Action)new com.xk72.charles.gui.transaction.actions.SaveBodyAction.Request(this.transaction)); \n" +
                    "    com.xk72.charles.gui.transaction.actions.SaveBodyAction.Response response1 = new com.xk72.charles.gui.transaction.actions.SaveBodyAction.Response(this.transaction);\n" +
                    "    response1.setEnabled((this.transaction.getResponseSize() > 0L));\n" +
                    "    add((Action)response1);\n" +
                    "    if (Boolean.TRUE.equals(this.transaction.getWebSocket()))\n" +
                    "      add((Action)new SaveWebSocketMessagesAction(this.transaction)); \n" +
                    "    if (this.findDialog != null)\n" +
                    "      add((Action)new com.xk72.charles.gui.session.actions.FindInNodesAction(this.findDialog, (ModelNode)this.transaction)); \n" +
                    "    add((Action)new ExportAction((ModelNode)this.transaction));\n" +
                    "    addSeparator();\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.TransactionComposeAction(this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.RepeatAction((ModelNode)this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.AdvancedRepeatAction((ModelNode)this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.ValidateAction((ModelNode)this.transaction));\n" +
                    "    add((Action)new com.xk72.charles.gui.transaction.actions.PublishAction((ModelNode)this.transaction));\n" +
                    "    if (this.transaction.getInterruptableChannel() != null)\n" +
                    "      add((Action)new TerminateAction(this.transaction)); \n" +
                    "    addSeparator();\n" +
                    "    com.xk72.charles.gui.session.popups.g g = new com.xk72.charles.gui.session.popups.g(this);\n" +
                    "    add(ViewAsTypeMenu.a(g));\n" +
                    "    add(ViewAsTypeMenu.b(g));\n" +
                    "    addLocationUsingTool((com.xk72.charles.tools.LocationUsingTool)new com.xk72.charles.gui.transaction.viewers.TransactionViewerContentTypeManager());\n" +
                    "    if (this.navigator instanceof com.xk72.charles.gui.session.tables.a || this.navigator instanceof com.xk72.charles.gui.session.trees.h) {\n" +
                    "      addSeparator();\n" +
                    "      add((Action)new com.xk72.charles.gui.transaction.actions.SwitchStructureNavigatorAction((com.xk72.charles.model.ModelNode)this.transaction, this.navigator));\n" +
                    "    } else if (this.navigator instanceof com.xk72.charles.gui.session.trees.p) {\n" +
                    "      addSeparator();\n" +
                    "      add((Action)new com.xk72.charles.gui.transaction.actions.SwitchStructureNavigatorAction((com.xk72.charles.model.ModelNode)this.transaction, this.navigator));\n" +
                    "    } \n" +
                    "    if ($1) {\n" +
                    "      addSeparator();\n" +
                    "      if (addReorder())\n" +
                    "        addSeparator(); \n" +
                    "      addFocus();\n" +
                    "      addIgnore();\n" +
                    "      addSeparator();\n" +
                    "      addClear();\n" +
                    "      addClearOthers();\n" +
                    "      if (this.transaction.getProtocol() != null && com.xk72.proxy.http.HttpUtils.d(this.transaction.getProtocol())) {\n" +
                    "        addSeparator();\n" +
                    "        addSSLProxyingSelector();\n" +
                    "      } \n" +
                    "      addSeparator();\n" +
                    "      addSelectingTools();\n" +
                    "      addSeparator();\n" +
                    "      addUsingTools();\n" +
                    "    } }");

            transformedClasses.add(new TransformedClass(classPath, contextClass.toBytecode()));

            //endregion

            return transformedClasses;

        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }

    }
}
