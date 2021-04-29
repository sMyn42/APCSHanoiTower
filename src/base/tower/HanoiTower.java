package base.tower;

import java.util.Date;

public class HanoiTower {
    private Peg peg1;
    private Peg peg2;
    private Peg peg3;
    private int numDiscs;

    public HanoiTower(int num)
    {
        // TODO implement constructor
        // Peg 1 is the starting Peg
        numDiscs = num;
        peg1 = new Peg(1, num);
        peg2 = new Peg(2, num);
        peg3 = new Peg(3, num);
        for(int current = num; current > 0; current--) {
            peg1.addDisc(current);
        }

    }
    public void solveTower()
    {
        moveTower(peg1, peg3, peg2, numDiscs);
    }

    private void moveTower(Peg startPeg, Peg endPeg, Peg extraPeg, int numtoMove)
    {
        if (numtoMove == 1) { //base case
            // TODO move discs(number input) from the start peg to the end peg
            startPeg.moveTopDisc(endPeg);
        } else {
            moveTower(startPeg, extraPeg, endPeg, numtoMove - 1);
            startPeg.moveTopDisc(endPeg);
            moveTower(extraPeg, endPeg, startPeg, numtoMove - 1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date i = new Date();
        HanoiTower ht = new HanoiTower(5);
        ht.solveTower();
        Date f = new Date();
        System.out.println("Elapsed: " + (f.getTime() - i.getTime())/1000.);
    }

}