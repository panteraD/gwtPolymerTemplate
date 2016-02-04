package com.chernenkov.template.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.paper.widget.PaperDialog;
import com.vaadin.polymer.paper.widget.PaperDrawerPanel;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperTextarea;


public class VaadinWidget extends Composite {
    //    those files are mapped in ui.xml file
    @UiField
    PaperDrawerPanel drawerPanel;
    @UiField
    HTMLPanel content;
    @UiField
    PaperDialog addItemDialog;
    @UiField
    PaperInput titleInput;
    @UiField
    PaperTextarea descriptionInput;



    interface MainUiBinder extends UiBinder<HTMLPanel, VaadinWidget> {
    }

    private static MainUiBinder ourMainUiBinder = GWT.create(MainUiBinder.class);

    public VaadinWidget() {
        initWidget(ourMainUiBinder.createAndBindUi(this));

    }

    @UiHandler("addButton")
    protected void onAddButtonClick(ClickEvent e){
        addItemDialog.open();
    }


    //?????wtf
    @UiHandler("confirmAddButton")
    protected void onConfirmAddButtonClick(ClickEvent e) {
        addItem(titleInput.getValue(), descriptionInput.getValue());
        //clear text fields
        titleInput.setValue("");
        descriptionInput.setValue("");
    }

    private void addItem(String title, String description){
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        content.add(item);
    }


    @UiHandler("menuClearAll")
    protected void menuClearAll(ClickEvent e){
        closeMenu();
        content.clear();
    }

    @UiHandler("menuClearDone")
    protected void menuClearDone(ClickEvent e){
        closeMenu();
        for (int i = content.getWidgetCount() - 1; i > -1 ; i--) {
            Item item = (Item) content.getWidget(i);
            if(item.isDone()){
                content.remove(item);
            }
        }

    }

    private void closeMenu() {
        //what method getNarrow does?
        if(drawerPanel.getNarrow()){
            drawerPanel.closeDrawer();
        }
    }

}
