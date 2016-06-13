package de.holisticon.dw;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class VaadinApplication extends Application<Configuration> {

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {}

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(new VaadinBundle(Servlet.class, "/ui/*"));
    }

    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class Servlet extends VaadinServlet {}

    public static void main(String... args) throws Exception {
        new VaadinApplication().run(args);
    }

}
