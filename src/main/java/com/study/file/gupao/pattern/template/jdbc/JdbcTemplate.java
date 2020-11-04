package com.study.file.gupao.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) throws Exception {

        //1.获取连接
        Connection connection = this.getConnection();
        //2.创建语句集
        PreparedStatement prepareStatement = this.createPrepareStatement(connection, sql);
        //3.执行语句集
        ResultSet resultSet = this.executeQuery(prepareStatement, values);
        //4.处理结果集
        List<?> objects = this.paresResultSet(resultSet, rowMapper);
        //5.关闭结果集
        this.closeResultSet(resultSet);
        //6.关闭语句集
        this.closeStatement(prepareStatement);
        //7.关闭连接
        this.closeConnection(connection);
        return objects;
    }

    protected void closeConnection(Connection conn) throws Exception {
        //数据库连接池，我们不是关闭
        conn.close();
    }

    protected void closeStatement(PreparedStatement preparedStatement) throws Exception {
        preparedStatement.close();
    }

    protected void closeResultSet(ResultSet resultSet) throws Exception {
        resultSet.close();
    }

    protected List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()){
            list.add(rowMapper.mapRow(rs,rowNum++));
        }
        return list;
    }

    protected ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i,values[i]);
        }
        return pstm.executeQuery();
    }

    public PreparedStatement createPrepareStatement(Connection con, String sql) throws Exception {
        return con.prepareStatement(sql);
    }

    public Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

}
