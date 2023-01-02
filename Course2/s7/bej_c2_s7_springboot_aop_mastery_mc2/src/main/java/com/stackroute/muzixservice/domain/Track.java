package com.stackroute.muzixservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Please note that this class is annotated with @Document annotation
 * @Document identifies a domain object to be persisted to MongoDB.
 *  */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Track {

    /*
     * This class should have following fields
     * (trackId,trackName,comments,trackListeners,trackUrl,and an object of Artist
     *  Out of these fields, the field
     * trackId should be annotated with @Id. This class should also contain the
     * getters and setters for the fields along with the no-arg , parameterized
     * constructor and toString method.
     */
    @Id
    private String trackId;
    private String trackName;
    private String comments;
    private String trackListeners;
    private String trackUrl;
    private Artist artist;




}
