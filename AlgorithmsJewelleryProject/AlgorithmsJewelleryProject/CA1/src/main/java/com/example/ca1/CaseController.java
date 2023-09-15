package com.example.ca1;

import Resources.LinkedList;
import Resources.Node;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;

public class CaseController {
    public static LinkedList<DisplayCase> linkedlistCase = new LinkedList<>(); //linked list for D.C.

    public int valueStock = 0; //int which stores value of stock

    public ListView<String> itemStock; //Listing all items in stock

    //Case
    public TextField caseID;
    //Case ID for display case
    public ChoiceBox<String> type;
    //Decides whether wall-mounted or freestanding
    public ChoiceBox<String> lighting;
    //Picks lighting of the case
    public ListView<String> dcase;
    //Lists out all already-created display cases


    //Tray
    public TextField trayID;  //Tray name ID
    public ChoiceBox<String> inlay;   //Colour of Tray
    public TextField width;  //Tray width size
    public TextField depth;  //Tray depth size
    @FXML
    public ListView<String> dTray;  //Lists all created trays
    @FXML
    public ChoiceBox<DisplayCase> pickCase;  //Decides which case to insert it into


    //Item
    public TextField jdescription;
    //Description of item
    public ChoiceBox<String> jtype;
    //Type of item
    public ChoiceBox<String> gender;  //The gender targeted
    public TextField price;  //Item price
    public ListView<String> jitem;  //Lists all created items
    public ListView<String> value;  //Displays value of all items
    public ChoiceBox<DisplayTray> chooseTray;  //Choose which tray item put into


    //components
    public ChoiceBox<String> ctype; //The type of component
    public TextField cdescription; //Component description
    public TextField quantity;  //Quantity of item(s)
    public TextField quality;  //Quality of item
    public ListView<JewelleryComponent> listComponents;  //Lists all components
    public ChoiceBox<JewelleryItem> chooseItem;  //Choose which item it's for


    //Inputs for choice boxes
    public void initialize() {
        type.getItems().addAll("Wall-Mounted", "Freestanding");
        lighting.getItems().addAll("Lit", "Unlit");
        inlay.getItems().addAll("White", "Black", "Blue", "Green");
        gender.getItems().addAll("Female", "Male");
        ctype.getItems().addAll("Gold", "Silver", "Platinum", "Diamond", "Pearl", "Garnet");
        jtype.getItems().addAll("Ring", "Bracelet", "Watch");
    }

    //Creates displayCase with the value inputs
    @FXML
    public void addDisplayCase(ActionEvent actionEvent) {
        DisplayCase dc = new DisplayCase(caseID.getText(), type.getValue(), lighting.getValue());
        linkedlistCase.addNode(dc); //Adds display case to the linked list
        popListBox();
        pickCase.getItems().add(dc);

    }

    //Displays displayCase in list view
    public void popListBox() {
        dcase.getItems().clear();
        Node temp = linkedlistCase.getHead();  //Sets the nodeHead as temp of the case list
        while (temp != null) {
            dcase.getItems().add(temp.getData().toString());
            temp = temp.getNext();   //Continues going through the temp nodes, adds them to dcase(listView) til 0 and = null
        }
    }


    //Removes selected displayCase from list view
    public void deleteDisplayCase(ActionEvent actionEvent) {
        dcase.getItems().remove(dcase.getSelectionModel().getSelectedItem());
    }


    //Tray
    public void addDisplayTray(MouseEvent event) {
        DisplayCase dc = pickCase.getSelectionModel().getSelectedItem();  //Puts all display cases into pickCase

        DisplayTray dt = new DisplayTray(trayID.getText(), inlay.getValue(), width.getText(), depth.getText());  //Creates display tray with inputs

        dc.linkedlistTray.addNode(dt); //Adds a display tray node to display case
        dTray.getItems().clear();  //Clears the list view
        for (int i = 0; i < dc.linkedlistTray.listSize(); i++) {   //Adds trays to the linked list
            DisplayTray tray = (DisplayTray) dc.linkedlistTray.get(i);
            dTray.getItems().add(tray + "");
        }
        System.out.println(dc.linkedlistTray.getHead());
        chooseTray.getItems().add(dt);   //Puts all trays into chooseTray
        popListBoxTray();
    }


    public void popListBoxTray() {
        dTray.getItems().clear();  //Clear the list view
        //Looks through display cases find all trays and displays them in list view
        for (int i = 0; i < linkedlistCase.listSize(); i++) {
            DisplayCase Tray = (DisplayCase) linkedlistCase.get(i);
            for (int j = 0; j < Tray.linkedlistTray.listSize(); j++) {
                DisplayTray tray = (DisplayTray) Tray.linkedlistTray.get(j);
                dTray.getItems().add(tray + "");
            }
        }

    }


    //item
    public void addJewelleryItem(ActionEvent actionEvent) {
        value.getItems().clear();  //Value of all items
        DisplayTray tray = chooseTray.getSelectionModel().getSelectedItem();  //Puts all trays into chooseTray
        //Creates jewellery item w/ inputs
        JewelleryItem ji = new JewelleryItem(jdescription.getText(), jtype.getValue(), gender.getValue(), price.getText());
        int p = Integer.parseInt(ji.price);  //Takes inputs from price
        valueStock += p;  //Keeps adding price of items and sets to valueStock
        System.out.println(valueStock);
        value.getItems().add(valueStock + " ");

        tray.linkedListItem.addNode(ji);  //Adds jewellery item node to tray
        popListBoxItem();
        chooseItem.getItems().add(ji);  //Adds all jewellery items so can choose item
        System.out.println(ji);
    }

    public void popListBoxItem() {
        //Goes through displayCase -> trays -> looks for items in trays, and puts them into jewellery list
        jitem.getItems().clear();
        for (int i = 0; i < linkedlistCase.listSize(); i++) {
            DisplayCase Item = (DisplayCase) linkedlistCase.get(i);
            for (int j = 0; j < Item.linkedlistTray.listSize(); j++) {
                DisplayTray tray = (DisplayTray) Item.linkedlistTray.get(j);
                for (int k = 0; k < tray.linkedListItem.listSize(); k++){
                    JewelleryItem item = (JewelleryItem) tray.linkedListItem.get(k);
                    jitem.getItems().add(item + "");

                }

            }
        }

    }


    public void popListBoxComponents() {
        if(listComponents.getItems() != null) {listComponents.getItems().clear();}
        for (int i = 0; i < linkedlistCase.listSize(); i++) {
            DisplayCase Item = (DisplayCase) linkedlistCase.get(i);
            for (int j = 0; j < Item.linkedlistTray.listSize(); j++) {
                DisplayTray tray = (DisplayTray) Item.linkedlistTray.get(j);
                for (int k = 0; k < tray.linkedListItem.listSize(); k++){
                    JewelleryItem item = (JewelleryItem) tray.linkedListItem.get(k);
                    for (int l = 0; l < item.linkedListComponents.listSize(); l++){
                        JewelleryComponent comp = (JewelleryComponent) item.linkedListComponents.get(l);
                        System.out.println(comp);
                        listComponents.getItems().add(comp);
                        //Goes through all linked lists til components takes all
                        //Components & displays in ListView
                    }
                }
            }
        }
    }


    public void smartAdd(ActionEvent event) {
        boolean added = false;
        //Creates jewellery item w/ smartAdd
        JewelleryItem newItem = new JewelleryItem(jdescription.getText(), jtype.getValue(), gender.getValue(), price.getText());
        //Going through all linked lists looking for displayC, trays & items
        for (int i = 0; i < linkedlistCase.listSize(); i++) {
            if (!added) {
                DisplayCase Item = (DisplayCase) linkedlistCase.get(i);
                for (int j = 0; j < Item.linkedlistTray.listSize(); j++) {
                    if (!added) {
                        DisplayTray tray = (DisplayTray) Item.linkedlistTray.get(j);
                        for (int k = 0; k < tray.linkedListItem.listSize(); k++) {
                            if (!added) {
                                JewelleryItem item = (JewelleryItem) tray.linkedListItem.get(k);

                                if (item.toString().contains(newItem.jtype)) {
                                    tray.linkedListItem.addNode(newItem);
                                    added = true;
                                    //If item w/ same string found, adds new item to same tray
                                }
                            }
                        }
                    }
                }
            }
        }
        //If no items w/ selected string, then adds it to first displayCase & first tray
        if (!added) {
            DisplayCase dc = (DisplayCase) linkedlistCase.get(0);
            DisplayTray dt = (DisplayTray) dc.linkedlistTray.get(0);
            dt.linkedListItem.addNode(newItem);
        }
    }


    @FXML
    public void viewAllStock(ActionEvent event) {
        String str = "" + '\n';
        for (int i = 0; i < linkedlistCase.listSize(); i++) {
            DisplayCase dc = (DisplayCase) linkedlistCase.get(i);
            itemStock.getItems().add(dc + "");  //Puts all items from linked lists into itemStock
            for (int k = 0; k < dc.linkedlistTray.listSize();k++){
                DisplayTray dt = (DisplayTray) dc.linkedlistTray.get(k);
                itemStock.getItems().add("   " + dt);  //Puts all items from Trays into itemStock
                for (int l = 0; l < dt.linkedListItem.listSize(); l++) {
                    JewelleryItem ji = (JewelleryItem) dt.linkedListItem.get(l);
                    itemStock.getItems().add("      " + ji);  //Puts all Items into displayItems linked lists
                                                             // into itemStock
                }
            }
            itemStock.getItems().add(str);   //Puts gap btwn case & trays
        }
    }

    public void deleteItem(ActionEvent actionEvent) {
        jitem.getItems().remove(jitem.getSelectionModel().getSelectedItem());   //Removes item from listview
    }

    public  void reset(ActionEvent event){
        //Resets, so deletes all data & clears all listviews
        linkedlistCase.deleteAll();
        dcase.getItems().clear();
        dTray.getItems().clear();
        jitem.getItems().clear();
        listComponents.getItems().clear();
    }



    public void addComponent(ActionEvent actionEvent) {
        JewelleryItem item = chooseItem.getSelectionModel().getSelectedItem();  //Retrieves all jewellery items
        //Creates a Component with inputs
        JewelleryComponent jc = new JewelleryComponent(ctype.getValue(), cdescription.getText(), quantity.getText(), quality.getText());
        item.linkedListComponents.addNode(jc);  //Adds Component to linked lists
        popListBoxComponents();

    }


    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("displaycase.xml"));
        LinkedList<DisplayCase> list = linkedlistCase;
        out.writeObject(list);

        out.close();
    }


    public void load() throws Exception {
        //List of classes that you want to include in serialisation, separated by comma
        Class<?>[] classes = new Class[] { DisplayCase.class, DisplayTray.class, JewelleryItem.class, JewelleryComponent.class, LinkedList.class, Node.class };

        //Setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //Doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("displaycase.xml"));
        linkedlistCase = (LinkedList<DisplayCase>)  is.readObject();
        is.close();
        popListBox();
        popListBoxTray();
        popListBoxItem();
    }

    public void saveCase() {
        try {
            save();
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e);
        }
    }


    @FXML
    private void loadCase () {
        try {
            load();
        } catch (Exception e) {
            System.err.println("Error reading from file: " + e);
        }
    }


}
