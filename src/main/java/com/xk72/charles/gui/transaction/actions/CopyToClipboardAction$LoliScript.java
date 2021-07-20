package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.model.Transaction;
import com.xk72.proxy.Fields;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class CopyToClipboardAction$LoliScript extends CopyToClipboardAction {
    private final Transaction transaction;

    public CopyToClipboardAction$LoliScript(Transaction transaction) {
        super("Copy Loli Script");
        this.transaction = transaction;
    }

    protected Transferable getBody() {

        StringBuilder stringBuilder = new StringBuilder("REQUEST ")
                .append(transaction.getMethod().toUpperCase())
                .append(" \"")
                .append(transaction.toURL().toExternalForm())
                .append("\"\n  ");

        Fields headers = this.transaction.getRequestHeader();
        String bodyStr;
        if (this.transaction.hasRequestBody() && (bodyStr = transaction.getDecodedRequestBodyAsString()).length() > 0) {
            System.out.println(bodyStr.length());
            bodyStr = bodyStr.replace("\"", "\\\"");
            stringBuilder.append("CONTENT \"").append(bodyStr).append("\"\n");

            String contentType = headers.getField("Content-Type");
            if (contentType != null)
                stringBuilder.append("  CONTENTTYPE \"").append(contentType).append("\"\n");

            else
                stringBuilder.append("\n\n");

        } else
            stringBuilder.append("\n");

        for(int index = 0; index < headers.getFieldCount(); ++index) {
            String key = headers.getFieldName(index);
            if(key.startsWith(":")) continue;
            String value = headers.getFieldValue(index).replace("\"", "\\\"");
            stringBuilder.append("  HEADER \"").append(key).append(": ").append(value).append("\"\n");
        }

        return new StringSelection(stringBuilder.toString());
    }
}
