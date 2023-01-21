package com.example.economic_fundamentals;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight {
    private String city;
    private String date;
    private int seats;
    private int price;


}
