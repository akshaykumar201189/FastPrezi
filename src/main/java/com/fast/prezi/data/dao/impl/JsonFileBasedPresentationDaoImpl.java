package com.fast.prezi.data.dao.impl;

import com.fast.prezi.core.configs.JsonDaoConfig;
import com.fast.prezi.core.utils.CommonUtils;
import com.fast.prezi.core.utils.PresentationUtils;
import com.fast.prezi.data.dao.interfaces.PresentationDao;
import com.fast.prezi.data.model.Presentation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
@Slf4j
public class JsonFileBasedPresentationDaoImpl implements PresentationDao {

    private final JsonDaoConfig jsonDaoConfig;
    private List<Presentation> presentations;
    private List<Presentation> sortedPresentations;

    @Inject
    public JsonFileBasedPresentationDaoImpl(JsonDaoConfig jsonDaoConfig) {
        this.jsonDaoConfig = jsonDaoConfig;

        // Load presentations data from json file
        String fileName = jsonDaoConfig.getFileName();
        String jsonStr = CommonUtils.getFile(fileName);
        Type listType = new TypeToken<List<Presentation>>() {}.getType();
        presentations = new Gson().fromJson(jsonStr, listType);
        log.info("Loaded " + presentations.size() + " presentations");

        // Sort presentations data
        sortedPresentations = new ArrayList<>(presentations);
        PresentationUtils.sortPresentationsByCreatedAt(sortedPresentations);
    }

    public List<Presentation> getPresentations(int pageNumber, int pageSize) {
        return limit(presentations, pageNumber, pageSize);
    }

    public List<Presentation> getSortedPresentations(int pageNumber, int pageSize) {
        return limit(sortedPresentations, pageNumber, pageSize);
    }

    public List<Presentation> searchPresentations(String titleRegex, int pageNumber, int pageSize) {
        List<Presentation> presentations = new ArrayList<>();
        for(Presentation presentation : sortedPresentations) {
            String title = presentation.getTitle();
            if(title!=null && title.contains(titleRegex))
                presentations.add(presentation);
        }
        return limit(presentations, pageNumber, pageSize);
    }

    private List<Presentation> limit(List<Presentation> presentations, int pageNumber, int pageSize) {
        int startIndex = pageNumber*pageSize;
        if(startIndex > presentations.size()) {
            log.info("Range is exceeding limits");
            return Collections.emptyList();
        }
        int endIndex = Math.min((pageNumber+1)*pageSize, presentations.size());
        return presentations.subList(startIndex, endIndex);
    }
}
