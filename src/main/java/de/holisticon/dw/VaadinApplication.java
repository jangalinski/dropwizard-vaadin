package de.holisticon.dw;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import io.dropwizard.Application;
import io.dropwizard.Bundle;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.server.session.SessionHandler;

public class VaadinApplication extends Application<VaadinApplication.Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        // empty
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new VaadinBundle(Servlet.class, "/foo/*"));
    }

    public static class Configuration extends io.dropwizard.Configuration {
        public String name;
    }

    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class Servlet extends VaadinServlet {
        // empty
    }

    public static void main(String... args) throws Exception {
        new VaadinApplication().run(args);
    }
}
