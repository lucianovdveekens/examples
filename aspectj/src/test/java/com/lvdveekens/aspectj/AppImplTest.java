package com.lvdveekens.aspectj;

import org.junit.Test;

/**
 * Make sure aspectj-maven-plugin changed the bytecode before executing the test, e.g. run a `mvn clean install`.
 */
public class AppImplTest {

    @Test
    public void testAspectJ() {
        new AppImpl().sayHello();
    }
}
