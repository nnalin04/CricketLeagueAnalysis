package cricketleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double avgRun;

}
