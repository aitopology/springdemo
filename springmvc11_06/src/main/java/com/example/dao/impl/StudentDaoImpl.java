package com.example.dao.impl;

import com.example.dao.StudentDao;
import com.example.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {
        String sql = "select no,name,age from t_student";
        List<Student> list = this.jdbcTemplate.query(sql, new RowMapperImpl());
        return list;
    }

    @Override
    public Student queryByNo(String no) {
        return null;
    }

    @Override
    public int insert(Student student) {
        String sql = "insert into t_student values(?,?,?)";
        int i = this.jdbcTemplate.update(sql,
                student.getNo(),
                student.getName(),
                student.getAge());
        return i;
    }

    @Override
    public int updateByNo(Student student) {
        return 0;
    }

    @Override
    public int deleteByNo(String no) {
        return 0;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * 内部类:自定义的获取结果集数据的实现类
     */
    class RowMapperImpl implements RowMapper<Student>{

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setNo(rs.getString("no"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            return student;
        }
    }
}

