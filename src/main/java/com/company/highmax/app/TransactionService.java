package com.company.highmax.app;

import com.company.highmax.entity.Client;
import com.company.highmax.entity.Transaction;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DataManager dataManager;

    public List<Transaction> fetchTransactions() {
        Client client = (Client) currentAuthentication.getUser();

        List<Transaction> transactionList1 = dataManager.load(Transaction.class)
                .query("select ta from Transaction_ ta where ta.toAcc.client = ?1 and ta.fromAcc is null", client).list();
        List<Transaction> transactionList2 = dataManager.load(Transaction.class)
                .query("select ta from Transaction_ ta where ta.fromAcc.client = ?1", client).list();
            transactionList1.addAll(transactionList2);
            return transactionList1;
    }
}