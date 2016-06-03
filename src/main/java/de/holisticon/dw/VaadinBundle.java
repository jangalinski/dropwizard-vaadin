package de.holisticon.dw;

import com.google.common.collect.Maps;
import io.dropwizard.Bundle;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.server.session.SessionHandler;

import javax.servlet.Servlet;
import java.util.Map;

public class VaadinBundle implements Bundle {

    private final Map<String, Class<? extends Servlet>> servlets = Maps.newLinkedHashMap();

    private final SessionHandler sessionHandler;


    public VaadinBundle(Class<? extends Servlet> servlet, String pathSpec) {
        this.sessionHandler = new SessionHandler();
        servlets.put(pathSpec, servlet);
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/VAADIN", "/VAADIN", null, "vaadin"));
    }

    @Override
    public void run(Environment environment) {
        environment.servlets().setSessionHandler(sessionHandler);
        for (Map.Entry<String, Class<? extends Servlet>> servlet : servlets.entrySet()) {
            environment.getApplicationContext().addServlet(servlet.getValue(), servlet.getKey());
        }
    }
}
