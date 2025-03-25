package org.mvnsearch.dbunit.ext.postgresql;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

public class PgDataTypeTest {

    @Test
    public void testDataTypes() throws Exception {
        DatabaseConnection connection = new PgConnection(getConnection(), "public");
        FlatDtdDataSet.write(connection.createDataSet(), Files.newOutputStream(Paths.get("database.dtd")));
    }

    @Test
    public void testDataTypes2() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:25432/demo", "postgres", "123456");
        final IDatabaseConnection connection = databaseTester.getConnection();
        connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlExtraDataTypeFactory());
    }

    public Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:25432/demo", "postgres", "123456");
    }

    @Test
    public void testDatasetDump() throws Exception {
        DatabaseConnection connection = new PgConnection(getConnection(), "public");
        FlatXmlDataSet.write(connection.createDataSet(new String[]{"item"}), Files.newOutputStream(Paths.get("dataset.xml")));
    }

}
