package com.mycompany.secondaryfunction;

import com.mycompany.model.User;
import org.thymeleaf.util.StringUtils;

import java.io.*;

public class Secondary {

    public static void UploadData(User user){
        try(FileWriter writer = new FileWriter("f1.txt", true))
        {

            String text = user.toString();
            writer.write(text);

            writer.append('\n');


            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public static boolean validationFields(User user){
        String validationContent = user.getSurname();
        int index = validationContent.indexOf(" ");

        String regex = "\\d+";
        String validationId = user.getAge();
        boolean digit = validationId.matches(regex);

        if(index>=0 || digit==false)
            return false;
        else
            return true;
    }

    public static String requestNameSurname(String fileName, String surnamefind, String namefind){
        try(FileReader fileReader = new FileReader("f1.txt"))
        {
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null) {
                String surname = StringUtils.substringBefore(line, ",");

                String name = line;
                int indexStart = name.indexOf(",");
                int indexEnd = name.indexOf(",", indexStart+1);
                char[] mass = new char[20];
                name.getChars(indexStart+2,indexEnd, mass, 0);
                name="";
                int size = indexEnd-indexStart-2;
                for(int i=0; i<size; i++){
                    name+=mass[i];
                }

                if(surname.equals(surnamefind) && name.equals(namefind))
                    //String session = testSessionListener();
                    return line;
                line = reader.readLine();
            }
            return "Not-found";

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return "error";
        }
    }

public static void writeFromF2inF1(){
    try {
        FileReader f2Reader = new FileReader("f2.txt");
        FileWriter f1Writer = new FileWriter("f1.txt", true);

        BufferedReader reader = new BufferedReader(f2Reader);
        String line = reader.readLine();

        while (line != null) {
            f1Writer.write(line);
            line = reader.readLine();
            f1Writer.append('\n');
        }
        f1Writer.flush();
        f2Reader.close();
        File file = new File("f2.txt");
        file.delete();

    } catch (IOException ioException) {
        ioException.printStackTrace();
    }

}

}
