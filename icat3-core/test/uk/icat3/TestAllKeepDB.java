/*
 * TestAll.java
 *
 * Created on 07 March 2007, 14:44
 *
 * JUNIT Test Suite that creates a connection to a specified ICAT3 JUNIT
 * test database schema and executes a number of scripts in order to
 * initialise the database for the JUNIT tests that are to be
 * subsequently called.  Add each JUNIT class (that is to be run) to the
 * @Suite.SuiteClasses annotation.
 *
 * @author df01
 * @version 1.0
 */
package uk.icat3;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import uk.icat3.datafilemanager.TestDatafile;
import uk.icat3.datafilemanager.TestDatafileParameter;
import uk.icat3.datasetmanager.TestDataset;
import uk.icat3.datasetmanager.TestDatasetParameter;
import uk.icat3.investigationmanager.TestInvestigation;
import uk.icat3.investigationmanager.TestInvestigator;
import uk.icat3.investigationmanager.TestKeyword;
import uk.icat3.investigationmanager.TestPublication;
import uk.icat3.investigationmanager.TestSample;
import uk.icat3.investigationmanager.TestSampleParameter;
import uk.icat3.search.TestInvalidUser;
import uk.icat3.search.TestKeywordSearch;

@RunWith(Suite.class)
@Suite.SuiteClasses({
            TestSample.class,
            TestKeyword.class,
            TestPublication.class,
            TestInvestigator.class,
            TestInvestigation.class,
            TestSampleParameter.class,
            
            TestDataset.class,
            TestDatasetParameter.class,
            
            TestDatafile.class,
            TestDatafileParameter.class,
            
            TestKeywordSearch.class,
            TestInvalidUser.class
})
public class TestAllKeepDB {
    
    
    public static Test suite() {
        
        
        
        return new JUnit4TestAdapter(TestAllKeepDB.class);
    }
}