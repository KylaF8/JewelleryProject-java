package com.example.ca1;

import Resources.LinkedList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class JewelleryItem {
    public String jdescription;
    public String jtype;
    public String gender;
    public String price;

    //Creates linked list for components
    public LinkedList<JewelleryComponent> linkedListComponents = new LinkedList<>();


    //Defines method for creating an object
    public JewelleryItem(String jdescription, String jtype, String gender, String price) {
        this.jdescription = jdescription;
        this.jtype = jtype;
        this.gender = gender;
        this.price = price;
    }

    @Override
    public String toString() {
        return "JewelleryItem{" +
                " " + jdescription + '\'' +
                " " + jtype + '\'' +
                " " + gender + '\'' +
                " " + price + '\'' +
                '}';
    }
}
