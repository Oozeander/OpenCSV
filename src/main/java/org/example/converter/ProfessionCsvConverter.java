package org.example.converter;

import com.opencsv.bean.AbstractBeanField;
import org.example.model.Profession;

import java.util.Arrays;
import java.util.List;

public class ProfessionCsvConverter extends AbstractBeanField {

    @Override
    protected Object convert(String s) {
        var profession = new Profession();
        List<String> split = Arrays.stream(s.split(";")).toList();
        profession.setTitle(split.get(0));
        profession.setSalary(Integer.parseInt(split.get(1)));
        return profession;
    }

    @Override
    protected String convertToWrite(Object value) {
        var profession = (Profession) value;
        return String.format("%s;%s", profession.getTitle(), profession.getSalary());
    }
}
