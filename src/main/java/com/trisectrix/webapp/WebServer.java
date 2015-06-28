package com.trisectrix.webapp;


import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
 * Created on 6/27/15.
 *
 * @author Sriharsha Gangam
 */
public class WebServer {
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("./appfiles");

        ServletContextHandler serveletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        serveletHandler.setContextPath("/");
        serveletHandler.addServlet(new ServletHolder(new InputServlet()), "/*");

        HandlerList handlers = new HandlerList() ;
        handlers.setHandlers(new Handler[] {resourceHandler, serveletHandler, new DefaultHandler() } );
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
