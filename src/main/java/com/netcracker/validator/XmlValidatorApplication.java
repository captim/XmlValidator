package com.netcracker.validator;

import com.netcracker.validator.pojo.Group;
import com.netcracker.validator.pojo.Student;
import com.netcracker.validator.pojo.Subject;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Scanner;

public class XmlValidatorApplication {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        /*Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String output = scanner.next();
        if (!input.endsWith(".xml")) {
            input += ".xml";
        }
        if (!output.endsWith(".xml")) {
            output += ".xml";
        }
        */
        String input = "group.xml";
        String output = "newGroup.xml";
        validateXmlDoc(input);
        Group group = readData(input);
        correctionData(group);
        writeData(output, group);
    }
    public static Group readData(String input) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Group.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        File file = new File("group.xml");
        return (Group) unmarshaller.unmarshal(file);

    }
    public static void correctionData(Group group) {
        for (Student student: group.getStudents()) {
            float newAverage = 0;
            for (Subject subject: student.getSubjects()) {
                newAverage += subject.getMark();
            }
            newAverage /= student.getSubjects().size();
            if (Math.abs(newAverage - student.getAverage()) >= 0.1) {
                student.setAverage(newAverage);
            }
        }
    }
    public static void writeData(String output, Object object) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Group.class);
        Marshaller marshaller = context.createMarshaller();
        File out = new File(output);
        marshaller.marshal(object, out);
    }
    public static void validateXmlDoc(String fileName) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

            docFactory.setValidating(true);
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document document = builder.parse(fileName);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

}
