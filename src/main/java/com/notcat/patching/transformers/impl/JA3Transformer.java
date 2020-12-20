package com.notcat.patching.transformers.impl;

import com.notcat.patching.ClassInjector;
import com.notcat.patching.TransformedClass;
import com.notcat.patching.transformers.ITransformer;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewMethod;

import java.util.ArrayList;
import java.util.Arrays;

public class JA3Transformer implements ITransformer {

    //region Members Names
    public final String OVERVIEW_CLASS_PATH = "com.xk72.charles.gui.transaction.general.ZOpb";
    public final String INIT_METHOD_NAME = "uQqp";
    public final String LOAD_METHOD_NAME = "XdKP";
    //endregion

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        ArrayList<TransformedClass> transformedClasses = new ArrayList<>();

        try {

            ClassInjector.inject(Arrays.asList(
                    "com.notcat.enhancedcharles.JA3Utils",
                    "com.notcat.enhancedcharles.JA3Utils$1",
                    "com.notcat.enhancedcharles.JA3Utils$2"
            ), classPool, transformedClasses);

            //region Patch Overview Tab

            classPool.importPackage("com.xk72.charles.gui.lib.treetable");
            classPool.importPackage("com.xk72.charles.model");

            CtClass overviewClass = classPool.get(OVERVIEW_CLASS_PATH);

            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3Node;", overviewClass));
            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3PlainNode;", overviewClass));
            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3HashNode;", overviewClass));

            //region Patch Init
            overviewClass.getDeclaredMethod(INIT_METHOD_NAME).
                    setBody("{this.eCYm.add(this.PRdh = new DefaultTreeTableNode(\"URL\"));\n" +
                            "      this.eCYm.add(this.Vvaz = new DefaultTreeTableNode(\"Status\"));\n" +
                            "      this.eCYm.add(this.Hylk = new DefaultTreeTableNode(\"Failure\"));\n" +
                            "      this.eCYm.add(this.Idso = new DefaultTreeTableNode(\"Notes\"));\n" +
                            "      this.eCYm.add(this.qvCh = new DefaultTreeTableNode(\"Response Code\"));\n" +
                            "      this.eCYm.add(this.QNPA = new DefaultTreeTableNode(\"Protocol\"));\n" +
                            "      this.eCYm.add(this.vkEM = new DefaultTreeTableNode(\"TLS\"));\n" +
                            "      this.vkEM.add(this.ja3Node = new DefaultTreeTableNode(\"JA3\"));\n" +
                            "      this.ja3Node.add(this.ja3PlainNode = new DefaultTreeTableNode(\"Plain\"));\n" +
                            "      this.ja3Node.add(this.ja3HashNode = new DefaultTreeTableNode(\"Hash\"));\n" +
                            "      this.vkEM.add(this.rsVk = new DefaultTreeTableNode(\"Protocol\"));\n" +
                            "      this.rsVk.add(this.CFPh = new DefaultTreeTableNode(\"Client Supported\"));\n" +
                            "      this.rsVk.add(this.emFI = new DefaultTreeTableNode(\"Charles to Client\"));\n" +
                            "      this.rsVk.add(this.qLOY = new DefaultTreeTableNode(\"Server Chosen\"));\n" +
                            "      this.vkEM.add(this.smyD = new DefaultTreeTableNode(\"Alert Code\"));\n" +
                            "      this.vkEM.add(this.kbzH = new DefaultTreeTableNode(\"Session Resumed\"));\n" +
                            "      this.kbzH.add(this.ERKX = new DefaultTreeTableNode(\"Client Requested\"));\n" +
                            "      this.kbzH.add(this.CsNq = new DefaultTreeTableNode(\"Client Session ID\"));\n" +
                            "      this.kbzH.add(this.ukMN = new DefaultTreeTableNode(\"Charles Requested\"));\n" +
                            "      this.kbzH.add(this.gMxR = new DefaultTreeTableNode(\"Server Session ID\"));\n" +
                            "      this.vkEM.add(this.FeXO = new DefaultTreeTableNode(\"Cipher Suite\"));\n" +
                            "      this.FeXO.add(this.XSyo = new DefaultTreeTableNode(\"Client Supported\"));\n" +
                            "      this.FeXO.add(this.UQQK = new DefaultTreeTableNode(\"Charles to Client\"));\n" +
                            "      this.FeXO.add(this.hwVj = new DefaultTreeTableNode(\"Server Chosen\"));\n" +
                            "      this.vkEM.add(this.batT = new DefaultTreeTableNode(\"ALPN\"));\n" +
                            "      this.batT.add(this.wNwP = new DefaultTreeTableNode(\"Client Supported\"));\n" +
                            "      this.batT.add(this.sbEg = new DefaultTreeTableNode(\"Charles Supported\"));\n" +
                            "      this.batT.add(this.ANvn = new DefaultTreeTableNode(\"Server Chosen\"));\n" +
                            "      this.vkEM.add(this.eRmO = new DefaultTreeTableNode(\"Client Certificates\"));\n" +
                            "      this.vkEM.add(this.yBqx = new DefaultTreeTableNode(\"Server Certificates\"));\n" +
                            "      this.vkEM.add(this.ossy = new DefaultTreeTableNode(\"Extensions\"));\n" +
                            "      this.ossy.add(this.ZoGD = new DefaultTreeTableNode(\"Client\"));\n" +
                            "      this.ossy.add(this.kkpB = new DefaultTreeTableNode(\"Charles to Client\"));\n" +
                            "      this.ossy.add(this.GgWt = new DefaultTreeTableNode(\"Charles to Server\"));\n" +
                            "      this.ossy.add(this.jJFj = new DefaultTreeTableNode(\"Server\"));\n" +
                            "      this.eCYm.add(this.NWha = new DefaultTreeTableNode(\"Method\"));\n" +
                            "      this.eCYm.add(this.HeCN = new DefaultTreeTableNode(\"Kept Alive\"));\n" +
                            "      this.eCYm.add(this.WAEF = new DefaultTreeTableNode(\"Content-Type\"));\n" +
                            "      this.eCYm.add(this.jHme = new DefaultTreeTableNode(\"Client Address\"));\n" +
                            "      this.eCYm.add(this.EzdH = new DefaultTreeTableNode(\"Remote Address\"));\n" +
                            "      this.eCYm.add(this.antZ = new DefaultTreeTableNode(\"Tags\"));\n" +
                            "      this.eCYm.add(this.gKBV = new DefaultTreeTableNode(\"Connection\"));\n" +
                            "      this.byhG = new DefaultTreeTableNode(\"WebSockets\");\n" +
                            "      this.byhG.add(this.eNNb = new DefaultTreeTableNode(\"Origin\"));\n" +
                            "      this.byhG.add(this.eeMO = new DefaultTreeTableNode(\"Version\"));\n" +
                            "      this.byhG.add(this.TFBx = new DefaultTreeTableNode(\"Protocol\"));\n" +
                            "      this.byhG.add(this.sUrK = new DefaultTreeTableNode(\"Extensions\"));\n" +
                            "      this.byhG.add(this.MAiM = new DefaultTreeTableNode(\"Messages Sent\"));\n" +
                            "      this.byhG.add(this.oabZ = new DefaultTreeTableNode(\"Messages Received\"));\n" +
                            "      this.byhG.add(this.ssSV = new DefaultTreeTableNode(\"Control Frames Sent\"));\n" +
                            "      this.byhG.add(this.TJBT = new DefaultTreeTableNode(\"Control Frames Received\"));\n" +
                            "      this.eCYm.add(this.byhG);\n" +
                            "      DefaultTreeTableNode var1 = new DefaultTreeTableNode(\"Timing\");\n" +
                            "      var1.add(this.jskY = new DefaultTreeTableNode(\"Request Start Time\"));\n" +
                            "      var1.add(this.YKXz = new DefaultTreeTableNode(\"Request End Time\"));\n" +
                            "      var1.add(this.WWRi = new DefaultTreeTableNode(\"Response Start Time\"));\n" +
                            "      var1.add(this.ftUP = new DefaultTreeTableNode(\"Response End Time\"));\n" +
                            "      var1.add(this.aTLp = new DefaultTreeTableNode(\"Duration\"));\n" +
                            "      var1.add(this.gQVQ = new DefaultTreeTableNode(\"DNS\"));\n" +
                            "      var1.add(this.MYsA = new DefaultTreeTableNode(\"Connect\"));\n" +
                            "      var1.add(this.BDlj = new DefaultTreeTableNode(\"TLS Handshake\"));\n" +
                            "      var1.add(this.scks = new DefaultTreeTableNode(\"Request\"));\n" +
                            "      var1.add(this.APNY = new DefaultTreeTableNode(\"Response\"));\n" +
                            "      var1.add(this.CjEc = new DefaultTreeTableNode(\"Latency\"));\n" +
                            "      var1.add(this.bSau = new DefaultTreeTableNode(\"Speed\"));\n" +
                            "      var1.add(this.kbAY = new DefaultTreeTableNode(\"Request Speed\"));\n" +
                            "      var1.add(this.GRrV = new DefaultTreeTableNode(\"Response Speed\"));\n" +
                            "      this.eCYm.add(var1);\n" +
                            "      DefaultTreeTableNode var2 = new DefaultTreeTableNode(\"Size\");\n" +
                            "      var2.add(this.WkwC = new DefaultTreeTableNode(\"Request\"));\n" +
                            "      this.WkwC.add(this.sLDE = new DefaultTreeTableNode(\"TLS Handshake\"));\n" +
                            "      this.WkwC.add(this.YCFq = new DefaultTreeTableNode(\"Header\"));\n" +
                            "      this.WkwC.add(this.FPsg = new DefaultTreeTableNode(\"Query String\"));\n" +
                            "      this.WkwC.add(this.QiNQ = new DefaultTreeTableNode(\"Cookies\"));\n" +
                            "      this.WkwC.add(this.XhMm = new DefaultTreeTableNode(\"Body\"));\n" +
                            "      this.WkwC.add(this.dztt = new DefaultTreeTableNode(\"Uncompressed Body\"));\n" +
                            "      this.WkwC.add(this.LwEB = new DefaultTreeTableNode(\"Compression\"));\n" +
                            "      var2.add(this.wuFV = new DefaultTreeTableNode(\"Response\"));\n" +
                            "      this.wuFV.add(this.uvpO = new DefaultTreeTableNode(\"TLS Handshake\"));\n" +
                            "      this.wuFV.add(this.bKKu = new DefaultTreeTableNode(\"Header\"));\n" +
                            "      this.wuFV.add(this.rziN = new DefaultTreeTableNode(\"Cookies\"));\n" +
                            "      this.wuFV.add(this.DHBI = new DefaultTreeTableNode(\"Body\"));\n" +
                            "      this.wuFV.add(this.IyiC = new DefaultTreeTableNode(\"Uncompressed Body\"));\n" +
                            "      this.wuFV.add(this.BRLL = new DefaultTreeTableNode(\"Compression\"));\n" +
                            "      var2.add(this.aDeW = new DefaultTreeTableNode(\"Total\"));\n" +
                            "      this.eCYm.add(var2);}");
            //endregion

            overviewClass.getDeclaredMethod(LOAD_METHOD_NAME, new CtClass[]{
                    classPool.get("com.xk72.charles.model.Transaction")
            }).setName(LOAD_METHOD_NAME + "_");

            overviewClass.addMethod(CtNewMethod.make(
                    "private void " + LOAD_METHOD_NAME + "(Transaction var1) {" +
                            "if(var1.getClientProposedSslProtocol() != null) { String ja3Plain = com.notcat.enhancedcharles.JA3Utils.translate(var1); ja3PlainNode.setValue(ja3Plain); ja3HashNode.setValue(com.notcat.enhancedcharles.JA3Utils.hash(ja3Plain).toLowerCase()); }" +
                            LOAD_METHOD_NAME + "_(var1);}",
                    overviewClass));

            transformedClasses.add(new TransformedClass(OVERVIEW_CLASS_PATH, overviewClass.toBytecode()));

            //endregion

            return transformedClasses;

        } catch (Exception exp) {
            exp.printStackTrace();
            return null;
        }

    }

}
