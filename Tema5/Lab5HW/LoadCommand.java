package Homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadCommand extends Command {
    public LoadCommand(String command, Catalog catalog){
        super(command, catalog);
    }
    public static Catalog load(String path){
        Catalog catalog = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            catalog = (Catalog) in.readObject();
            in.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }
}
