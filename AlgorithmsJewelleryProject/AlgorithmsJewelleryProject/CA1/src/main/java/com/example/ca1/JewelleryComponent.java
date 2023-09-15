package com.example.ca1;

public class JewelleryComponent {
    public String ctype;
    public String cdescription;
    public String quantity;
    public String quality;


    //Defines method for creating an object
    public JewelleryComponent(String ctype, String cdescription, String quantity, String quality) {
        this.ctype = ctype;
        this.cdescription = cdescription;
        this.quantity = quantity;
        this.quality = quality;
    }

    @Override
    public String toString() {  //Returns inputs for component
        return "JewelleryComponent{" +
                " " + ctype + '\'' +
                " " + cdescription + '\'' +
                " " + quantity + '\'' +
                " " + quality + '\'' +
                '}';
    }
}
