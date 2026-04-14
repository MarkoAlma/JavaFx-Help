module com.example.kigyokfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kigyokfx to javafx.fxml;
    exports com.example.kigyokfx;
}