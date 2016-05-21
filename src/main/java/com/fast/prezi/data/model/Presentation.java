package com.fast.prezi.data.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
@Data
@Slf4j
public class Presentation {
    private String id;
    private String title;
    private String thumbnail;
    private String createdAt;
    private Creator creator;
}
