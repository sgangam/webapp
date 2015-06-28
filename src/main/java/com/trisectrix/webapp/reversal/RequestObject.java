package com.trisectrix.webapp.reversal;

import javax.servlet.http.HttpServletRequest;

/**
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
