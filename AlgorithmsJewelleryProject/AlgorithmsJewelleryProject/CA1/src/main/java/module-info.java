module com.example.ca1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires xstream;


    opens com.example.ca1 to javafx.fxml, xstream;
    exports com.example.ca1;
    exports Resources;
    opens Resources to javafx.fxml, xstream;

}