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

import jjseo.test.DataSetsDbUnit;

import org.junit.Test;
import org.junit.runner.RunWith;

import static jjseo.test.dbunit.EntitiesHelper.assertUser;
import static jjseo.test.dbunit.EntitiesHelper.newUser;
import static org.junit.Assert.assertTrue;

@RunWith(AbstractDbUnitTemplateTestCase.DataSetsTemplateRunner.class)
public class UserDaoJdbcImplAnnotationsTest extends AbstractDbUnitTemplateTestCase {

  @Test
  @DataSetsDbUnit(setUpDataSet="/dbunit/user-token.xml")
  public void testGetUserById() throws Exception {
    User user = dao.getUserById(id);
    assertUser(user);
  }

  @Test
  @DataSetsDbUnit(assertDataSet="/dbunit/user-token.xml")
  public void testAddUser() throws Exception {
    User user = newUser();
    id = dao.addUser(user);
    assertTrue(id>0);
  }

}
