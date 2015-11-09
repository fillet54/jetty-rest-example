package com.fiftycuatro.jetty;

import java.util.Arrays;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class MainServer 
{
    public static void main(String[] args) throws Exception {
        final ResourceConfig application = new ResourceConfig()
            .register(com.fiftycuatro.jetty.rest.v1.EntryPointImpl.class)
            .register(JacksonFeature.class);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
 
        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        DefaultServlet defaultServlet = new DefaultServlet();
        ServletHolder resourceServlet = new ServletHolder("default", defaultServlet);

        String webclientPath = "";
        if (Arrays.asList(args).contains("--webclientDev")) {
            webclientPath = "./src/main/resources/com/fiftycuatro/webclient";
        } else {
            webclientPath = MainServer.class.getResource( "/com/fiftycuatro/webclient" ).toExternalForm();
        }
        resourceServlet.setInitParameter("resourceBase", webclientPath);
        


        ServletHolder jerseyServlet = new ServletHolder(new  
             org.glassfish.jersey.servlet.ServletContainer(application));
        jerseyServlet.setInitOrder(0);

        context.addServlet(resourceServlet, "/*");
        context.addServlet(jerseyServlet, "/test/*");

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
