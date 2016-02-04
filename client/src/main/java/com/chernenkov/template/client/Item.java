package com.chernenkov.template.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.iron.event.IronChangeEvent;
import com.vaadin.polymer.paper.widget.PaperCheckbox;

/**
 * Created by chern on 04.02.2016.
 */
public class Item extends Composite {
    interface ItemUiBinder extends UiBinder<HTMLPanel, Item> {
    }

    private static ItemUiBinder ourUiBinder = GWT.create(ItemUiBinder.class);

    @UiField
    Element title;
    @UiField
    Element description;
    @UiField
    PaperCheckbox done;

    public Item() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("done")
    protected void change(IronChangeEvent event) {
        if (done.getActive()) {
            title.addClassName("done");
        } else {
//            Removes a name from this element's class property.
            title.removeClassName("done");
        }
    }

    //JIdea marks string class but it works fine
    public String getTitle() {
        return title.getInnerText();
    }

    public void setTitle(String s) {
        title.setInnerText(s);
    }

    public String getDEscription() {
        return description.getInnerText();
    }

    public void setDescription(String s) {
        description.setInnerText(s);
    }

    public boolean isDone(){
        //????
        return done.getActive();
    }

    public void setDone(boolean b) {
        done.setActive(b);
    }


}
