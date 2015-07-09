package com.mtime.test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by zhangmanying on 15/4/16.
 */
public class MtimeTestSuite extends TestCase{
    public static  TestSuite suite() {
        TestSuite suite = new TestSuite("Sample Tests");
        suite.addTestSuite(PersonDetail.class);
        suite.addTestSuite(MovieDetail.class);
        suite.addTestSuite(HomePage.class);
        return suite;
    }
}
