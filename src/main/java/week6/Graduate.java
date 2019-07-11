package week6;

public class Graduate extends Student {
    private double tuitionPerCredit;
    private double waive = 0.8;

    public Graduate(String firstName, String lastName, String birthday, int credit)
    {
        super(firstName, lastName, birthday, credit);
        this.tuitionPerCredit = 1000;
        this.waive = 0.8;
    }

    public double calTotalTuition()
    {
        double total;
        total = credit * tuitionPerCredit * (1 - waive);
        return total;
    }

    public double getTuitionPerCredit()
    {
        return tuitionPerCredit;
    }

    public double getWaive()
    {
        return waive;
    }

    @Override
    public String toString()
    {
        String result;
        result = String.format("<Graduate>\nfirst name : %s\nlast name : %s\nbirthday : %s\ncredit : %d\ntuition credit : %.1f\nwaive : %.1f\ntotal tuition fee : %.1f\n",
                firstName, lastName,birthday, credit, tuitionPerCredit, waive, calTotalTuition());
        return result;
    }
}
