package net.hyocean.hyoceanhub.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("all")
public class MySQL {

    GetConfig config = new GetConfig();

    private String host = config.main().getString("Host");
    private String port = config.main().getString("Port");
    private String database = config.main().getString("DataBase");
    private String username = config.main().getString("UserName");
    private String password = config.main().getString("Password");

    private Connection connection;

    public boolean isConnected() {
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if(!isConnected()){
            Class.forName("com.mysql.cj.jdbc.Driver");



            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database,
                    username, password);
        }
    }

    public void disconnect() {
        if(isConnected()){
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Connection getconnection() {
        return connection;
    }

}