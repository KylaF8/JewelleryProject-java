package com.example.ca1;

import Resources.LinkedList;
import javafx.fxml.FXML;

public class DisplayCase {

    public LinkedList<DisplayTray> linkedlistTray = new LinkedList<>();  //Creates Tray linked lists

    @FXML
    public String caseID;
    public String type;
    public String lighting;


    public DisplayCase(String caseID, String type, String lighting) {
        //Defines the method for creating an object
        this.caseID = caseID;
        this.type = type;
        this.lighting = lighting;
    }

    public String getCaseID() {
        return caseID;
    }  //fetches & returns case ID

    public void setCaseID(String caseID) {
        this.caseID = caseID;
    }

    public String getType() {
        return type;
    }  //fetches & returns case type

    public void setType(String type) {
        this.type = type;
    }

    public String getLighting() {
        return lighting;
    }  //fetches & returns case lighting

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    @Override
    public String toString() {
        return
                "  " + caseID +
                "  " + type +
                "  " + lighting;
    }


}


