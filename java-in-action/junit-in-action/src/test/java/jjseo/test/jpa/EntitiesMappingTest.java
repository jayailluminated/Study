package jjseo.test.jpa;

import jjseo.test.DataSetsJpa;
import jjseo.test.jpa.model.User;

import org.junit.Test;

import static jjseo.test.jpa.EntitiesHelper.assertUserWithTelephone;
import static jjseo.test.jpa.EntitiesHelper.newUserWithTelephone;

public class EntitiesMappingTest extends AbstractJpaDbUnitELTemplateTestCaseJUnit44 {

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user-with-telephone.xml")
    public void testLoadUserWithTelephone() {
        beginTransaction();
        long id = ELFunctionMapperImpl.getId(User.class);
        User user = em.find(User.class, id);
        commitTransaction();
        assertUserWithTelephone(user);
    }


    @Test
    @DataSetsJpa(assertDataSet = "/jpa/user-with-telephone.xml")
    public void testSaveUserWithTelephone() throws Exception {
        User user = newUserWithTelephone();
        beginTransaction();
        em.persist(user);
        commitTransaction();
    }

    @Test
    @DataSetsJpa(assertDataSet = "/jpa/user-with-telephone.xml")
    public void testSaveUserWithTelephoneAgain() throws Exception {
        testSaveUserWithTelephone();
    }

    @Test
    @DataSetsJpa(setUpDataSet = "/jpa/user-with-telephone.xml")
    public void testLoadUserWithTelephoneOneMoreTime() {
        testLoadUserWithTelephone();
    }


    @Test
    @DataSetsJpa(assertDataSet = "/jpa/user-with-telephone.xml")
    public void testSaveUserWithTelephoneOneMoreTime() throws Exception {
        testSaveUserWithTelephone();
    }

}
