/*
package com.example.demo.handler;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.example.demo.model.AttachmentFile;

public class AttachmentFileTypeHandler extends BaseTypeHandler<AttachmentFile> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, AttachmentFile parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBinaryStream(i, parameter.getInputStream(), parameter.getLength());
    }

    @Override
    public AttachmentFile getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return toInputStream(rs.getBlob(columnName));
    }

    @Override
    public AttachmentFile getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return toInputStream(rs.getBlob(columnIndex));
    }

    @Override
    public AttachmentFile getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toInputStream(cs.getBlob(columnIndex));
    }

    private AttachmentFile toInputStream(Blob blob) throws SQLException {
        if (blob == null) {
            return null;
        } else {
            return new AttachmentFile(-1, blob.getBinaryStream());
        }
    }
}
*/