package ua.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
    private Integer id;
    private String name;
    private Integer animatorsNum;
    private Integer visitorsNum;
    private String date;
    private String address;
    private Integer durationInHours;
    private Integer cityId;
}
