package com.trisectrix.webapp.function;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sriharsha Gangam
 *
 */
public class PlotDataServlet extends HttpServlet {

    public PlotDataServlet(){}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        RequestObject requestObject = new RequestObject(request);

        String jsonResp = processRequest(requestObject);
        response.getWriter().println(jsonResp);
    }

    private String processRequest(RequestObject requestObject) {

        ObjectMapper om = new ObjectMapper();
        String jsonVal;
        try {
            jsonVal = om.writeValueAsString(requestObject.getDataPoints());
        } catch (IOException e) {
            e.printStackTrace();
            jsonVal = "Could not convert to json";
        }
        return jsonVal;
    }
}
