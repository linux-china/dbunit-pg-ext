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
 * numrange data type
 *
 * @author linux_china
 */
public class NumRangeDataType extends AbstractDataType {
    public static final DataType NUM_RANGE = new NumRangeDataType();

    public NumRangeDataType() {
        super("numrange", Types.OTHER, String.class, false);
    }

    @Override
    public Object typeCast(Object value) throws TypeCastException {
        return value == null ? null : value.toString();
    }

    @Override
    public Object getSqlValue(int column, ResultSet resultSet) throws SQLException, TypeCastException {
        return resultSet.getString(column);
    }

    @Override
    public void setSqlValue(Object value, int column, PreparedStatement statement) throws SQLException, TypeCastException {
        PGobject pgObject = new PGobject();
        pgObject.setType("numrange");
        pgObject.setValue(value == null ? null : value.toString());
        statement.setObject(column, pgObject);
    }
}
