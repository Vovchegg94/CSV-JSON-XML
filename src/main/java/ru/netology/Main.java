package ru.netology;

import com.opencsv.CSVWriter;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
            writer.writeNext("1,John,Smith,USA,25".split(","));
            writer.writeNext("2,Inav,Petrov,RU,23".split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
Converter converter=new Converter();
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = converter.parseCSV(columnMapping, fileName);
        list.forEach(System.out::println);
        String jsonList = converter.listToJson(list);
        converter.writeString("data.json", jsonList);
        List<Employee> list1 = converter.parseXML("data.xml");
        converter.writeString("xmlToJson.json", converter.listToJson(list1));

    }
}