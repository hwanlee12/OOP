package week5;

public class VideoContent {
    private String name;
    private int potenProfit;
    private int potenCost;
    private float potenQuality;

    public VideoContent(String name, int potenProfit, int potenCost, float potenQuality)
    {
        this.name = name;
        this.potenProfit = potenProfit;
        this.potenCost = potenCost;
        this.potenQuality = potenQuality;
    }

    public int getPotenProfit() {  return potenProfit;  }

    public int getPotenCost()
    {
        return potenCost;
    }

    public float getPotenQuality() {  return potenQuality;  }
}
