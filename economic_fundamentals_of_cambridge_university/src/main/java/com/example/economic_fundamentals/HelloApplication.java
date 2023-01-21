package com.example.economic_fundamentals;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root= new Group();

        TextField city = new TextField();
        city.setLayoutX(10);
        city.setLayoutY(40);
        city.setPromptText("City");


        TextField date = new TextField();
        date.setLayoutX(10);
        date.setLayoutY(80);
        date.setPromptText("Date");

        TextField seats = new TextField();
        seats.setLayoutX(10);
        seats.setLayoutY(120);
        seats.setPromptText("Seats");

        TextField price = new TextField();
        price.setLayoutX(10);
        price.setLayoutY(160);
        price.setPromptText("Price");

        Button insertButton = new Button("Insert");
        insertButton.setLayoutX(10);
        insertButton.setLayoutY(190);
        insertButton.setStyle("-fx-background-color: RED");

        Text insertText = new Text();
        insertText.setLayoutX(10);
        insertText.setLayoutY(240);

        Button getChartButton = new Button("Get Chart");
        getChartButton.setLayoutX(90);
        getChartButton.setLayoutY(190);

        root.getChildren().add(city);
        root.getChildren().add(date);
        root.getChildren().add(seats);
        root.getChildren().add(price);
        root.getChildren().add(insertButton);
        root.getChildren().add(insertText);
        root.getChildren().add(getChartButton);

        insertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FlightUtil.createTable();

                String flightCity = city.getText();
                String flightDate = date.getText();
                int flightSeats = Integer.parseInt(seats.getText());
                int flightPrice = Integer.parseInt(price.getText());

                String result = FlightUtil.insert(new Flight(flightCity, flightDate, flightSeats, flightPrice));
                insertText.setText(result);

                city.clear();
                date.clear();
                seats.clear();
                price.clear();
            }
        });

        getChartButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                PieChart pieChart = new PieChart();
                pieChart.setData(FlightUtil.chart());
                pieChart.setLayoutX(300);
                pieChart.setStyle("-fx-background-color: #ad9d9d");
                pieChart.setLayoutY(20);
                pieChart.setTitle("Flights");
                root.getChildren().add(pieChart);
            }
        });


        Scene scene = new Scene(root, 800 , 500);
        stage.setTitle("Final_Gloveli");
        stage.setScene(scene);
        scene.setFill(Color.web("#81c483"));
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}