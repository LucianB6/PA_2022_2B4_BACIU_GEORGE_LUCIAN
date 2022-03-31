package Homework;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException, ClassNotFoundException, IncorrectNameException {
        Catalog catalog = new Catalog("","");
        String type, name = null, path = null;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Catalog name: ");
        catalog.setName(myObj.nextLine());
        System.out.println("Write commands for options: ");
        while (true){
            String command = myObj.nextLine();
            String[] arguments = command.split(" ");;
            try{
                if (arguments.length > 1)
                    throw new IncorrectNameException("Not a valid command");
                switch (arguments[0].toLowerCase()){
                    case "add" -> {
                        System.out.println("Enter a type: book, article");
                        type = myObj.nextLine();
                        System.out.println("Enter a name:");
                        name = myObj.nextLine();
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try{
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");

                        } catch (IncorrectPathException e) {
                            e.printStackTrace();
                            break;
                        }
                        switch (type.toLowerCase()) {
                            case "book" -> {
                                Item book = new Book(name, path);
                                AddCommand.add(catalog, book);
                            }
                            case "article" -> {
                                Item article = new Article(name, path);
                                AddCommand.add(catalog, article);
                            }
                            default -> throw new IncorrectNameException("Not a valid name");
                        }
                        System.out.println("Item succesfully added");
                    }
                    case "commands" ->{
                        System.out.println("The list of commands:\n");
                        System.out.println("add");
                        System.out.println("list");
                        System.out.println("save");
                        System.out.println("view");
                        System.out.println("quit");
                        System.out.println("report");
                    }
                    case "quit" -> {
                        System.out.println("GOODBYE!");
                        System.exit(0);
                    }
                    case "list" -> {
                        System.out.println("List of the catalog: ");
                        ListCommand.list(catalog);
                        System.out.println("Write another command!");
                    }
                    case "report" -> {
                        System.out.println("Write another command!");
                    }
                    case "view" -> {
                        System.out.println("Enter the id: ");
                        Integer key = myObj.nextInt();
                        ViewCommand.view(catalog, key);
                        System.out.println("Viewing");
                    }
                    case "load" -> {
                        System.out.println("Enter the path: ");
                        path = myObj.nextLine();
                        try{
                            File file = new File(path);
                            if(!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                            catalog = LoadCommand.load(path);
                        } catch (IncorrectPathException e) {
                            e.printStackTrace();
                        }
                    }
                    case "save" -> {
                        System.out.println("Enter a path: ");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                            SaveCommand.save(catalog, path);
                        } catch (IncorrectPathException e){
                            System.out.println(e.getMessage());
                        }
                        System.out.println("Write another commend: ");
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + arguments[0].toLowerCase());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


