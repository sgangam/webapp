package com.trisectrix.webapp.function;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Sriharsha Gangam
 */
public class ResponseObject {

    private final double x;
    private final double y;


    public ResponseObject(@JsonProperty("x") double x,
                          @JsonProperty("y") double y) {

        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

}
