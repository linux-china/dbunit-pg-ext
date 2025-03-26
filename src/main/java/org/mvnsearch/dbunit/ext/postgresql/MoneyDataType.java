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
 * json data type
 *
 * @author linux_china
 */
public class MoneyDataType extends AbstractDataType {
    public static final DataType MONEY = new MoneyDataType();

    public MoneyDataType() {
        super("money", Types.OTHER, Double.class, true);
    }

    @Override
    public Object typeCast(Object value) throws TypeCastException {
        if (value == null) {
            return null;
        } else if (value instanceof Double || value instanceof Float) {
            return value;
        } else if (value instanceof String) {
            return value;
        } else {
            throw new TypeCastException(value, this);
        }
    }

    @Override
    public Object getSqlValue(int column, ResultSet resultSet) throws SQLException, TypeCastException {
        return resultSet.getDouble(column);
    }

    @Override
    public void setSqlValue(Object value, int column, PreparedStatement statement) throws SQLException, TypeCastException {
        PGobject pgObject = new PGobject();
        pgObject.setType("money");
        pgObject.setValue(value == null ? null : value.toString());
        statement.setObject(column, pgObject);
    }
}
