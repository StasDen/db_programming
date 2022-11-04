package ua.lviv.iot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartyAnimator {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String uniquePerformance;
    private Integer workExperienceInYears;
    private Integer orderId;
}
