package com.trisectrix.webapp;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 6/27/15.
 *
 * @author Sriharsha Gangam
 */
public class RequestObject {

    private String firstName;
    private String lastName;

    public RequestObject(HttpServletRequest request) {

        this.firstName = request.getParameter("firstname");
        this.lastName = request.getParameter("lastname");

        if (firstName == null) {
            firstName = "";
        }

        if (lastName == null) {
            lastName = "";
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
