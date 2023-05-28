package com.solvd.hw.wordcounter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.*;
import org.apache.commons.lang3.StringUtils;

public class WordCounter 
{
    private static final String PATH = "solvd/words.txt";
    public static void main(String[] args)
    {
        Logger logger = LogManager.getLogger("Main");
        File toRead = FileUtils.getFile(PATH);

        try
        {
            String contents = FileUtils.readFileToString(toRead, StandardCharsets.UTF_8);
            String[] allWords = StringUtils.split(contents, "[^a-zA-Z0-9']");
            Set<String> uniqueWords = new HashSet<String>();

            
            for (String word : allWords) 
            {
                uniqueWords.add(word);
            }


            String toAdd = "Unique words: " + uniqueWords.size() + "\n";

            logger.info(toAdd);
            FileUtils.writeStringToFile(toRead, toAdd, StandardCharsets.UTF_8, true);

        }

        catch (IOException ioe)
        {
            logger.error(ioe.getMessage());
        }

    }
}
