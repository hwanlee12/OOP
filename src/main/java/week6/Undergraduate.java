package week6;

public class Undergraduate extends Student {
    private double tuitionPerCredit;

    public Undergraduate(String firstName, String lastName, String birthday, int credit)
    {
        super(firstName, lastName, birthday, credit);
        this.tuitionPerCredit = 500;
    }

    public double calTotalTuition()
    {
        double total;
        total = credit * tuitionPerCredit;
        return total;
    }

    @Override
    public String toString()
    {
        String result;
        result = String.format("<Undergraduate>\nfirst name : %s\nlast name : %s\nbirthday : %s\ncredit : %d\ntuition credit : %.1f\ntotal tuition fee : %.1f\n",
                firstName, lastName,birthday, credit, tuitionPerCredit, calTotalTuition());
        return result;
    }
}
