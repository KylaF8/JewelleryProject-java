package com.example.ca1;

import Resources.LinkedList;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DisplayTray {
    public String trayID;
    public String inlay;
    public String width;
    public String depth;

    //Creates linked list for Items
    public LinkedList<JewelleryItem> linkedListItem = new LinkedList<>();


    //Defines method for making an object
    public DisplayTray(String trayID, String inlay, String width, String depth) {
        this.trayID = trayID;
        this.inlay = inlay;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public String toString() {  //Returns inputs for tray
        return
                "  " + trayID + '\'' +
                "  " + inlay + '\'' +
                " " + width + '\'' +
                " " + depth + '\'' +
                '}';
    }
}
