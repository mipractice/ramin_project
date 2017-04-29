package com.rr.dao.impl.service;

import com.rr.dao.abst.AbstractService;
import com.rr.dao.impl.dao.StudentDaoImpl;

public class StudentServiceImpl<Student> extends AbstractService {
    public StudentServiceImpl() {
        dao = new StudentDaoImpl();
    }
}
