package com.section1.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");

    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }
}