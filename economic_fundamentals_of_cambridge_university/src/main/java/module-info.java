module com.example.economic_fundamentals {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires org.testng;


    opens com.example.economic_fundamentals to javafx.fxml;
    exports com.example.economic_fundamentals;
}