package singleton;

public class TestSingleton
{
    public static void main(String[] args)
    {
        //this does not work!
        //DBConnection connection = new DBConnection();

        //test access to a single object
        DBConnection connection = DBConnection.getInstance();
        System.out.println(connection);

        //test access to multiple singletons, using a multiton
        DBConnection3 mysql = DBConnection3.getInstance(DBType.MYSQL);
        DBConnection3 postgres = DBConnection3.getInstance(DBType.POSTGRES);
        DBConnection3 oracle = DBConnection3.getInstance(DBType.ORACLE);
        DBConnection3 notGood = DBConnection3.getInstance(null);

        System.out.println(mysql);
        System.out.println(postgres);
        System.out.println(oracle);
        System.out.println(notGood);
    }
}
