/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab8_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bogdan
 */
public class ReaderCSV {
    List<List<String>> data = new ArrayList<>();
    public ReaderCSV(String nameCSV) {
        String line = "";
        String separator = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(nameCSV));
            while ((line = br.readLine()) != null) 
            {
                data.add(Arrays.asList(line.split(separator)));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public List<List<String>> getDataSet() {
        return data;
    }
}
