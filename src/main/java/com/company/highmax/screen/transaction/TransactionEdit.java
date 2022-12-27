package com.company.highmax.screen.transaction;

import io.jmix.ui.screen.*;
import com.company.highmax.entity.Transaction;


/**
 * @author YMS01
 * @date 27.12.2022 10:59
 */
@UiController("Transaction_.edit")
@UiDescriptor("transaction-edit.xml")
@EditedEntityContainer("transactionDc")
public class TransactionEdit extends StandardEditor<Transaction> {
}