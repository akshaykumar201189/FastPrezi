package com.fast.prezi.data.dao.interfaces;

import com.fast.prezi.data.model.Presentation;

import java.util.List;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public interface PresentationDao {
    List<Presentation> getPresentations(int pageNumber, int pageSize);
    List<Presentation> getSortedPresentations(int pageNumber, int pageSize);
    List<Presentation> searchPresentations(String titleRegex, int pageNumber, int pageSize);
}
