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
        } else if (Objects.equals(sqlTypeName, "hstore")) {
            return HstoreDataType.HSTORE;
        } else if (Objects.equals(sqlTypeName, "xml")) {
            return XmlDataType.XML;
        } else if (Objects.equals(sqlTypeName, "vector")) {
            return VectorType.VECTOR;
        } else if (Objects.equals(sqlTypeName, "money")) {
            return MoneyDataType.MONEY;
        } else if (Objects.equals(sqlTypeName, "_text")) {
            return TextArrayDataType.TEXT_ARRAY;
        } else if (Objects.equals(sqlTypeName, "daterange")) {
            return DateRangeDataType.DATE_RANGE;
        } else if (Objects.equals(sqlTypeName, "int4range")) {
            return Int4RangeDataType.INT4RANGE;
        } else if (Objects.equals(sqlTypeName, "int8range")) {
            return Int8RangeDataType.INT8RANGE;
        } else if (Objects.equals(sqlTypeName, "ltree")) {
            return LtreeDataType.LTREE;
        } else if (Objects.equals(sqlTypeName, "numrange")) {
            return NumRangeDataType.NUM_RANGE;
        } else if (Objects.equals(sqlTypeName, "tsrange")) {
            return TsRangeDataType.TS_RANGE;
        } else if (Objects.equals(sqlTypeName, "tstzrange")) {
            return TsTzRangeDataType.TSTZ_RANGE;
        } else {
            return super.createDataType(sqlType, sqlTypeName);
        }
    }
}
