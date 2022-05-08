public class SingletonTest {
    private static final SingletonTest instance;

    //Private constructor to prevent instantiation of the class from other classes.
    SingletonTest(){}

    //Static block initialization
    static{
        try{
            instance = new SingletonTest();
        }catch(Exception e){
            throw new RuntimeException("Exception occured.");
        }
    }

    public static SingletonTest getInstance(){
        return instance;
    }

    public void create(String s, int id, String s1, String s2, String s3, String s4) {
    }
}
