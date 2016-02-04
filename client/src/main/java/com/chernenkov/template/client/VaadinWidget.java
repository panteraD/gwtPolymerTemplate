package com.chernenkov.template.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.vaadin.polymer.elemental.Event;
import com.vaadin.polymer.elemental.EventListener;
import com.vaadin.polymer.elemental.HTMLElement;
import com.vaadin.polymer.paper.*;

import java.util.ArrayList;
import java.util.List;


public class VaadinWidget extends Composite {
    interface MainUiBinder extends UiBinder<HTMLPanel, VaadinWidget> {
    }

    private static MainUiBinder ourUiBinder = GWT.create(MainUiBinder.class);

    @UiField PaperDrawerPanelElement drawerPanel;

    @UiField PaperIconItemElement menuClearAll;
    @UiField PaperIconItemElement menuClearDone;

    @UiField HTMLElement content;
    @UiField PaperFabElement addButton;

    @UiField PaperDialogElement addItemDialog;
    @UiField PaperInputElement titleInput;
    @UiField PaperTextareaElement descriptionInput;
    @UiField PaperButtonElement confirmAddButton;

    private List<Item> items = new ArrayList<>();

    public VaadinWidget() {
        initWidget(ourUiBinder.createAndBindUi(this));

        addButton.addEventListener("click", new EventListener() {
            public void handleEvent(Event event) {
                addItemDialog.open();
            }
        });

        confirmAddButton.addEventListener("click", new EventListener() {
            public void handleEvent(Event event) {
                if (!titleInput.getValue().isEmpty()) {
                    addItem(titleInput.getValue(), descriptionInput.getValue());
                    // clear text fields
                    titleInput.setValue("");
                    descriptionInput.setValue("");
                }
            }
        });

        menuClearAll.addEventListener("click", new EventListener() {
            public void handleEvent(Event event) {
                closeMenu();
                // remove all child elements
                while (content.hasChildNodes()) {
                    content.removeChild(content.getFirstChild());
                }
            }
        });

        menuClearDone.addEventListener("click", new EventListener() {
            public void handleEvent(Event event) {
                closeMenu();

                for (Item item : items) {
                    if (item.isDone()) {
                        content.removeChild(item.getElement());
                        items.remove(item);
                    }
                }
            }
        });
    }

    private void addItem(String title, String description) {
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        content.appendChild(item.getElement());
        items.add(item);
    }

    private void closeMenu() {
        if (drawerPanel.getNarrow()) {
            drawerPanel.closeDrawer();
        }
    }



}
