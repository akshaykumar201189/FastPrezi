package com.fast.prezi.core.services.impl;

import com.fast.prezi.core.configs.JsonDaoConfig;
import com.fast.prezi.core.services.interfaces.FastPreziService;
import com.google.inject.Inject;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public class FastPreziServiceImpl implements FastPreziService {
    private final JsonDaoConfig jsonDaoConfig;

    @Inject
    FastPreziServiceImpl(JsonDaoConfig jsonDaoConfig) {
        this.jsonDaoConfig = jsonDaoConfig;
    }
}
