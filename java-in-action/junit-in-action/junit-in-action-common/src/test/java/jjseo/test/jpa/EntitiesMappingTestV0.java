package jjseo.test.jpa;

import jjseo.test.DataSetsJpa;
import jjseo.test.jpa.model.User;

import org.junit.Test;

import static jjseo.test.jpa.EntitiesHelper.assertUserWithTelephone;
import static jjseo.test.jpa.EntitiesHelper.newUserWithTelephone;

public class EntitiesMappingTestV0 extends AbstractJpaDbUnitELTemplateTestCaseJUnit44V0 {

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user-with-telephone-v0.xml")
    public void testLoadUserWithTelephone() {
        beginTransaction();
        User user = em.find(User.class, id);
        commitTransaction();
        assertUserWithTelephone(user);
        id++;
        phoneId += 2;
    }


    @Test
    @DataSetsJpa(assertDataSet = "/jpa/user-with-telephone-v0.xml")
    public void testSaveUserWithTelephone() throws Exception {
        User user = newUserWithTelephone();
        beginTransaction();
        em.persist(user);
        commitTransaction();
    }



}
