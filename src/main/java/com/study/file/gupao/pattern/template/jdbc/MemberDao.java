package com.study.file.gupao.pattern.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JdbcTemplate{
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll() throws Exception {
        String sql = "select * from t_member";

        RowMapper<Member> memberRowMapper = new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                //字段过多，原型模式
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        };
        List<?> objects = super.executeQuery(sql, memberRowMapper, null);
        return objects;

//        return super.executeQuery(sql, new RowMapper<Member>() {
//            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
//                Member member = new Member();
//                //字段过多，原型模式
//                member.setUsername(rs.getString("username"));
//                member.setPassword(rs.getString("password"));
//                member.setAge(rs.getInt("age"));
//                member.setAddr(rs.getString("addr"));
//                return member;
//            }
//        },null);
    }
}
