package edu.aem.training.upsidedown.servlets;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SlingServlet(resourceTypes =  {"sling/servlet/default"},
    selectors = "hola")
public class UpsideDownServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.write("<p>Upside-Down!!!</p>");
        writer.flush();
        writer.close();
    }
}
