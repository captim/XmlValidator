package com.netcracker.validator;

import com.netcracker.validator.pojo.Group;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlValidatorApplication {

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Group.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        File file = new File("group.xml");
        Group group = (Group) unmarshaller.unmarshal(file);
        System.out.println(group);
    }

}
