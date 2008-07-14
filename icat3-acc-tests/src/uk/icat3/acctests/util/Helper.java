/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.icat3.acctests.util;

import java.util.List;

/**
 *
 * @author df01
 */
public class Helper {
    
    public static boolean isEmpty(String str) {
        if ((str == null) || (str.length() ==0)) return true;
        else return false;
    }
    
    public static uk.icat3.client.Investigation checkInvestigationIncluded(uk.icat3.client.Investigation investigation)  {
        if (investigation == null) throw new IllegalArgumentException("Investigation is NULL");        
        
        return investigation;
    }
    
    public static uk.icat3.client.Dataset checkDatasetIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);
        
        List<uk.icat3.client.Dataset> datasets = investigation.getDatasetCollection();
        if ((datasets == null) || (datasets.size() ==0)) throw new IllegalArgumentException("No Datasets were found in Investigation #" + investigation);
        
        uk.icat3.client.Dataset dataset = datasets.get(0);
        if (dataset == null) throw new IllegalArgumentException("Dataset is NULL for Investigation#" + investigation);
        
        return dataset;
    }
    
    public static uk.icat3.client.Datafile checkDatafileIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);
        uk.icat3.client.Dataset dataset = checkDatasetIncluded(investigation);
                
        List<uk.icat3.client.Datafile> datafiles = dataset.getDatafileCollection();
        if ((datafiles == null) || (datafiles.size() ==0)) throw new IllegalArgumentException("No Datafiles were found in Investigation #" + investigation);
        
        uk.icat3.client.Datafile datafile = datafiles.get(0);
        if (datafile == null) throw new IllegalArgumentException("Datafile is NULL for Investigation#" + investigation);
        
        return datafile;
    }
    
    public static uk.icat3.client.DatafileParameter checkDatafileParameterIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);
        checkDatasetIncluded(investigation);
        uk.icat3.client.Datafile datafile = checkDatafileIncluded(investigation);
        
        List<uk.icat3.client.DatafileParameter> parameters = datafile.getDatafileParameterCollection();
        if ((parameters == null) || (parameters.size() ==0)) throw new IllegalArgumentException("No Datafiles were found in Investigation #" + investigation);
        
        uk.icat3.client.DatafileParameter parameter = parameters.get(0);
        if (parameter == null) throw new IllegalArgumentException("Parameter is NULL for Investigation#" + investigation);
        
        return parameter;
    }
    
    public static uk.icat3.client.Sample checkSampleIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);        
                
        List<uk.icat3.client.Sample> samples = investigation.getSampleCollection();
        if ((samples == null) || (samples.size() ==0)) throw new IllegalArgumentException("No Samples were found in Investigation #" + investigation);
        
        uk.icat3.client.Sample sample = samples.get(0);
        if (sample == null) throw new IllegalArgumentException("Sample is NULL in Investigation#" + investigation);
        
        return sample;
    }
    
    public static uk.icat3.client.SampleParameter checkSampleParametersIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);        
        uk.icat3.client.Sample sample = checkSampleIncluded(investigation);        
        
        List<uk.icat3.client.SampleParameter> sampleParams = sample.getSampleParameterCollection();
        if ((sampleParams == null) || (sampleParams.size() ==0)) throw new IllegalArgumentException("No Samples were found in Investigation #" + investigation);
        
        uk.icat3.client.SampleParameter sampleParam = sampleParams.get(0);
        if (sampleParam == null) throw new IllegalArgumentException("SampleParameter is NULL in Investigation#" + investigation);
        
        return sampleParam;
    }
    
    public static uk.icat3.client.Publication checkPublicationIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);        
                
        List<uk.icat3.client.Publication> publications = investigation.getPublicationCollection();
        if ((publications == null) || (publications.size() ==0)) throw new IllegalArgumentException("No Publications were found in Investigation #" + investigation);
        
        uk.icat3.client.Publication publication = publications.get(0);
        if (publication == null) throw new IllegalArgumentException("Publciation is NULL in Investigation#" + investigation);
        
        return publication;
    }
    
    public static uk.icat3.client.Keyword checkKeywordIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);        
                
        List<uk.icat3.client.Keyword> keywords = investigation.getKeywordCollection();
        if ((keywords == null) || (keywords.size() ==0)) throw new IllegalArgumentException("No Keywords were found in Investigation #" + investigation);
        
        uk.icat3.client.Keyword keyword = keywords.get(0);
        if (keyword == null) throw new IllegalArgumentException("Keyword is NULL in Investigation#" + investigation);
        if (Helper.isEmpty(keyword.getKeywordPK().getName())) throw new IllegalArgumentException("Keyword has invalid data in Investigation#" + investigation);
        
        return keyword;
    }
    
    public static uk.icat3.client.Investigator checkInvestigatorIncluded(uk.icat3.client.Investigation investigation)  {
        checkInvestigationIncluded(investigation);        
                
        List<uk.icat3.client.Investigator> investigators = investigation.getInvestigatorCollection();
        if ((investigators == null) || (investigators.size() ==0)) throw new IllegalArgumentException("No Investigators were found in Investigation #" + investigation);
        
        uk.icat3.client.Investigator investigator = investigators.get(0);
        if (investigator == null) throw new IllegalArgumentException("Investigator is NULL in Investigation#" + investigation);
        if (Helper.isEmpty(investigator.getFacilityUser().getFederalId())) throw new IllegalArgumentException("Investigator has invalid data in Investigation#" + investigation);
        
        return investigator;
    }
}