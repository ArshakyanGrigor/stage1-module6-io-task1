package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public static Profile getDataFromFile(File file) throws FileException {
        StringBuilder strBuild = new StringBuilder();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            int ch;
            while ((ch = inputStream.read()) != -1) {
                strBuild.append((char) ch);
            }
            inputStream.close();
        } catch (IOException exception) {
                throw new FileException("File does not exist", exception);
            }
        String line = strBuild.toString();
        String[] member = line.split(System.lineSeparator());
        for (int i = 0; i < member.length; i++) {
            member[i] = member[i].split(": ")[1];
        }
        String name = member[0];
        Integer age = Integer.valueOf(member[1]);
        String email = member[2];
        Long phone = Long.parseLong(member[3]);

        return new Profile(name, age, email, phone);
    }
}
