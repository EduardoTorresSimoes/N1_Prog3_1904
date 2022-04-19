module com.example.n1_prog3_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.n1_prog3_javafx to javafx.fxml;
    exports com.example.n1_prog3_javafx;
    exports com.example.n1_prog3_javafx.gui;
    opens com.example.n1_prog3_javafx.gui to javafx.fxml;
}