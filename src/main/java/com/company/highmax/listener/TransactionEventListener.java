package com.company.highmax.listener;

import com.company.highmax.entity.BankAccount;
import com.company.highmax.entity.Transaction;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntityChangedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionEventListener {
    @Autowired
    private DataManager dataManager;

    @EventListener
    public void onTransactionChangedBeforeCommit(EntityChangedEvent<Transaction> event) {
        BankAccount bankAccount1;
        BankAccount bankAccount2;
        Transaction transaction = dataManager.load(event.getEntityId()).one();

        if (transaction.getFromAcc() != null) {
            bankAccount1 = transaction.getFromAcc();
            BigDecimal amount = bankAccount1.getAmount();
            bankAccount1.setAmount(amount.subtract(transaction.getTransferAmount()));
            dataManager.save(bankAccount1);
        }
        if (transaction.getToAcc() != null) {
            bankAccount2 = transaction.getToAcc();
            BigDecimal amount = bankAccount2.getAmount();
            bankAccount2.setAmount(amount.add(transaction.getTransferAmount()));
            dataManager.save(bankAccount2);
        }
    }
}