import Elements.Manager;
import Entity.CountryEntity;
import Repositories.CountryRepositories;


public class Main {
    public static void main(String[] args) {
        Manager.init();

        CountryRepositories.createCountry(new CountryEntity(1,"Romania"));
        Manager.end();
    }
}
