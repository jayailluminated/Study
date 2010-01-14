package dependency.injection.spring;


import dependency.injection.model.email.SpellChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
*   @Autowired performs the same role as  Guice's @Inject
*   Remember that you still need to place a <bean> tag in XML to make Spring aware of autowired classes.
*   <benas ...>
*       <bean id="spellChecker" class="SpellChecker" />
*       <bean id="emailer" class="Emailer" />
*   </beans>
* */
@Component
public class Emailer {
    private SpellChecker spellChecker;

    @Autowired
    public Emailer(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void send(String text) {
        spellChecker.check(text);
    }
}