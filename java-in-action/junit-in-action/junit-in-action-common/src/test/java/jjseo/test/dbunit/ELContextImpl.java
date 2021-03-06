package jjseo.test.dbunit;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.el.BeanELResolver;
import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.ExpressionFactory;
import javax.el.FunctionMapper;
import javax.el.ValueExpression;
import javax.el.VariableMapper;

import org.apache.el.ExpressionFactoryImpl;
import org.apache.el.ValueExpressionLiteral;

public final class ELContextImpl extends ELContext {

    private final BeanELResolver resolver = new BeanELResolver();
    private final FunctionMapper functionMapper = new NoopFunctionMapper();
    private final VariableMapper variableMapper = new VariableMapperImpl();
    private final Map<String, ValueExpression> variables = new HashMap<String, ValueExpression>();
    private final ExpressionFactory factory;

    ELContextImpl() {
        final String factoryClass = "org.apache.el.ExpressionFactoryImpl";
        System.setProperty("javax.el.ExpressionFactory", factoryClass);
        factory = ExpressionFactoryImpl.newInstance();
        if (factory == null) {
            throw new RuntimeException("could not get instance of factory class " + factoryClass);
        }
    }

    public ExpressionFactory getFactory() {
        return factory;
    }

    @Override
    public ELResolver getELResolver() {
        return resolver;
    }

    @Override
    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    @Override
    public VariableMapper getVariableMapper() {
        return variableMapper;
    }

    public void bind(String variable, Object obj) {
        variables.put(variable, new ValueExpressionLiteral(obj, Object.class));
    }

    private class VariableMapperImpl extends VariableMapper {
        @Override
        public ValueExpression resolveVariable(String s) {
            return variables.get(s);
        }

        @Override
        public ValueExpression setVariable(String s,
                ValueExpression valueExpression) {
            return (variables.put(s, valueExpression));
        }
    }

    private class NoopFunctionMapper extends FunctionMapper {
        @Override
        public Method resolveFunction(String s, String s1) {
            return null;
        }

    }

}
