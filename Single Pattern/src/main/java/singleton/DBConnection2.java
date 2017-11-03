package singleton;

public class DBConnection2
{
    public static final int PORT = 2020;

    private String user;
    private String pass;
    private String host;
    private int port;
    private String dbName;
    private String dbType;

    //static singleton
    private static DBConnection2 instance;

    //stop instantiation outside of this class...
    private DBConnection2(String user, String pass, String host,
                         int port, String dbName, String dbType)
    {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbType = dbType;
    }

    //the double checked locking pattern (avoid this)
    //instead use synchronization on the entire method
    public static DBConnection2 getInstance()
    {
        if (instance == null)
        {
            synchronized(DBConnection2.class)
            {
                if (instance == null)
                {
                    instance = new DBConnection2("jarcher", "password!?",
                            "jarcher.greenrivertech.net", PORT, "movie",
                            "mysql");
                }
            }
        }

        return instance;
    }

    @Override
    public String toString()
    {
        return "DBConnection{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", dbName='" + dbName + '\'' +
                ", dbType='" + dbType + '\'' +
                '}';
    }

    public boolean connect()
    {
        //do something
        return false;
    }
}
