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

import static jjseo.test.dbunit.EntitiesHelper.*;
import static org.junit.Assert.*;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Ignore;
import org.junit.Test;

public class UserDaoJdbcImplTest extends AbstractDbUnitTestCase {

    private final String dateSet = "/dbunit/user.xml";
    private final String replacedDateSet = "/dbunit/user-token.xml";


    @Test
    public void testGetUserById() throws Exception {
        IDataSet setupDataSet = getDataSet(dateSet);
        DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, setupDataSet);
        User user = dao.getUserById(1);
        assertNotNull(user);
        assertEquals("Jeffrey", user.getFirstName());
        assertEquals("Lebowsky", user.getLastName());
        assertEquals("ElDuderino", user.getUsername());
    }

    /**
     * IDatatabaseConnection.createDataSet() is find
     * if your database has only one table and the database access is fast.
     *
     * Although we cleaned up the rows, we didn’t reset the primary key generation,
     * so the next row inserted has an ID of 2 and not 1 as we expected
     */
    @Test
    @Ignore("fails if run together with others")
    public void testAddUser() throws Exception {
        User user = newUser();
        long id = dao.addUser(user);
        assertTrue(id > 0);
        IDataSet expectedDataSet = getDataSet(dateSet);
        IDataSet actualDataSet = dbunitConnection.createDataSet();
        Assertion.assertEquals(expectedDataSet, actualDataSet);
    }

    /**
     * IDatatabaseConnection.createDataSet() filtering
     * the simplest way to narrow the field is passing array name of the tables
     *
     * ◆テーブルをフィルターした場合は以下のように作成する。
     *
     * way1
     * <pre>
     * IDataSet actualDataSet = dbunitConnection.createDataSet(new String[] { "users" } );
     * </pre>
     *
     * way2
     * <pre>
     * IDataSet actualDataSet = dbunitConnection.createDataSet();
     * FilteredDataSet filteredDataSet = new FilteredDataSet(new String[] {"users"}, actualDataSet );
     * </pre>
     */
    @Test
    public void testAddUseIgnoringId() throws Exception {
        IDataSet setupDataSet = getDataSet(dateSet);
        DatabaseOperation.DELETE_ALL.execute(dbunitConnection, setupDataSet);
        User user = newUser();
        long id = dao.addUser(user);
        assertTrue(id > 0);
        IDataSet expectedDataSet = getDataSet(dateSet);
        IDataSet actualDataSet = dbunitConnection.createDataSet();
        //Assertion.assertEqualsIgnoreCols(expectedDataSet, actualDataSet, "table_name", new String[] { "ignoring_column_name" });
        Assertion.assertEqualsIgnoreCols(expectedDataSet, actualDataSet, "users", new String[] { "id" });
    }

    @Test
    public void testGetUserByIdReplacingIds() throws Exception {
        long id = 42;
        IDataSet setupDataset = getReplacedDataSet(replacedDateSet, id);
        DatabaseOperation.INSERT.execute(dbunitConnection, setupDataset);
        User user = dao.getUserById(id);
        assertUser(user);
    }

    @Test
    public void testAddUserReplacingIds() throws Exception {
        IDataSet setupDataSet = getDataSet(replacedDateSet);
        DatabaseOperation.DELETE_ALL.execute(dbunitConnection, setupDataSet);
        User user = newUser();
        long id = dao.addUser(user);
        assertTrue(id > 0);
        IDataSet expectedDataSet = getReplacedDataSet(setupDataSet, id);
        IDataSet actualDataSet = dbunitConnection.createDataSet();
        Assertion.assertEquals(expectedDataSet, actualDataSet);
    }

}
