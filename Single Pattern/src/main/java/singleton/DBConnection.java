package singleton;

public class DBConnection
{
    public static final int PORT = 2020;

    private String user;
    private String pass;
    private String host;
    private int port;
    private String dbName;
    private String dbType;

    //static singleton
    private static DBConnection instance;

    //stop instantiation outside of this class...
    private DBConnection(String user, String pass, String host,
                        int port, String dbName, String dbType)
    {
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbType = dbType;
    }

    public static DBConnection getInstance()
    {
        //lazy init
        if (instance == null)
        {
            instance = new DBConnection("jarcher", "password!?",
                    "jarcher.greenrivertech.net", PORT, "movie",
                    "mysql");
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

