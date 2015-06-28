package com.trisectrix.webapp;


import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created on 6/27/15.
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
