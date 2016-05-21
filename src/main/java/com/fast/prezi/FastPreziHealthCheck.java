package com.fast.prezi;


import com.codahale.metrics.health.HealthCheck;

/**
 * Created by akshay.kesarwan on 22/05/16.
 */
public class FastPreziHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
