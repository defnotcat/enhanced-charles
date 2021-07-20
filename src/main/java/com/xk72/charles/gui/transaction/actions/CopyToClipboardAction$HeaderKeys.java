package com.xk72.charles.gui.transaction.actions;

import com.xk72.charles.model.Transaction;
import com.xk72.proxy.Fields;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class CopyToClipboardAction$HeaderKeys extends CopyToClipboardAction {
    private final Transaction transaction;

    public CopyToClipboardAction$HeaderKeys(Transaction transaction) {
        super("Copy Header Keys");
        this.transaction = transaction;
    }

    protected Transferable getBody() {
        return new StringSelection(String.join("\n", transaction.getRequestHeader().getFieldNames()));
    }
}