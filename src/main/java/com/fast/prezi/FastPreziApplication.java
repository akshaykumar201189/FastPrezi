package com.fast.prezi;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public class FastPreziApplication extends Application<FastPreziConfiguration> {

    private GuiceBundle<FastPreziConfiguration> guiceBundle;

    @Override
    public void initialize(Bootstrap<FastPreziConfiguration> bootstrap) {
        guiceBundle = GuiceBundle.<FastPreziConfiguration>newBuilder()
                .addModule(new FastPreziModule())
                .enableAutoConfig("com.fast.prezi")
                .setConfigClass(FastPreziConfiguration.class)
                .build(Stage.DEVELOPMENT);
        bootstrap.addBundle(guiceBundle);
    }

    @Override
    public void run(FastPreziConfiguration configuration, Environment environment) throws Exception {
        environment.healthChecks().register("FastPrezi", new FastPreziHealthCheck());
        // Add CORS Filter
        FilterRegistration.Dynamic filter =environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }

    public static void main(String args[]) throws Exception {
        new FastPreziApplication().run(args);
    }
}
