module com.example.parserforxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parserforxml to javafx.fxml;
    exports com.example.parserforxml;
}