package org.mvnsearch.dbunit.ext.postgresql;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;

import java.sql.Connection;

/**
 * PostgreSQL connection for DBUnit
 *
 * @author linux_china
 */
public class PgConnection extends DatabaseConnection {

    public PgConnection(Connection connection) throws DatabaseUnitException {
        super(connection, null);
        getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlExtraDataTypeFactory());
    }

    public PgConnection(Connection connection, String schema) throws DatabaseUnitException {
        super(connection, schema);
        getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlExtraDataTypeFactory());
    }
}
