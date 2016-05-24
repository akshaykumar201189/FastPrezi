package com.fast.prezi;

import com.fast.prezi.core.configs.JsonDaoConfig;
import com.fast.prezi.core.services.impl.FastPreziServiceImpl;
import com.fast.prezi.core.services.interfaces.FastPreziService;
import com.fast.prezi.core.utils.PresentationUtils;
import com.fast.prezi.data.dao.impl.JsonFileBasedPresentationDaoImpl;
import com.fast.prezi.data.dao.interfaces.PresentationDao;
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
        // Add other implementation of PresentationDao when db based implementation is there
        bind(PresentationDao.class).to(JsonFileBasedPresentationDaoImpl.class);
        bind(PresentationUtils.class);
    }

    @Provides
    @Singleton
    private JsonDaoConfig providesJsonDaoConfig(Provider<FastPreziConfiguration> fastPreziConfigurationProvider) {
        return fastPreziConfigurationProvider.get().getJsonDaoConfig();
    }
}
