package com.company.highmax.screen.bankaccount;

import com.company.highmax.entity.Client;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.highmax.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author YMS01
 * @date 27.12.2022 10:56
 */
@UiController("BankAccount.edit")
@UiDescriptor("bank-account-edit.xml")
@EditedEntityContainer("bankAccountDc")
public class BankAccountEdit extends StandardEditor<BankAccount> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(InitEntityEvent<BankAccount> event) {

        event.getEntity().setClient((Client) currentAuthentication.getUser());
    }
}