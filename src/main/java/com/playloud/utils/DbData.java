package com.playloud.utils;

public class DbData {

    //connection URL - syntax: "jdbc:serverName://ipaddress:portNumber/dbName
    public static final String dbUrl = "jdbc:postgresql://localhost:5433/playloud";

    //DB user name
    public static final String username = "queen";

    //DB password
    public static final String password = "kotikspit1";

    //query to execute
    public static final String querySelect = "select * from \"User\"";
    public static final String queryDelete = "delete from \"User\" where \"id\"=?;";
}
