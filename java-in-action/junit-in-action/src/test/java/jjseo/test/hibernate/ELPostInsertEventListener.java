package jjseo.test.hibernate;

import jjseo.test.jpa.ELFunctionMapperImpl;

import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;

public class ELPostInsertEventListener implements PostInsertEventListener {

    private static final long serialVersionUID = 1L;

    @Override
    public void onPostInsert(PostInsertEvent event) {
        String className = event.getEntity().getClass().getSimpleName();
        Long id = (Long) event.getId();
        ELFunctionMapperImpl.setId(className, id);
    }

}