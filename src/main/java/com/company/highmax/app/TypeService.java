package com.company.highmax.app;

import com.company.highmax.entity.Client;
import com.company.highmax.entity.Type;
import io.jmix.core.DataManager;
import io.jmix.core.security.CurrentAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private DataManager dataManager;

    public List<Type> fetchTypes() {
        Client client = (Client) currentAuthentication.getUser();

        return dataManager.load(Type.class)
                .query("select t from Type_ t where t.client = ?1", client).list();
    }
}