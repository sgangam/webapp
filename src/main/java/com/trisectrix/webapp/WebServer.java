package com.trisectrix.webapp;


import com.trisectrix.webapp.function.PlotDataServlet;
import com.trisectrix.webapp.reversal.InputServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


/**
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
        serveletHandler.addServlet(new ServletHolder(new InputServlet()), "/reverse/*");

        ServletContextHandler plotservletHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        plotservletHandler.setContextPath("/");
        plotservletHandler.addServlet(new ServletHolder(new PlotDataServlet()), "/plot/*");

        HandlerCollection handlers = new HandlerCollection() ;
        handlers.setHandlers(new Handler[] {resourceHandler, serveletHandler,
                plotservletHandler, new DefaultHandler() } );
        server.setHandler(handlers);

        server.start();
        server.join();
    }
}
