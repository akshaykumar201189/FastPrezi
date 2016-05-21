package com.fast.prezi;

import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

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
    }

    public static void main(String args[]) throws Exception {
        new FastPreziApplication().run(args);
    }
}
