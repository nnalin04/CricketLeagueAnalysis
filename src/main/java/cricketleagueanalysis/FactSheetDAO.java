package cricketleagueanalysis;

public class FactSheetDAO {

    public int fours;
    public int sixes;
    public double strikeRate;
    public String playerName;
    public double avgRun;

    public FactSheetDAO(IPLMostRunCSV iplMostRunCSV) {
        playerName = iplMostRunCSV.playerName;
        avgRun = iplMostRunCSV.avgRun;
        strikeRate = iplMostRunCSV.strikeRate;
        fours = iplMostRunCSV.fours;
        sixes = iplMostRunCSV.sixes;
    }
}
