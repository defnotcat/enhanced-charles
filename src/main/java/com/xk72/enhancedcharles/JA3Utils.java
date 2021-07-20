package com.xk72.enhancedcharles;

import com.xk72.charles.model.Transaction;
import com.xk72.proxy.ssl.SSLExtension;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JA3Utils {
    public static final HashMap<String, String> cipherSuites = new HashMap<String, String>() {
        {
            this.put("TLS_DHE_PSK_WITH_NULL_SHA256", "180");
            this.put("TLS_FALLBACK_SCSV", "22016");
            this.put("TLS_DH_anon_WITH_AES_256_CBC_SHA", "58");
            this.put("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "163");
            this.put("TLS_DH_RSA_WITH_AES_256_GCM_SHA384", "161");
            this.put("TLS_DH_anon_WITH_AES_256_CBC_SHA256", "109");
            this.put("TLS_DH_DSS_WITH_ARIA_128_CBC_SHA256", "49214");
            this.put("TLS_DHE_RSA_WITH_ARIA_128_CBC_SHA256", "49220");
            this.put("TLS_RSA_PSK_WITH_CAMELLIA_128_GCM_SHA256", "49298");
            this.put("TLS_RSA_WITH_AES_128_CCM", "49308");
            this.put("TLS_RSA_WITH_AES_256_CBC_SHA", "53");
            this.put("TLS_DHE_RSA_WITH_ARIA_128_GCM_SHA256", "49234");
            this.put("TLS_DH_anon_WITH_DES_CBC_SHA", "26");
            this.put("TLS_KRB5_WITH_DES_CBC_MD5", "34");
            this.put("TLS_SRP_SHA_WITH_AES_128_CBC_SHA", "49181");
            this.put("TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA", "49183");
            this.put("TLS_RSA_PSK_WITH_CAMELLIA_128_CBC_SHA256", "49304");
            this.put("TLS_DH_DSS_WITH_AES_128_GCM_SHA256", "164");
            this.put("TLS_PSK_WITH_AES_128_CCM", "49316");
            this.put("TLS_DHE_DSS_WITH_SEED_CBC_SHA", "153");
            this.put("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384", "49208");
            this.put("TLS_DH_DSS_WITH_ARIA_128_GCM_SHA256", "49240");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "49196");
            this.put("TLS_DH_anon_WITH_ARIA_128_GCM_SHA256", "49242");
            this.put("TLS_RSA_WITH_CAMELLIA_128_GCM_SHA256", "49274");
            this.put("TLS_DH_RSA_WITH_AES_256_CBC_SHA256", "105");
            this.put("TLS_DH_RSA_WITH_SEED_CBC_SHA", "152");
            this.put("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "31");
            this.put("TLS_RSA_WITH_AES_256_CBC_SHA256", "61");
            this.put("TLS_RSA_WITH_ARIA_128_GCM_SHA256", "49232");
            this.put("TLS_RSA_PSK_WITH_NULL_SHA", "46");
            this.put("TLS_DHE_PSK_WITH_NULL_SHA384", "181");
            this.put("TLS_DHE_PSK_WITH_ARIA_256_GCM_SHA384", "49261");
            this.put("TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "27");
            this.put("TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "20");
            this.put("TLS_RSA_PSK_WITH_CHACHA20_POLY1305_SHA256", "52398");
            this.put("TLS_DH_DSS_WITH_AES_128_CBC_SHA256", "62");
            this.put("TLS_ECDH_RSA_WITH_ARIA_128_GCM_SHA256", "49250");
            this.put("TLS_ECDH_RSA_WITH_ARIA_128_CBC_SHA256", "49230");
            this.put("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "51");
            this.put("TLS_DH_anon_WITH_ARIA_128_CBC_SHA256", "49222");
            this.put("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256", "186");
            this.put("TLS_DHE_PSK_WITH_AES_256_CBC_SHA", "145");
            this.put("TLS_RSA_PSK_WITH_ARIA_128_GCM_SHA256", "49262");
            this.put("TLS_ECDHE_ECDSA_WITH_NULL_SHA", "49158");
            this.put("TLS_ECDHE_PSK_WITH_NULL_SHA256", "49210");
            this.put("TLS_PSK_WITH_RC4_128_SHA", "138");
            this.put("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "49198");
            this.put("TLS_DHE_PSK_WITH_AES_128_CBC_SHA256", "178");
            this.put("TLS_DH_DSS_WITH_3DES_EDE_CBC_SHA", "13");
            this.put("TLS_RSA_WITH_AES_128_GCM_SHA256", "156");
            this.put("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "49194");
            this.put("TLS_PSK_WITH_ARIA_256_CBC_SHA384", "49253");
            this.put("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256", "190");
            this.put("TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_GCM_SHA384", "49287");
            this.put("TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256", "197");
            this.put("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "69");
            this.put("TLS_PSK_WITH_ARIA_256_GCM_SHA384", "49259");
            this.put("TLS_DH_anon_WITH_CAMELLIA_128_GCM_SHA256", "49284");
            this.put("TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256", "187");
            this.put("TLS_DHE_PSK_WITH_CAMELLIA_128_CBC_SHA256", "49302");
            this.put("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "49191");
            this.put("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "38");
            this.put("TLS_ECDHE_PSK_WITH_ARIA_128_CBC_SHA256", "49264");
            this.put("TLS_DHE_RSA_WITH_AES_256_CCM_8", "49315");
            this.put("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "49167");
            this.put("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "52396");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8", "49327");
            this.put("TLS_PSK_WITH_CHACHA20_POLY1305_SHA256", "52395");
            this.put("TLS_DHE_DSS_WITH_ARIA_256_CBC_SHA384", "49219");
            this.put("TLS_RSA_WITH_RC4_128_SHA", "5");
            this.put("TLS_ECDH_ECDSA_WITH_ARIA_128_GCM_SHA256", "49246");
            this.put("TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA", "49178");
            this.put("TLS_DHE_PSK_WITH_ARIA_128_CBC_SHA256", "49254");
            this.put("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "49201");
            this.put("TLS_ECDH_RSA_WITH_RC4_128_SHA", "49164");
            this.put("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "49175");
            this.put("TLS_RSA_WITH_3DES_EDE_CBC_SHA", "10");
            this.put("TLS_DH_DSS_WITH_AES_256_CBC_SHA", "54");
            this.put("TLS_RSA_WITH_AES_128_CCM_8", "49312");
            this.put("TLS_RSA_WITH_NULL_MD5", "1");
            this.put("TLS_RSA_WITH_ARIA_128_CBC_SHA256", "49212");
            this.put("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256", "195");
            this.put("TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA", "49179");
            this.put("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "106");
            this.put("TLS_RSA_WITH_SEED_CBC_SHA", "150");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "49187");
            this.put("TLS_DH_RSA_WITH_CAMELLIA_128_GCM_SHA256", "49278");
            this.put("TLS_DHE_DSS_WITH_CAMELLIA_128_GCM_SHA256", "49280");
            this.put("TLS_PSK_WITH_CAMELLIA_128_GCM_SHA256", "49294");
            this.put("TLS_DH_DSS_WITH_CAMELLIA_256_GCM_SHA384", "49283");
            this.put("TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA", "134");
            this.put("TLS_DH_anon_WITH_AES_128_GCM_SHA256", "166");
            this.put("TLS_ECDHE_RSA_WITH_ARIA_128_GCM_SHA256", "49248");
            this.put("TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "8");
            this.put("TLS_RSA_PSK_WITH_NULL_SHA384", "185");
            this.put("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "49156");
            this.put("TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "25");
            this.put("TLS_ECDHE_ECDSA_WITH_ARIA_128_GCM_SHA256", "49244");
            this.put("TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384", "49271");
            this.put("TLS_DH_RSA_WITH_AES_128_CBC_SHA256", "63");
            this.put("TLS_DHE_PSK_WITH_AES_128_CCM", "49318");
            this.put("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "162");
            this.put("TLS_PSK_WITH_AES_256_CBC_SHA384", "175");
            this.put("TLS_ECDHE_RSA_WITH_CAMELLIA_256_GCM_SHA384", "49291");
            this.put("TLS_RSA_PSK_WITH_CAMELLIA_256_CBC_SHA384", "49305");
            this.put("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "52393");
            this.put("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "159");
            this.put("TLS_DH_RSA_WITH_AES_128_CBC_SHA", "49");
            this.put("TLS_DH_DSS_WITH_ARIA_256_GCM_SHA384", "49241");
            this.put("TLS_DH_RSA_WITH_3DES_EDE_CBC_SHA", "16");
            this.put("TLS_ECDHE_ECDSA_WITH_ARIA_128_CBC_SHA256", "49224");
            this.put("TLS_ECDH_RSA_WITH_CAMELLIA_128_GCM_SHA256", "49292");
            this.put("TLS_ECDHE_PSK_WITH_CAMELLIA_256_CBC_SHA384", "49307");
            this.put("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256", "49207");
            this.put("TLS_DH_DSS_WITH_AES_256_GCM_SHA384", "165");
            this.put("TLS_RSA_PSK_WITH_NULL_SHA256", "184");
            this.put("TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA", "70");
            this.put("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "49170");
            this.put("TLS_RSA_WITH_ARIA_256_GCM_SHA384", "49233");
            this.put("TLS_DHE_PSK_WITH_ARIA_128_GCM_SHA256", "49260");
            this.put("TLS_AES_128_GCM_SHA256", "4865");
            this.put("TLS_DHE_DSS_WITH_ARIA_256_GCM_SHA384", "49239");
            this.put("TLS_PSK_WITH_NULL_SHA256", "176");
            this.put("TLS_ECDHE_PSK_WITH_3DES_EDE_CBC_SHA", "49204");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "49195");
            this.put("TLS_DH_DSS_EXPORT_WITH_DES40_CBC_SHA", "11");
            this.put("TLS_PSK_WITH_AES_128_CBC_SHA", "140");
            this.put("TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA", "49180");
            this.put("TLS_RSA_EXPORT_WITH_RC2_CBC_40_MD5", "6");
            this.put("TLS_ECDH_RSA_WITH_ARIA_256_CBC_SHA384", "49231");
            this.put("TLS_DHE_PSK_WITH_CAMELLIA_128_GCM_SHA256", "49296");
            this.put("TLS_PSK_DHE_WITH_AES_256_CCM_8", "49323");
            this.put("TLS_PSK_WITH_NULL_SHA384", "177");
            this.put("TLS_CHACHA20_POLY1305_SHA256", "4867");
            this.put("TLS_ECDH_ECDSA_WITH_CAMELLIA_256_CBC_SHA384", "49269");
            this.put("TLS_DHE_RSA_WITH_DES_CBC_SHA", "21");
            this.put("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "49197");
            this.put("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "49160");
            this.put("TLS_RSA_PSK_WITH_AES_256_CBC_SHA", "149");
            this.put("TLS_DH_DSS_WITH_AES_128_CBC_SHA", "48");
            this.put("TLS_RSA_WITH_AES_128_CBC_SHA256", "60");
            this.put("TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "17");
            this.put("TLS_RSA_WITH_AES_256_CCM", "49309");
            this.put("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "40");
            this.put("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "49193");
            this.put("TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_GCM_SHA256", "49286");
            this.put("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "49190");
            this.put("TLS_RSA_PSK_WITH_ARIA_128_CBC_SHA256", "49256");
            this.put("TLS_ECDH_ECDSA_WITH_CAMELLIA_256_GCM_SHA384", "49289");
            this.put("TLS_DHE_PSK_WITH_CAMELLIA_256_CBC_SHA384", "49303");
            this.put("TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256", "191");
            this.put("TLS_DHE_DSS_WITH_DES_CBC_SHA", "18");
            this.put("TLS_KRB5_WITH_RC4_128_MD5", "36");
            this.put("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "49154");
            this.put("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "49176");
            this.put("TLS_RSA_WITH_AES_128_CBC_SHA", "47");
            this.put("TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_CBC_SHA384", "49267");
            this.put("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "49165");
            this.put("TLS_ECDH_ECDSA_WITH_NULL_SHA", "49153");
            this.put("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "49155");
            this.put("TLS_DH_RSA_WITH_ARIA_128_CBC_SHA256", "49216");
            this.put("TLS_DH_RSA_WITH_CAMELLIA_128_CBC_SHA256", "188");
            this.put("TLS_DHE_RSA_WITH_AES_128_CCM_8", "49314");
            this.put("TLS_ECDHE_PSK_WITH_NULL_SHA384", "49211");
            this.put("TLS_DHE_PSK_WITH_ARIA_256_CBC_SHA384", "49255");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "49188");
            this.put("TLS_RSA_WITH_ARIA_256_CBC_SHA384", "49213");
            this.put("TLS_ECDH_ECDSA_WITH_ARIA_128_CBC_SHA256", "49226");
            this.put("TLS_KRB5_EXPORT_WITH_RC2_CBC_40_MD5", "42");
            this.put("TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA", "143");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "49162");
            this.put("TLS_ECDHE_RSA_WITH_ARIA_256_GCM_SHA384", "49249");
            this.put("TLS_KRB5_WITH_IDEA_CBC_SHA", "33");
            this.put("TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "22");
            this.put("TLS_DHE_DSS_WITH_CAMELLIA_256_GCM_SHA384", "49281");
            this.put("TLS_DHE_PSK_WITH_AES_256_CCM", "49319");
            this.put("TLS_PSK_WITH_CAMELLIA_256_GCM_SHA384", "49295");
            this.put("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "50");
            this.put("TLS_RSA_PSK_WITH_RC4_128_SHA", "146");
            this.put("TLS_DH_anon_WITH_AES_256_GCM_SHA384", "167");
            this.put("TLS_ECDHE_ECDSA_WITH_ARIA_256_GCM_SHA384", "49245");
            this.put("TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256", "49270");
            this.put("TLS_ECDHE_RSA_WITH_CAMELLIA_128_GCM_SHA256", "49290");
            this.put("TLS_PSK_WITH_AES_128_GCM_SHA256", "168");
            this.put("TLS_AES_128_CCM_SHA256", "4868");
            this.put("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "103");
            this.put("TLS_PSK_WITH_AES_128_CBC_SHA256", "174");
            this.put("TLS_ECDH_RSA_WITH_NULL_SHA", "49163");
            this.put("TLS_ECDH_RSA_WITH_CAMELLIA_256_GCM_SHA384", "49293");
            this.put("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "158");
            this.put("TLS_ECDHE_ECDSA_WITH_ARIA_256_CBC_SHA384", "49225");
            this.put("TLS_DH_anon_WITH_AES_128_CBC_SHA", "52");
            this.put("TLS_KRB5_WITH_DES_CBC_SHA", "30");
            this.put("TLS_ECDHE_PSK_WITH_CAMELLIA_128_CBC_SHA256", "49306");
            this.put("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "41");
            this.put("TLS_DH_RSA_EXPORT_WITH_DES40_CBC_SHA", "14");
            this.put("TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "19");
            this.put("TLS_AES_256_GCM_SHA384", "4866");
            this.put("TLS_SRP_SHA_WITH_AES_256_CBC_SHA", "49184");
            this.put("TLS_DH_RSA_WITH_ARIA_128_GCM_SHA256", "49236");
            this.put("TLS_RSA_EXPORT_WITH_RC4_40_MD5", "3");
            this.put("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "49159");
            this.put("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "35");
            this.put("TLS_DHE_DSS_WITH_ARIA_128_GCM_SHA256", "49238");
            this.put("TLS_ECDH_RSA_WITH_CAMELLIA_256_CBC_SHA384", "49273");
            this.put("TLS_ECDH_ECDSA_WITH_CAMELLIA_128_CBC_SHA256", "49268");
            this.put("TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA", "147");
            this.put("TLS_DH_anon_WITH_SEED_CBC_SHA", "155");
            this.put("TLS_RSA_PSK_WITH_AES_256_CBC_SHA384", "183");
            this.put("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "52394");
            this.put("TLS_ECDH_anon_WITH_RC4_128_SHA", "49174");
            this.put("TLS_ECDH_ECDSA_WITH_CAMELLIA_128_GCM_SHA256", "49288");
            this.put("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "49171");
            this.put("TLS_RSA_WITH_IDEA_CBC_SHA", "7");
            this.put("TLS_RSA_WITH_RC4_128_MD5", "4");
            this.put("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "49189");
            this.put("TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "23");
            this.put("TLS_DHE_PSK_WITH_CAMELLIA_256_GCM_SHA384", "49297");
            this.put("TLS_RSA_PSK_WITH_AES_256_GCM_SHA384", "173");
            this.put("TLS_RSA_PSK_WITH_ARIA_256_CBC_SHA384", "49257");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_128_CCM", "49324");
            this.put("TLS_DHE_PSK_WITH_AES_128_CBC_SHA", "144");
            this.put("TLS_ECDHE_PSK_WITH_NULL_SHA", "49209");
            this.put("TLS_RSA_WITH_DES_CBC_SHA", "9");
            this.put("TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA", "49186");
            this.put("TLS_ECDHE_RSA_WITH_ARIA_256_CBC_SHA384", "49229");
            this.put("TLS_DH_RSA_WITH_ARIA_256_CBC_SHA384", "49217");
            this.put("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "52392");
            this.put("TLS_DHE_PSK_WITH_AES_256_GCM_SHA384", "171");
            this.put("TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA", "49185");
            this.put("TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA", "133");
            this.put("TLS_DHE_PSK_WITH_RC4_128_SHA", "142");
            this.put("TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_CBC_SHA256", "49266");
            this.put("TLS_RSA_WITH_NULL_SHA", "2");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "49161");
            this.put("TLS_AES_128_CCM_8_SHA256", "4869");
            this.put("TLS_ECDHE_RSA_WITH_RC4_128_SHA", "49169");
            this.put("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "68");
            this.put("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "255");
            this.put("TLS_PSK_WITH_3DES_EDE_CBC_SHA", "139");
            this.put("TLS_PSK_WITH_CAMELLIA_256_CBC_SHA384", "49301");
            this.put("TLS_DHE_RSA_WITH_SEED_CBC_SHA", "154");
            this.put("TLS_PSK_WITH_AES_256_CCM_8", "49321");
            this.put("TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256", "194");
            this.put("TLS_DHE_RSA_WITH_CAMELLIA_256_GCM_SHA384", "49277");
            this.put("TLS_ECDH_ECDSA_WITH_ARIA_256_CBC_SHA384", "49227");
            this.put("TLS_DHE_PSK_WITH_NULL_SHA", "45");
            this.put("TLS_DH_DSS_WITH_SEED_CBC_SHA", "151");
            this.put("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "49200");
            this.put("TLS_PSK_WITH_NULL_SHA", "44");
            this.put("TLS_DH_RSA_WITH_AES_128_GCM_SHA256", "160");
            this.put("TLS_DHE_RSA_WITH_ARIA_256_GCM_SHA384", "49235");
            this.put("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "64");
            this.put("TLS_PSK_WITH_AES_256_GCM_SHA384", "169");
            this.put("TLS_DH_anon_WITH_ARIA_256_GCM_SHA384", "49243");
            this.put("TLS_RSA_PSK_WITH_CAMELLIA_256_GCM_SHA384", "49299");
            this.put("TLS_DH_RSA_WITH_AES_256_CBC_SHA", "55");
            this.put("TLS_ECDHE_RSA_WITH_NULL_SHA", "49168");
            this.put("TLS_DHE_RSA_WITH_ARIA_256_CBC_SHA384", "49221");
            this.put("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "132");
            this.put("TLS_DH_DSS_WITH_AES_256_CBC_SHA256", "104");
            this.put("TLS_RSA_WITH_CAMELLIA_256_GCM_SHA384", "49275");
            this.put("TLS_PSK_WITH_AES_128_CCM_8", "49320");
            this.put("TLS_NULL_WITH_NULL_NULL", "0");
            this.put("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "49157");
            this.put("TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA", "137");
            this.put("TLS_ECDHE_PSK_WITH_RC4_128_SHA", "49203");
            this.put("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "49205");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_256_CCM", "49325");
            this.put("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA256", "192");
            this.put("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "65");
            this.put("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "56");
            this.put("TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8", "49326");
            this.put("TLS_RSA_WITH_AES_256_CCM_8", "49313");
            this.put("TLS_DH_RSA_WITH_ARIA_256_GCM_SHA384", "49237");
            this.put("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "49206");
            this.put("TLS_RSA_PSK_WITH_ARIA_256_GCM_SHA384", "49263");
            this.put("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "49166");
            this.put("TLS_ECDH_RSA_WITH_ARIA_256_GCM_SHA384", "49251");
            this.put("TLS_DH_anon_WITH_ARIA_256_CBC_SHA384", "49223");
            this.put("TLS_DH_anon_WITH_RC4_128_MD5", "24");
            this.put("TLS_DH_DSS_WITH_ARIA_256_CBC_SHA384", "49215");
            this.put("TLS_ECDH_RSA_WITH_CAMELLIA_128_CBC_SHA256", "49272");
            this.put("TLS_RSA_PSK_WITH_AES_128_CBC_SHA256", "182");
            this.put("TLS_RSA_WITH_NULL_SHA256", "59");
            this.put("TLS_ECDH_anon_WITH_NULL_SHA", "49173");
            this.put("TLS_PSK_WITH_ARIA_128_GCM_SHA256", "49258");
            this.put("TLS_KRB5_WITH_IDEA_CBC_MD5", "37");
            this.put("TLS_PSK_WITH_ARIA_128_CBC_SHA256", "49252");
            this.put("TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA", "49182");
            this.put("TLS_DHE_PSK_WITH_AES_256_CBC_SHA384", "179");
            this.put("TLS_RSA_WITH_AES_256_GCM_SHA384", "157");
            this.put("TLS_DH_RSA_WITH_DES_CBC_SHA", "15");
            this.put("TLS_DHE_RSA_WITH_CAMELLIA_128_GCM_SHA256", "49276");
            this.put("TLS_KRB5_WITH_RC4_128_SHA", "32");
            this.put("TLS_RSA_PSK_WITH_AES_128_CBC_SHA", "148");
            this.put("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "49177");
            this.put("TLS_DH_DSS_WITH_DES_CBC_SHA", "12");
            this.put("TLS_DH_RSA_WITH_CAMELLIA_128_CBC_SHA", "67");
            this.put("TLS_DHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "52397");
            this.put("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "49192");
            this.put("TLS_ECDHE_PSK_WITH_ARIA_256_CBC_SHA384", "49265");
            this.put("TLS_RSA_PSK_WITH_AES_128_GCM_SHA256", "172");
            this.put("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "43");
            this.put("TLS_DH_anon_WITH_CAMELLIA_256_GCM_SHA384", "49285");
            this.put("TLS_ECDHE_RSA_WITH_ARIA_128_CBC_SHA256", "49228");
            this.put("TLS_ECDH_ECDSA_WITH_ARIA_256_GCM_SHA384", "49247");
            this.put("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "135");
            this.put("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "49202");
            this.put("TLS_DHE_PSK_WITH_AES_128_GCM_SHA256", "170");
            this.put("TLS_DHE_DSS_WITH_ARIA_128_CBC_SHA256", "49218");
            this.put("TLS_PSK_WITH_AES_256_CBC_SHA", "141");
            this.put("TLS_PSK_WITH_AES_256_CCM", "49317");
            this.put("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "107");
            this.put("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256", "196");
            this.put("TLS_DH_anon_WITH_AES_128_CBC_SHA256", "108");
            this.put("TLS_DHE_RSA_WITH_AES_256_CCM", "49311");
            this.put("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "57");
            this.put("TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256", "193");
            this.put("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "49199");
            this.put("TLS_DHE_RSA_WITH_AES_128_CCM", "49310");
            this.put("TLS_PSK_WITH_CAMELLIA_128_CBC_SHA256", "49300");
            this.put("TLS_PSK_DHE_WITH_AES_128_CCM_8", "49322");
            this.put("TLS_DH_RSA_WITH_CAMELLIA_256_GCM_SHA384", "49279");
            this.put("TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA", "66");
            this.put("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256", "189");
            this.put("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "49172");
            this.put("TLS_KRB5_EXPORT_WITH_RC2_CBC_40_SHA", "39");
            this.put("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "136");
            this.put("TLS_DH_DSS_WITH_CAMELLIA_128_GCM_SHA256", "49282");
        }
    };
    private static final HashMap<String, String> tlsVersions = new HashMap<String, String>() {
        {
            this.put("SSLv3", "768");
            this.put("TLSv1", "769");
            this.put("TLSv1.1", "770");
            this.put("TLSv1.2", "771");
            this.put("TLSv1.3", "772");
        }
    };
    private static MessageDigest md5Digest;

    public JA3Utils() {
    }

    public static String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }

    private static boolean isGrease(int num) {
        return (num & -61681) == 2570;
    }

    private static byte[] readData(byte[] bytes) {
        if (bytes.length == 2) {
            return new byte[]{bytes[1]};
        } else {
            byte[] output = new byte[bytes.length];
            int outIndex = 0;

            for(int index = 2; index < (bytes[0] | bytes[1]) + 2; index += 2) {
                if (bytes[index] != bytes[index + 1]) {
                    output[outIndex++] = (byte)(bytes[index] | bytes[index + 1]);
                }
            }

            return Arrays.copyOfRange(output, 0, outIndex);
        }
    }

    private static void joinBytes(byte[] bytes, StringBuilder output) {
        for(int index = 0; index < bytes.length; ++index) {
            output.append(bytes[index]).append(index < bytes.length - 1 ? "-" : "");
        }

    }

    public static String translate(Transaction transaction) {

        try {

            if(transaction.getClientProposedCipherSuites() != null) {

                StringBuilder stringBuilder = new StringBuilder(tlsVersions.get(transaction.getClientProposedSslProtocol())).append(",");
                List<String> proposedCiphers = transaction.getClientProposedCipherSuites();

                for (String cipher : proposedCiphers)
                    if (cipherSuites.containsKey(cipher))
                        stringBuilder.append(cipherSuites.get(cipher)).append(proposedCiphers.indexOf(cipher) < proposedCiphers.size() - 1 ? "-" : "");

                stringBuilder.append(",");
                List<SSLExtension> sslExtensions = transaction.getClientProposedExtensions();
                byte[] supportedGroups = null;
                byte[] ecPtsFormats = null;
                for (SSLExtension extension: sslExtensions) {

                    int extType = extension.getType();
                    if(isGrease(extType)) continue;

                    byte[] extData = extension.getData();
                    switch(extType) {

                        case 10:
                            supportedGroups = extData;
                            break;

                        case 11:
                            ecPtsFormats = extData;
                            break;

                    }

                    stringBuilder.append(extType).append(sslExtensions.indexOf(extension) < sslExtensions.size() -1 ? "-" : "");
                }

                stringBuilder.append(",");
                if (supportedGroups != null)
                    joinBytes(readData(supportedGroups), stringBuilder);

                stringBuilder.append(",");
                if (ecPtsFormats != null)
                    joinBytes(readData(ecPtsFormats), stringBuilder);

                return stringBuilder.toString();

            }

        } catch(Exception exp) {
            // ignored
        }

        return "-";

    }

    private static final HashMap<String, String> knownJa3s = new HashMap<String, String>() {
        {
            put("b32309a26951912be7dba376398abc3b", "Chrome 83 (up to 90)");
            put("66918128f1b9b03303d77c6f2eefd128", "Chrome 72");
            put("b4918ee98d0f0deb4e48563ca749ef10", "Chrome 70");
            put("bc6c386f480ee97b9d9e52d472b772d8", "Chrome 62");
            put("aa7744226c695c0b2e440419848cf700", "Firefox 88");
            put("b20b44b18b853ef29ab773e921b03422", "Firefox 63");
            put("0ffee3ba8e615ad22535e7f771690a28", "Firefox 56");
            put("656b9a2f4de6ed4909e157482860ab3d", "iOS 14.0");
            put("6fa3244afc6bb6f9fad207b6b52af26b", "iOS 13.0");
            put("5c118da645babe52f060d0754256a73c", "iOS 12.1");
            put("a69708a64f853c3bcc214c2c5faf84f3", "iOS 11.1");
        }
    };

    public static String identify(String hash) {
        return knownJa3s.getOrDefault(hash, "-");
    }

    public static String hash(String plain) {
        if (md5Digest == null) {
            try {
                md5Digest = MessageDigest.getInstance("MD5");
            } catch (Exception var2) {
            }
        }

        return toHex(md5Digest.digest(plain.getBytes()));
    }
}
