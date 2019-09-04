package com.stackroute.succour.upstreamservice.domain;


import com.ibm.common.activitystreams.Activity;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActivityData {
    private Activity verb;
    private Activity actor;
    private Activity object;

}
