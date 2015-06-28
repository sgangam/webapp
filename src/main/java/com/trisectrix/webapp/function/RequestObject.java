package com.trisectrix.webapp.function;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sriharsha Gangam
 */
public class RequestObject {

    private final int startx;
    private final int endx;
    private final String function;

    public RequestObject(HttpServletRequest request) {
        int endx1 = 0;
        int startx1 = 0;
        try {
            startx1 = Integer.parseInt(request.getParameter("startx"));
            endx1 = Integer.parseInt(request.getParameter("endx"));
        } catch (NumberFormatException e) { }
        this.endx = endx1;
        this.startx = startx1;
        this.function = request.getParameter("function");
    }

    public List<ResponseObject> getDataPoints() {
        List<ResponseObject> list = new ArrayList<ResponseObject>();
        for (int x = this.startx; x < this.endx; x++) {
            double y = getValue(x);
            list.add(new ResponseObject(x, y));
        }
        return list;
    }

    private double getValue(double x) {
        if ("linear".equals(this.function)) {
            return -1 * x;
        } else if ("quadratic".equals(this.function)) {
            return x * x;
        } else if ("multiInverse".equals(this.function)) {
            return 1/x;
        } else {
            return 0;
        }
    }

}
