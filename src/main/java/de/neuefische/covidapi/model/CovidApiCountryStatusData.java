package de.neuefische.covidapi.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidApiCountryStatusData {

    @JsonProperty("Province")
    private String province;
    @JsonProperty("Confirmed")
    private int confirmed;
    @JsonProperty("Deaths")
    private int deaths;
    @JsonProperty("Recovered")
    private int recovered;
    @JsonProperty("Active")
    private int active;
    @JsonProperty("Date")
    private String date;

}
