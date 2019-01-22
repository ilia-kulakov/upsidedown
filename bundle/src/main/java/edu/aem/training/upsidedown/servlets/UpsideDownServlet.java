package edu.aem.training.upsidedown.servlets;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.sling.api.resource.Resource;
import com.day.image.Layer;

@SlingServlet(resourceTypes =  {"sling/servlet/default"},
    selectors = "ud", extensions={"jpg", "jpeg", "png"})
public class UpsideDownServlet extends SlingSafeMethodsServlet {

    private final double ROTATE_DEGREE = 180.0d;

    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        // Rotate image
        response.setStatus(HttpServletResponse.SC_OK);

        String imgResourcePath = request.getResource().getPath().replaceAll("\\.ud\\.", "\\.");
        Resource imgResource = request.getResourceResolver().resolve(imgResourcePath);

        Asset asset = imgResource.adaptTo(Asset.class);
        Rendition original = asset.getOriginal();
        Layer layer = new Layer(original.getStream());
        layer.rotate(ROTATE_DEGREE);
        layer.write(layer.getMimeType(), 1.0, response.getOutputStream());

        response.flushBuffer();

    }
}