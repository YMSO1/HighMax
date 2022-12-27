package com.company.highmax.screen.client;

import io.jmix.ui.screen.*;
import com.company.highmax.entity.Client;


/**
 * @author YMS01
 * @date 27.12.2022 10:43
 */
@UiController("Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
public class ClientBrowse extends StandardLookup<Client> {
}