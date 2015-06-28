package com.trisectrix.webapp;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sriharsha Gangam
 *
 */
public class InputServlet extends HttpServlet {

    public InputServlet(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        RequestObject requestObject = new RequestObject(request);
        String jsonResp = processRequest(requestObject);
        response.getWriter().println(jsonResp);
    }

    private String processRequest(RequestObject requestObject) {

         String fname = requestObject.getFirstName();
         String lname = requestObject.getLastName();
         ResponseObject responseObject = new ResponseObject(
                 new StringBuilder(fname).reverse().toString(),
                 new StringBuilder(lname).reverse().toString());

        ObjectMapper om = new ObjectMapper();
        String jsonVal;
        try {
            jsonVal = om.writeValueAsString(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
            jsonVal = "Could not convert to json";
        }
        return jsonVal;
    }
}
