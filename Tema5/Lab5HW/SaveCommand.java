package Homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveCommand extends Command {
    public SaveCommand(String command, Catalog catalog){
        super(command,catalog);
    }
    public static void save(Catalog catalog, String path){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(catalog);
            out.close();
            fileOutputStream.close();
            System.out.printf("Catalog data is saved in %s\n", path);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
