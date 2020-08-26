package cricketleagueanalysis;

public class FactSheetDAO {

    public double strikeRate;
    public String playerName;
    public double avgRun;

    public FactSheetDAO(IPLMostRunCSV iplMostRunCSV) {
        playerName = iplMostRunCSV.playerName;
        avgRun = iplMostRunCSV.avgRun;
        strikeRate = iplMostRunCSV.strikeRate;
    }
}
