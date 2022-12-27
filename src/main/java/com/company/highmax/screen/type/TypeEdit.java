package com.company.highmax.screen.type;

import com.company.highmax.entity.Client;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.highmax.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author YMS01
 * @date 27.12.2022 10:53
 */
@UiController("Type_.edit")
@UiDescriptor("type-edit.xml")
@EditedEntityContainer("typeDc")
public class TypeEdit extends StandardEditor<Type> {
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Type> event) {
        event.getEntity().setClient((Client) currentAuthentication.getUser());
    }
}