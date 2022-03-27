import java.io.IOException;
import java.io.Serializable;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        Catalog catalog = new Catalog("MyRefs", "catalog.ser");
        app.testCreateSave();
        //app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog("MyRefs", "catalog.ser");
        var book = new Item("Book1", "Romeo & Julieta ", "https://www.bibliotecapemobil.ro/content/scoala/pdf/Romeo%20si%20Julieta%20-%20Shakespeare.pdf");
        var article = new Item("Article1", "Lab5Slides", "https://profs.info.uaic.ro/~acf/java/labs/slides/lab_05.pdf");
        book.addTag("type", "PDF");
        article.addTag("type", "Slides");
        catalog.add(book);
        catalog.add(article);
        try {
            CatalogUtil.save(catalog);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(catalog + "\n");
    }

    private void testLoadView() {
        Catalog catalog = null;
        try {
            catalog = CatalogUtil.load("catalog.ser");
        } catch (InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CatalogUtil.view(catalog.findById("Article1"));

    }
}