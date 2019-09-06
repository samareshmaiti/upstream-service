package com.stackroute.succour.upstreamservice.domain;


import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ObjTwitterAPI {

    public int id;
    public String objectType;
    public String context;

    @Override
    public String toString() {
        return "ObjTwitterAPI{" +
                "id=" + id +
                ", objectType='" + objectType + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
