package de.neuefische.covidapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActiveCases {

    String province;
    String date;
    int active;


}
