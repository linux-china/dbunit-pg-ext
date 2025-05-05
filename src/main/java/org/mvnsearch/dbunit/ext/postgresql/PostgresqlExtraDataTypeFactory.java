package org.mvnsearch.dbunit.ext.postgresql;

import org.dbunit.dataset.datatype.DataType;
import org.dbunit.dataset.datatype.DataTypeException;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;

import java.util.Objects;

public class PostgresqlExtraDataTypeFactory extends PostgresqlDataTypeFactory {
    @Override
    public DataType createDataType(int sqlType, String sqlTypeName) throws DataTypeException {
        if (Objects.equals(sqlTypeName, "jsonb")) {
            return JsonbDataType.JSONB;
        } else if (Objects.equals(sqlTypeName, "json")) {
            return JsonDataType.JSON;
        } else if (Objects.equals(sqlTypeName, "xml")) {
            return XmlDataType.XML;
        } else if (Objects.equals(sqlTypeName, "vector")) {
            return VectorType.VECTOR;
        } else if (Objects.equals(sqlTypeName, "money")) {
            return MoneyDataType.MONEY;
        } else if (Objects.equals(sqlTypeName, "_text")) {
            return TextArrayDataType.TEXT_ARRAY;
        } else {
            return super.createDataType(sqlType, sqlTypeName);
        }
    }
}
