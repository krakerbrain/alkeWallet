package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CuentaTest.class, MainTest.class, MenuTest.class, DepositoTest.class, RetiroTest.class })
public class AllTests {

}
