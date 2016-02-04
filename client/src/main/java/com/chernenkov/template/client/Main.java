package com.chernenkov.template.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.Function;
import com.vaadin.polymer.iron.IronIconElement;
import com.vaadin.polymer.paper.*;

import java.util.Arrays;


public class Main implements EntryPoint {


    public void onModuleLoad() {
        Polymer.importHref(Arrays.asList(
                "iron-icons/iron-icons.html",
                PaperIconItemElement.SRC,
                PaperRippleElement.SRC,
                IronIconElement.SRC,
                PaperDrawerPanelElement.SRC,
                PaperHeaderPanelElement.SRC,
                PaperToolbarElement.SRC,
                PaperFabElement.SRC,
                PaperDialogElement.SRC,
                PaperTextareaElement.SRC,
                PaperInputElement.SRC,
                PaperButtonElement.SRC,
                PaperCheckboxElement.SRC
        ), new Function() {
            public Object call(Object arg) {
                startApp();
                return null;
            }
        });

    }


    public void startApp(){
        RootPanel.get().add(new VaadinWidget());
    }
}
