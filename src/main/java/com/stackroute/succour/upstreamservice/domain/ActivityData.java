package com.stackroute.succour.upstreamservice.domain;



import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActivityData {
    private String verb;
    private String actor;
    private String Objects;

}
