package org.mvnsearch.dbunit.ext.postgresql;

import com.pgvector.PGvector;
import org.dbunit.dataset.datatype.AbstractDataType;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.TypeCastException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * vector data type
 *
 * @author linux_china
 */
public class VectorType extends AbstractDataType {
    public static final DataType VECTOR = new VectorType();

    public VectorType() {
        super("vector", Types.OTHER, String.class, false);
    }

    @Override
    public Object typeCast(Object value) throws TypeCastException {
        if (value == null) {
            return null;
        }
        if (value instanceof PGvector) {
            return value;
        }
        if (value instanceof String) {
            try {
                return new PGvector((String) value);
            } catch (SQLException e) {
                throw new TypeCastException(e);
            }
        }
        throw new TypeCastException(value, this);
    }

    @Override
    public Object getSqlValue(int column, ResultSet resultSet) throws SQLException, TypeCastException {
        return resultSet.getString(column);
    }

    @Override
    public void setSqlValue(Object value, int column, PreparedStatement statement) throws SQLException, TypeCastException {
        if (value == null) {
            statement.setObject(column, null);
        } else {
            PGvector pgVector = new PGvector(value.toString());
            statement.setObject(column, pgVector);
        }
    }
}
