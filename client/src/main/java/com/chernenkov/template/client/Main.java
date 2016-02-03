package com.chernenkov.template.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.ui.*;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.Function;


public class Main implements EntryPoint {

    //load images
    public void onModuleLoad() {
        Polymer.importHref("iron-icons/iron-icons.html", new Function() {
            public Object call(Object o) {
                startApp();
                return null;
            }
        });


    }

    public void startApp(){
        RootPanel.get().add(new VaadinWidget());
    }
}
