package service;

import model.SearchCarInfo;

public class SearchCarInfoCreator {
    public static final String TESTDATA_START_LOCATION="testdata.searchcarinfo.startlocation";
    public static final String TESTDATA_END_LOCATION="testdata.searchcarinfo.endlocation";
    public static final String TESTDATA_START_DATE="testdata.searchcarinfo.startdate";
    public static final String TESTDATA_END_DATE="testdata.searchcarinfo.enddate";
    public static final String TESTDATA_NOT_EXIST_LOCATION="testdata.searchcarinfo.notexistlocation";
    public static final String TESTDATA_DISTANT_DATE="testdata.searchcarinfo.distantdate";
    public static final String TESTDATA_PAST_DATE="testdata.searchcarinfo.pastdate";

    public static SearchCarInfo withSameStartAndEndLocations(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_START_LOCATION), TestDataReader.getTestData(TESTDATA_START_DATE),
                TestDataReader.getTestData(TESTDATA_END_DATE));
    }
    public static SearchCarInfo withDifferentStartAndEndLocations(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_START_LOCATION), TestDataReader.getTestData(TESTDATA_START_DATE),
                TestDataReader.getTestData(TESTDATA_END_LOCATION), TestDataReader.getTestData(TESTDATA_END_DATE));
    }

    public static SearchCarInfo withEmptyLocation(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_START_DATE), TestDataReader.getTestData(TESTDATA_END_DATE));
    }

    public static SearchCarInfo withNotExistLocation(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_NOT_EXIST_LOCATION), TestDataReader.getTestData(TESTDATA_START_DATE),
                TestDataReader.getTestData(TESTDATA_END_DATE));
    }

    public static SearchCarInfo withSameDateAndTime(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_START_LOCATION), TestDataReader.getTestData(TESTDATA_START_DATE),
                TestDataReader.getTestData(TESTDATA_START_DATE));
    }

    public static SearchCarInfo withLongBookingPeriod(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_START_LOCATION), TestDataReader.getTestData(TESTDATA_START_DATE),
                TestDataReader.getTestData(TESTDATA_DISTANT_DATE));
    }

    public static SearchCarInfo withPastDate(){
        return new SearchCarInfo(TestDataReader.getTestData(TESTDATA_START_LOCATION), TestDataReader.getTestData(TESTDATA_PAST_DATE),
                TestDataReader.getTestData(TESTDATA_END_DATE));
    }
}
