package cricketleagueanalysis;

public class FactSheetDAO {

    public String playerName;
    public double avgRun;

    public FactSheetDAO(IPLMostRunCSV iplMostRunCSV) {
        playerName = iplMostRunCSV.playerName;
        avgRun = iplMostRunCSV.avgRun;
    }
}
