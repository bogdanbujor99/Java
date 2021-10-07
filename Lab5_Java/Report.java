/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.lab5_java;

import static com.mycompany.lab5_java.Main.catalog;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author Bogdan
 */
public class Report extends Command{
    public Report() throws IOException, TemplateException{
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("C:/Users/Bogdan/OneDrive/Documente/NetBeansProjects/Lab5_Java/src/main/java/com/mycompany/lab5_java/Templates"));
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        
        Map<String, Object> input = new HashMap<>();
        input.put("title", "Lab 5 PA");
        input.put("catalog",catalog);
        input.put("items", catalog.getItems());
        Template template = cfg.getTemplate("nume.ftl");
        Writer fileWriter = new FileWriter(new File("report.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
    }
}
