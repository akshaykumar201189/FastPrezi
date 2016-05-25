package com.fast.prezi.controllers;

import com.fast.prezi.core.services.interfaces.FastPreziService;
import com.fast.prezi.data.model.Presentation;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
@Path("/presentations")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
@Api(value = "/presentations", description = "Presentations APIs")
public class PresentationController {

    private FastPreziService fastPreziService;

    @Inject
    public PresentationController(FastPreziService fastPreziService) {
        this.fastPreziService = fastPreziService;
    }

    @GET
    @Path("/")
    @ApiOperation(value = "Get Presentations", response = Presentation.class, responseContainer = "List")
    public Response getAllPresentations(@QueryParam("page_number") Integer pageNumber, @QueryParam("page_size") Integer pageSize, @QueryParam("sort") Boolean sort) {
        try {
            List<Presentation> presentations = fastPreziService.getPresentations(pageNumber, pageSize, sort);
            return Response.status(Response.Status.OK).entity(presentations).build();
        } catch (Exception e) {
            log.error("Error in getting Presentations");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/search")
    @ApiOperation(value = "Search Presentations", response = Presentation.class, responseContainer = "List")
    public Response searchPresentations(@QueryParam("title") String title, @QueryParam("page_number") Integer pageNumber,
                                        @QueryParam("page_size") Integer pageSize, @QueryParam("sort") Boolean sort) {
        try {
            List<Presentation> presentations = fastPreziService.searchPresentations(title, pageNumber, pageSize, sort);
            return Response.status(Response.Status.OK).entity(presentations).build();
        } catch (Exception e) {
            log.error("Error in searching Presentations");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
