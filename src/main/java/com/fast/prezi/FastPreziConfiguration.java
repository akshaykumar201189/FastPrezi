package com.fast.prezi;

import com.fast.prezi.core.configs.JsonDaoConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FastPreziConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty
    public JsonDaoConfig jsonDaoConfig;

    @Valid
    @NotNull
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
}
