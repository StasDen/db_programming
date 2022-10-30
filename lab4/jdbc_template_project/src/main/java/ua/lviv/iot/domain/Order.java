package ua.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private Integer id;
    private String name;
    private Integer costInUsd;
    private Integer eventId;
    private Integer discountId;
    private Integer clientId;
    private Integer entertainmentAgencyId;
}
