package cricketleagueanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class CricketLeagueAnalyserTest {

    private static final String MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostRuns.csv";
    private static final String MOST_WKTS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactSheetMostWkts.csv";

    @Test
    public void givenMostRunFactSheet_WhenShortedOnBattingAverage_ShouldReturnSortedResult() throws CricketLeagueAnalyserException {
        CricketLeagueAnalyser cricketLeagueAnalyser = new CricketLeagueAnalyser();
        cricketLeagueAnalyser.loadLeagueFactSheet(MOST_RUN_CSV_FILE_PATH);
        String sortedFactSheetData = cricketLeagueAnalyser.getBattingAvRageSortedFactSheet();
        IPLMostRunCSV[] iplMostRunCSV =  new Gson().fromJson(sortedFactSheetData, IPLMostRunCSV[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCSV[0].playerName);
    }
}