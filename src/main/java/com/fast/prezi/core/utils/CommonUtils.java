package com.fast.prezi.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by akshay.kesarwan on 22/05/16.
 */
@Slf4j
public class CommonUtils {

    /**
     * Reads file in resource folder and returns the content in String
     * @param fileName
     * @return
     */
    public static String getFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        ClassLoader classLoader = CommonUtils.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            log.error("Error in reading file : "+ fileName);
        }
        return result.toString();
    }
}
