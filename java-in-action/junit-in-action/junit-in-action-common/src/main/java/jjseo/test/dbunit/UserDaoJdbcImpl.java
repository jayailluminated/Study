/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package jjseo.test.dbunit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoJdbcImpl implements UserDao {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public long addUser(User user) throws SQLException {
        // PreparedStatement pstmt =
        // connection.prepareStatement("INSERT INTO users VALUES (?,?,?)",
        // Statement.RETURN_GENERATED_KEYS);
        connection.setAutoCommit(false);
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users (username, first_name, last_name) VALUES (?,?,?)");
        try {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.executeUpdate();
            long id = getLastIdentity();
            connection.commit();
            return id;
        } finally {
            close(pstmt);
            connection.setAutoCommit(true);
        }
    }

    private long getLastIdentity() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("CALL IDENTITY()");
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            rs.next();
            long id = rs.getLong(1);
            return id;
        } finally {
            close(rs, pstmt);
        }
    }

    @Override
    public User getUserById(long id) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        ResultSet rs = null;
        User user = null;
        try {
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                fill(user, rs);
            }
        } finally {
            close(rs, pstmt);
        }
        return user;
    }

    private void fill(User user, ResultSet rs) throws SQLException {
        user.setUsername(rs.getString("username"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setId(rs.getLong("id"));
    }

    public void createTables() throws SQLException {
        Statement stmt = connection.createStatement();
        try {
            stmt.execute("CREATE TABLE users ( id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1), username VARCHAR(10), first_name VARCHAR(10), last_name VARCHAR(10) )");
        } finally {
            close(stmt);
        }
    }

    private void close(ResultSet rs, Statement pstmt) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(pstmt);
    }

    private void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
