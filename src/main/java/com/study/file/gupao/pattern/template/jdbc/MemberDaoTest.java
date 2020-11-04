package com.study.file.gupao.pattern.template.jdbc;

import java.util.List;

public class MemberDaoTest {

    public static void main(String[] args) throws Exception {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
