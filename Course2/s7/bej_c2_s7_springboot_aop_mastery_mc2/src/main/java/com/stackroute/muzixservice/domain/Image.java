package com.stackroute.muzixservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image {

    /*
     * This class should have following fields
     * (imageId,imageUrl,imageSpec,
     *  Out of these fields, the field
     * imageId should be annotated with @Id. This class should also contain the
     * getters and setters for the fields along with the no-arg , parameterized
     * constructor and toString method.
     */
    @Id
    private int imageId;
    private String imageUrl;
    private String imageSpec;



}
