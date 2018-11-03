package com.battcn.framework.mybatis.template.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.battcn.framework.mybatis.template.MybatisSqlDao;

/**
 * 缺省全局通用数据访问对象，缺省数据访问对象连接到dataSource Bean配置的数据源
 *
 * @author Levin
 * @version 2.5.1
 * @since 2018-01-10
 */
@Component
public class MybatisSqlDaoImpl implements MybatisSqlDao {

    private SqlSessionTemplate sqlSessionTemplate;

    @Autowired
    public MybatisSqlDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int save(String statement, Object record) {
        if (record == null) {
            return sqlSessionTemplate.insert(statement);
        } else {
            return sqlSessionTemplate.insert(statement, record);
        }
    }

    @Override
    public int batchSave(String statement, List<?> records) throws Exception {
        return sqlSessionTemplate.insert(statement, records);
    }


    @Override
    public int update(String statement, Object record) {
        if (record == null) {
            return sqlSessionTemplate.update(statement);
        } else {
            return sqlSessionTemplate.update(statement, record);
        }
    }

    @Override
    public void batchUpdate(String statement, List<?> records) {
        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
        // 批量执行器
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            if (records != null) {
                for (Object record : records) {
                    sqlSession.update(statement, record);
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
    }

    @Override
    public Object delete(String statement, Object record) {
        if (record == null) {
            return sqlSessionTemplate.delete(statement);
        } else {
            return sqlSessionTemplate.delete(statement, record);
        }
    }

    @Override
    public Object findForObject(String statement, Object obj) {
        if (obj == null) {
            return sqlSessionTemplate.selectOne(statement);
        } else {
            return sqlSessionTemplate.selectOne(statement, obj);
        }
    }

    @Override
    public Object queryForList(String statement, Object obj) {
        if (obj == null) {
            return sqlSessionTemplate.selectList(statement);
        } else {
            return sqlSessionTemplate.selectList(statement, obj);
        }
    }

}
