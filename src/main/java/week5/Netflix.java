package week5;

import java.util.ArrayList;

public class Netflix {
    private ArrayList<VideoContent> videos = new ArrayList<VideoContent>();

    public Netflix(ArrayList<VideoContent> videos)
    {
        this.videos = videos;
    }

    public Netflix(String[] name, int[] profit, int[] cost, float[] quality)
    {
        for(int i = 0; i < name.length; i++)
        {
            VideoContent InContent = new VideoContent(name[i], profit[i], cost[i], quality[i]);
            videos.add(InContent);
        }
    }

    public float calQuality()
    {
        float sum = 0;
        for(int i = 0;i < videos.size(); i++)
        {
            sum +=  videos.get(i).getPotenQuality();
        }
        return sum;
    }

    public float calProfit()
    {
        float sum = 0;
        float total = 0;
        float potenprft;
        int potencost;

        for(int i = 0; i < videos.size(); i++)
        {
            potenprft = videos.get(i).getPotenProfit();
            potencost = videos.get(i).getPotenCost();
            sum = potenprft - potencost;
            total += sum;
        }
        return total;
    }
}
