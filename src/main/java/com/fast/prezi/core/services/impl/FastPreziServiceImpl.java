package com.fast.prezi.core.services.impl;

import com.fast.prezi.core.services.interfaces.FastPreziService;
import com.fast.prezi.data.dao.interfaces.PresentationDao;
import com.fast.prezi.data.model.Presentation;
import com.google.inject.Inject;

import java.util.List;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public class FastPreziServiceImpl implements FastPreziService {
    private final PresentationDao presentationDao;
    private final Integer DEFAULT_PAGE_SIZE = 20;
    private final Integer DEFAULT_PAGE_NUMBER = 0;

    @Inject
    FastPreziServiceImpl(PresentationDao presentationDao) {
        this.presentationDao = presentationDao;
    }

    @Override
    public List<Presentation> getPresentations(Integer pageNumber, Integer pageSize) {
        pageNumber = pageNumber!=null?pageNumber:DEFAULT_PAGE_NUMBER;
        pageSize = pageSize!=null?pageSize:DEFAULT_PAGE_SIZE;
        return presentationDao.getPresentations(pageNumber, pageSize);
    }

    @Override
    public List<Presentation> getSortedPresentations(Integer pageNumber, Integer pageSize) {
        pageNumber = pageNumber!=null?pageNumber:DEFAULT_PAGE_NUMBER;
        pageSize = pageSize!=null?pageSize:DEFAULT_PAGE_SIZE;
        return presentationDao.getSortedPresentations(pageNumber, pageSize);
    }

    @Override
    public List<Presentation> searchPresentations(String titleRegex, Integer pageNumber, Integer pageSize) {
        pageNumber = pageNumber!=null?pageNumber:DEFAULT_PAGE_NUMBER;
        pageSize = pageSize!=null?pageSize:DEFAULT_PAGE_SIZE;
        return presentationDao.searchPresentations(titleRegex, pageNumber, pageSize);
    }
}
