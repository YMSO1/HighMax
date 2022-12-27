package com.company.highmax.app;

import com.company.highmax.entity.BankAccount;
import com.company.highmax.entity.Client;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccService {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DataManager dataManager;

    public List<BankAccount> fetchBankAccounts() {
        Client client = (Client) currentAuthentication.getUser();

        return dataManager.load(BankAccount.class)
                .query("select ba from BankAccount ba where ba.client = ?1", client).list();
    }
}