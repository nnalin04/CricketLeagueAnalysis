package cricketleagueanalysis;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRunCSV {

    @CsvBindByName(column = "PLAYER", required = true)
    public String player;

    @CsvBindByName(column = "Avg", required = true)
    public String avgRun;

}
