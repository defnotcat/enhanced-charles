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
    public final String OVERVIEW_CLASS_PATH = "com.xk72.charles.gui.transaction.general.i";
    public final String INIT_METHOD_NAME = "c";
    public final String LOAD_METHOD_NAME = "a";
    //endregion

    @Override
    public Iterable<TransformedClass> transform(ClassPool classPool) {

        ArrayList<TransformedClass> transformedClasses = new ArrayList<>();

        try {

            ClassInjector.inject(Arrays.asList(
                    "com.xk72.enhancedcharles.JA3Utils",
                    "com.xk72.enhancedcharles.JA3Utils$1",
                    "com.xk72.enhancedcharles.JA3Utils$2",
                    "com.xk72.enhancedcharles.JA3Utils$3"
            ), classPool, transformedClasses);

            //region Patch Overview Tab

            classPool.importPackage("com.xk72.charles.gui.lib.treetable");
            classPool.importPackage("com.xk72.charles.model");

            CtClass overviewClass = classPool.get(OVERVIEW_CLASS_PATH);

            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3Node;", overviewClass));
            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3PlainNode;", overviewClass));
            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3HashNode;", overviewClass));
            overviewClass.addField(CtField.make("private DefaultTreeTableNode ja3IdNode;", overviewClass));
            //overviewClass.addField(CtField.make("private DefaultTreeTableNode rawClientHelloNode;", overviewClass));

            //region Patch Init
            overviewClass.getDeclaredMethod(INIT_METHOD_NAME).
                    setBody("{this.b.add(this.e = new DefaultTreeTableNode(\"URL\"));\n" +
                            "      this.b.add(this.g = new DefaultTreeTableNode(\"Status\"));\n" +
                            "      this.b.add(this.h = new DefaultTreeTableNode(\"Failure\"));\n" +
                            "      this.b.add(this.f = new DefaultTreeTableNode(\"Notes\"));\n" +
                            "      this.b.add(this.i = new DefaultTreeTableNode(\"Response Code\"));\n" +
                            "      this.b.add(this.j = new DefaultTreeTableNode(\"Protocol\"));\n" +
                            "      this.b.add(this.k = new DefaultTreeTableNode(\"TLS\"));\n" +
                            "      this.k.add(this.ja3Node = new DefaultTreeTableNode(\"JA3\"));\n" +
                            "      this.ja3Node.add(this.ja3PlainNode = new DefaultTreeTableNode(\"Plain\"));\n" +
                            "      this.ja3Node.add(this.ja3HashNode = new DefaultTreeTableNode(\"Hash\"));\n" +
                            "      this.ja3Node.add(this.ja3IdNode = new DefaultTreeTableNode(\"Identified As\"));\n" +
                            "      this.k.add(this.q = new DefaultTreeTableNode(\"Protocol\"));\n" +
                            "      this.q.add(this.s = new DefaultTreeTableNode(\"Client Supported\"));\n" +
                            "      this.q.add(this.t = new DefaultTreeTableNode(\"Charles to Client\"));\n" +
                            "      this.q.add(this.r = new DefaultTreeTableNode(\"Server Chosen\"));\n" +
                            "      this.k.add(this.J = new DefaultTreeTableNode(\"Alert Code\"));\n" +
                            "      this.k.add(this.l = new DefaultTreeTableNode(\"Session Resumed\"));\n" +
                            "      this.l.add(this.m = new DefaultTreeTableNode(\"Client Requested\"));\n" +
                            "      this.l.add(this.o = new DefaultTreeTableNode(\"Client Session ID\"));\n" +
                            "      this.l.add(this.p = new DefaultTreeTableNode(\"Charles Requested\"));\n" +
                            "      this.l.add(this.n = new DefaultTreeTableNode(\"Server Session ID\"));\n" +
                            "      this.k.add(this.u = new DefaultTreeTableNode(\"Cipher Suite\"));\n" +
                            "      this.u.add(this.v = new DefaultTreeTableNode(\"Client Supported\"));\n" +
                            "      this.u.add(this.x = new DefaultTreeTableNode(\"Charles to Client\"));\n" +
                            "      this.u.add(this.w = new DefaultTreeTableNode(\"Server Chosen\"));\n" +
                            "      this.k.add(this.y = new DefaultTreeTableNode(\"ALPN\"));\n" +
                            "      this.y.add(this.z = new DefaultTreeTableNode(\"Client Supported\"));\n" +
                            "      this.y.add(this.A = new DefaultTreeTableNode(\"Charles Supported\"));\n" +
                            "      this.y.add(this.B = new DefaultTreeTableNode(\"Server Chosen\"));\n" +
                            "      this.k.add(this.C = new DefaultTreeTableNode(\"Client Certificates\"));\n" +
                            "      this.k.add(this.D = new DefaultTreeTableNode(\"Server Certificates\"));\n" +
                            "      this.k.add(this.E = new DefaultTreeTableNode(\"Extensions\"));\n" +
                            "      this.E.add(this.F = new DefaultTreeTableNode(\"Client\"));\n" +
                            "      this.E.add(this.G = new DefaultTreeTableNode(\"Charles to Client\"));\n" +
                            "      this.E.add(this.H = new DefaultTreeTableNode(\"Charles to Server\"));\n" +
                            "      this.E.add(this.I = new DefaultTreeTableNode(\"Server\"));\n" +
                            "      this.b.add(this.K = new DefaultTreeTableNode(\"Method\"));\n" +
                            "      this.b.add(this.as = new DefaultTreeTableNode(\"Kept Alive\"));\n" +
                            "      this.b.add(this.L = new DefaultTreeTableNode(\"Content-Type\"));\n" +
                            "      this.b.add(this.M = new DefaultTreeTableNode(\"Client Address\"));\n" +
                            "      this.b.add(this.N = new DefaultTreeTableNode(\"Remote Address\"));\n" +
                            "      this.b.add(this.au = new DefaultTreeTableNode(\"Tags\"));\n" +
                            "      this.b.add(this.at = new DefaultTreeTableNode(\"Connection\"));\n" +
                            "      this.av = new DefaultTreeTableNode(\"WebSockets\");\n" +
                            "      this.av.add(this.aw = new DefaultTreeTableNode(\"Origin\"));\n" +
                            "      this.av.add(this.ax = new DefaultTreeTableNode(\"Version\"));\n" +
                            "      this.av.add(this.ay = new DefaultTreeTableNode(\"Protocol\"));\n" +
                            "      this.av.add(this.az = new DefaultTreeTableNode(\"Extensions\"));\n" +
                            "      this.av.add(this.aA = new DefaultTreeTableNode(\"Messages Sent\"));\n" +
                            "      this.av.add(this.aB = new DefaultTreeTableNode(\"Messages Received\"));\n" +
                            "      this.av.add(this.aC = new DefaultTreeTableNode(\"Control Frames Sent\"));\n" +
                            "      this.av.add(this.aD = new DefaultTreeTableNode(\"Control Frames Received\"));\n" +
                            "      this.b.add(this.av);\n" +
                            "      DefaultTreeTableNode var1 = new DefaultTreeTableNode(\"Timing\");\n" +
                            "      var1.add(this.O = new DefaultTreeTableNode(\"Request Start Time\"));\n" +
                            "      var1.add(this.P = new DefaultTreeTableNode(\"Request End Time\"));\n" +
                            "      var1.add(this.Q = new DefaultTreeTableNode(\"Response Start Time\"));\n" +
                            "      var1.add(this.R = new DefaultTreeTableNode(\"Response End Time\"));\n" +
                            "      var1.add(this.ae = new DefaultTreeTableNode(\"Duration\"));\n" +
                            "      var1.add(this.ag = new DefaultTreeTableNode(\"DNS\"));\n" +
                            "      var1.add(this.ah = new DefaultTreeTableNode(\"Connect\"));\n" +
                            "      var1.add(this.ai = new DefaultTreeTableNode(\"TLS Handshake\"));\n" +
                            "      var1.add(this.aj = new DefaultTreeTableNode(\"Request\"));\n" +
                            "      var1.add(this.ak = new DefaultTreeTableNode(\"Response\"));\n" +
                            "      var1.add(this.af = new DefaultTreeTableNode(\"Latency\"));\n" +
                            "      var1.add(this.al = new DefaultTreeTableNode(\"Speed\"));\n" +
                            "      var1.add(this.am = new DefaultTreeTableNode(\"Request Speed\"));\n" +
                            "      var1.add(this.an = new DefaultTreeTableNode(\"Response Speed\"));\n" +
                            "      this.b.add(var1);\n" +
                            "      DefaultTreeTableNode var2 = new DefaultTreeTableNode(\"Size\");\n" +
                            "      var2.add(this.S = new DefaultTreeTableNode(\"Request\"));\n" +
                            "      this.S.add(this.W = new DefaultTreeTableNode(\"TLS Handshake\"));\n" +
                            "      this.S.add(this.U = new DefaultTreeTableNode(\"Header\"));\n" +
                            "      this.S.add(this.Y = new DefaultTreeTableNode(\"Query String\"));\n" +
                            "      this.S.add(this.Z = new DefaultTreeTableNode(\"Cookies\"));\n" +
                            "      this.S.add(this.aa = new DefaultTreeTableNode(\"Body\"));\n" +
                            "      this.S.add(this.aq = new DefaultTreeTableNode(\"Uncompressed Body\"));\n" +
                            "      this.S.add(this.ao = new DefaultTreeTableNode(\"Compression\"));\n" +
                            "      var2.add(this.T = new DefaultTreeTableNode(\"Response\"));\n" +
                            "      this.T.add(this.X = new DefaultTreeTableNode(\"TLS Handshake\"));\n" +
                            "      this.T.add(this.V = new DefaultTreeTableNode(\"Header\"));\n" +
                            "      this.T.add(this.ab = new DefaultTreeTableNode(\"Cookies\"));\n" +
                            "      this.T.add(this.ac = new DefaultTreeTableNode(\"Body\"));\n" +
                            "      this.T.add(this.ar = new DefaultTreeTableNode(\"Uncompressed Body\"));\n" +
                            "      this.T.add(this.ap = new DefaultTreeTableNode(\"Compression\"));\n" +
                            "      var2.add(this.ad = new DefaultTreeTableNode(\"Total\"));\n" +
                            "      this.b.add(var2);\n}");
            //endregion

            overviewClass.getDeclaredMethod(LOAD_METHOD_NAME, new CtClass[]{
                    classPool.get("com.xk72.charles.model.Transaction")
            }).setName(LOAD_METHOD_NAME + "_");

            overviewClass.addMethod(CtNewMethod.make(
                    "private void " + LOAD_METHOD_NAME + "(Transaction var1) {" +
                            "if(var1.getClientProposedSslProtocol() != null) { " +
                            "String ja3Plain = com.xk72.enhancedcharles.JA3Utils.translate(var1); " +
                            "ja3PlainNode.setValue(ja3Plain); " +
                            "String ja3Hash = com.xk72.enhancedcharles.JA3Utils.hash(ja3Plain).toLowerCase();"+
                            "ja3HashNode.setValue(ja3Hash); " +
                            "ja3IdNode.setValue(com.xk72.enhancedcharles.JA3Utils.identify(ja3Hash));}" +
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
