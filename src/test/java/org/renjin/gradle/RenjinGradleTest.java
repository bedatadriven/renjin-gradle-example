package org.renjin.gradle;

import org.junit.Test;
import org.renjin.script.RenjinScriptEngineFactory;
import org.renjin.sexp.DoubleVector;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RenjinGradleTest {

    @Test
    public void test() throws ScriptException {
        RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();
        // create a Renjin engine:
        ScriptEngine engine = factory.getScriptEngine();

        engine.eval("print(rnorm(10))");

        DoubleVector result = (DoubleVector) engine.eval("1+1");
        assertThat(result.length(), equalTo(1));
        assertThat(result.getElementAsDouble(0), equalTo(2.0));
    }

}

