package org.mvnsearch.dbunit.ext.postgresql;

import org.dbunit.dataset.datatype.AbstractDataType;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.TypeCastException;
import org.postgresql.util.PGobject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * jsonb data type
 *
 * @author linux_china
 */
public class JsonbDataType extends AbstractDataType {
    public static final DataType JSONB = new JsonbDataType();

    public JsonbDataType() {
        super("jsonb", Types.OTHER, String.class, false);
    }

    @Override
    public Object typeCast(Object value) throws TypeCastException {
        if (value == null) {
            return null;
        } else {
            return value.toString();
        }
    }

    @Override
    public Object getSqlValue(int column, ResultSet resultSet) throws SQLException, TypeCastException {
        return resultSet.getString(column);
    }

    @Override
    public void setSqlValue(Object value, int column, PreparedStatement statement) throws SQLException, TypeCastException {
        PGobject pgObject = new PGobject();
        pgObject.setType("jsonb");
        if (value == null) {
            pgObject.setValue(null);
        } else {
            pgObject.setValue(value.toString());
        }
        statement.setObject(column, pgObject);
    }
}
