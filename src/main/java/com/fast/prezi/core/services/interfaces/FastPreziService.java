package com.fast.prezi.core.services.interfaces;

import com.fast.prezi.data.model.Presentation;

import java.util.List;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public interface FastPreziService {
    List<Presentation> getPresentations(Integer pageNumber, Integer pageSize);
    List<Presentation> getSortedPresentations(Integer pageNumber, Integer pageSize);
    List<Presentation> searchPresentations(String titleRegex, Integer pageNumber, Integer pageSize);
}
