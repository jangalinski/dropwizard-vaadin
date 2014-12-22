package de.holisticon.dw;


import io.dropwizard.testing.ResourceHelpers;

public class VaadinApplicationStarter {


    public static void main(String... args) throws Exception {
        VaadinApplication.main("server", ResourceHelpers.resourceFilePath("dummy.yaml"));
    }
}