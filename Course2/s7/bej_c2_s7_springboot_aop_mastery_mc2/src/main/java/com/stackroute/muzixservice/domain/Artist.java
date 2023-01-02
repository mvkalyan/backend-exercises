package com.stackroute.muzixservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Artist {
    /*
     * This class should have following fields
     * (artistId,artistName,url,and an object of Image
     *  Out of these fields, the field
     * artistId should be annotated with @Id. This class should also contain the
     * getters and setters for the fields along with the no-arg , parameterized
     * constructor and toString method.
     */
    @Id
    private int artistId;
    private String artistName;
    private String url;
    private Image image;




}
