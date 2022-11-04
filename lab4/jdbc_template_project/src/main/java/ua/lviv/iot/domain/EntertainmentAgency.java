package ua.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntertainmentAgency {
    private Integer id;
    private String name;
    private String contactNumber;
    private String address;
    private Integer animatorId;
    private Integer cityId;
}
