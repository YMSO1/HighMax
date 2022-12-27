package com.company.highmax.screen.transaction;

import com.company.highmax.app.TransactionService;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.highmax.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author YMS01
 * @date 27.12.2022 10:59
 */
@UiController("Transaction_.browse")
@UiDescriptor("transaction-browse.xml")
@LookupComponent("transactionsTable")
public class TransactionBrowse extends StandardLookup<Transaction> {
    @Autowired
    private TransactionService transactionService;

    @Install(to = "transactionsDl", target = Target.DATA_LOADER)
    private List<Transaction> transactionsDlLoadDelegate(LoadContext<Transaction> loadContext) {
        return transactionService.fetchTransactions();
    }
}