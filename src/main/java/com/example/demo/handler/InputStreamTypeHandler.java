/*
package com.example.demo.handler;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;



public class InputStreamTypeHandler extends BaseTypeHandler<InputStream> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, InputStream parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBlob(i, parameter);
    }

    @Override
    public InputStream getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getBinaryStream(columnName);
    }

    @Override
    public InputStream getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getBinaryStream(columnIndex);
    }

    @Override
    public InputStream getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getResultSet().getBinaryStream(columnIndex);
    }
}
*/
