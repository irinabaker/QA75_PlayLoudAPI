package com.playloud.core;

import com.playloud.utils.DbData;
import com.playloud.utils.MyTestWatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ExtendWith(MyTestWatcher.class)
public class TestBase {

    protected AppManager app = new AppManager();

    public static Connection connection;
    @BeforeEach
    public void init() {
        app.start();

        try {
            //load postgres jdbc driver
            Class.forName("org.postgresql.Driver");
            //create connection to DB
            connection = DriverManager.getConnection(DbData.dbUrl, DbData.username, DbData.password);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*ssh -L 5433:localhost:5432 root@217.154.148.226

Пароль: 1uSHJcZo

Then in Beekeeper:
Field Value
Host localhost
Port 5433
Database playloud
Username queen
Password kotikspit1*/
