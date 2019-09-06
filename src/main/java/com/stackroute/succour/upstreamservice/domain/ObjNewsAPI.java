package com.stackroute.succour.upstreamservice.domain;


import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ObjNewsAPI {

    public String objectType;
    public String content;

    @Override
    public String toString() {
        return "ObjNewsAPI{" +
                "objectType='" + objectType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
