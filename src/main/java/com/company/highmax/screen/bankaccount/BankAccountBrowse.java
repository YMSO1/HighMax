package com.company.highmax.screen.bankaccount;

import com.company.highmax.app.BankAccService;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.highmax.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author YMS01
 * @date 27.12.2022 10:56
 */
@UiController("BankAccount.browse")
@UiDescriptor("bank-account-browse.xml")
@LookupComponent("bankAccountsTable")
public class BankAccountBrowse extends StandardLookup<BankAccount> {
    @Autowired
    private BankAccService bankAccService;

    @Install(to = "bankAccountsDl", target = Target.DATA_LOADER)
    private List<BankAccount> bankAccountsDlLoadDelegate(LoadContext<BankAccount> loadContext) {
        return bankAccService.fetchBankAccounts();
    }
}