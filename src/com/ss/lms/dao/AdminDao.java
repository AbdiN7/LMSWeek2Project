package com.ss.lms.dao;

import java.sql.*;

public interface AdminDao<T> {
    public void add(T type) throws SQLException;
    public void delete(T type) throws SQLException;
}


