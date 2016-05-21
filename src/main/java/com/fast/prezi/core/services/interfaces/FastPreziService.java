package com.fast.prezi.core.services.interfaces;

import com.fast.prezi.data.model.Presentation;

import java.util.List;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public interface FastPreziService {
    /**
     * Get all the presentations with pagination support
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Presentation> getPresentations(Integer pageNumber, Integer pageSize);

    /**
     * Get all the presentations with pagination support sorted by createdAt
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Presentation> getSortedPresentations(Integer pageNumber, Integer pageSize);

    /**
     * Searches the presentations whose title matches regex
     * @param titleRegex
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Presentation> searchPresentations(String titleRegex, Integer pageNumber, Integer pageSize);
}
