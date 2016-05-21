package com.fast.prezi;

import com.fast.prezi.core.configs.JsonDaoConfig;
import com.fast.prezi.core.services.impl.FastPreziServiceImpl;
import com.fast.prezi.core.services.interfaces.FastPreziService;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.Singleton;


/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public class FastPreziModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FastPreziService.class).to(FastPreziServiceImpl.class).in(Singleton.class);
    }

    @Provides
    @Singleton
    private JsonDaoConfig providesJsonDaoConfig(Provider<FastPreziConfiguration> fastPreziConfigurationProvider) {
        return fastPreziConfigurationProvider.get().getJsonDaoConfig();
    }
}
