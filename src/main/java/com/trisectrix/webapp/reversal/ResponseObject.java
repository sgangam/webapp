package com.trisectrix.webapp.reversal;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Sriharsha Gangam
 */
public class ResponseObject {

    private final String reverseFirstName;
    private final String reverseLastName;


    public ResponseObject(@JsonProperty("reverseFirstName") String reverseFirstName,
                          @JsonProperty("reverseLastName") String reverseLastName) {

        this.reverseFirstName = reverseFirstName;
        this.reverseLastName = reverseLastName;
    }

    public String getReverseFirstName() {
        return reverseFirstName;
    }

    public String getReverseLastName() {
        return reverseLastName;
    }

}
