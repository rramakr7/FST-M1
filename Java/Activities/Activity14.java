package activities;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


import static org.apache.commons.io.FileUtils.*;

public class Activity14 {

    public static void main(String[] args) throws IOException {
        try {
            //create a new text file in the path specified.
            File file = new File("C:/Users/04877F744/IdeaProjects/newfile.txt");
            boolean fStatus = file.createNewFile();
            if (fStatus)
                System.out.println("File created successfully");
            else
                System.out.println("File already exists in the specified path");

            //Get the file object
            File fileutil = getFile("C:/Users/04877F744/IdeaProjects/newfile.txt");
            FileUtils.write(fileutil,"This is a test file", "UTF8");
            //Read file
            System.out.println("Data in file: " + readFileToString(fileutil, "UTF8"));

            //Create directory
            File destDir = new File("resources");
            //Copy file to directory
            copyFileToDirectory(file, destDir);

            //Get file from new directory
            File newFile = getFile(destDir, "newfile.txt");
            //Read data from file
            String newFileData = readFileToString(newFile, "UTF8");
            //Print it
            System.out.println("Data in new file: " + newFileData);
        }catch(IOException excep){
            System.out.println(excep.getMessage());
        }
    }
}
