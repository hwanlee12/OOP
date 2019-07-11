package week5;

import java.util.ArrayList;

public class main {
    public static void main(String[] args ){
        String[] externalContentName = { "StarTreck : Beyond" , "Spiderman : "
                + "Homecoming" , "DoctorStrange" , "WorkingDead" };
        int [] externalContentProfit = {50, 70, 60, 90};
        int [] externalContentCost = {40, 30, 30, 40};
        float [] externalContentQuality = {( float ) 7.1, ( float ) 7.5, ( float ) 8.3, ( float ) 6.2};

        String[] originalContentName = { "DareDevil" , "GoodPlace" , "BlackMirror" ,
                "Punisher" };
        int [] originalContentProfit = {52, 65, 72, 85};
        int [] originalContentCost = {30, 20, 40, 30};
        float [] originalContentQuality = {( float ) 6.2, ( float ) 5.9, ( float ) 8.7, ( float ) 5.9};

        Netflix netflix1 ;
        Netflix netflix2 ;

        ArrayList<VideoContent> externalContent = new ArrayList<VideoContent>();
        for(int i = 0; i < externalContentName.length; i++)
        {
            VideoContent externalContent1 = new VideoContent(externalContentName[i], externalContentProfit[i], externalContentCost[i], externalContentQuality[i]);
            externalContent.add(externalContent1);
        }

        netflix1 = new Netflix( externalContent );
        netflix2 = new Netflix( originalContentName , originalContentProfit ,
                originalContentCost , originalContentQuality );

        System.out.printf("External Contents Quality : %.2f vs Original Contents Quality : %.2f\n\n",
                netflix1.calQuality(), netflix2.calQuality());
        if(netflix1.calQuality() < netflix2.calQuality())
            System.out.println("Original contents have better quality\n");
        if(netflix1.calQuality() > netflix2.calQuality())
            System.out.println("External contents have better quality\n");
        if(netflix1.calQuality() == netflix2.calQuality())
            System.out.println("Same quality\n");


        System.out.printf("Exterior Contents Profit : %.2f vs Original Contents Profit : %.2f\n\n",
                netflix1.calProfit(),netflix2.calProfit());
        if(netflix1.calProfit() < netflix2.calProfit())
            System.out.println("Original contents have more profit\n");
        if(netflix1.calProfit() > netflix2.calProfit())
            System.out.println("External contents have more profit\n");
        if(netflix1.calProfit() == netflix2.calProfit())
            System.out.println("Same Profit\n");
    }
}
