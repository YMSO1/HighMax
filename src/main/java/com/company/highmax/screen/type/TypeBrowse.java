package com.company.highmax.screen.type;

import com.company.highmax.app.TypeService;
import io.jmix.core.LoadContext;
import io.jmix.ui.screen.*;
import com.company.highmax.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author YMS01
 * @date 27.12.2022 10:53
 */
@UiController("Type_.browse")
@UiDescriptor("type-browse.xml")
@LookupComponent("typesTable")
public class TypeBrowse extends StandardLookup<Type> {
    @Autowired
    private TypeService typeService;

    @Install(to = "typesDl", target = Target.DATA_LOADER)
    private List<Type> typesDlLoadDelegate(LoadContext<Type> loadContext) {
        return typeService.fetchTypes();
    }
}