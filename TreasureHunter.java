import kareltherobot.*;
/**
 * Write a description of class TreasureHunter here.
 * 
 * @author Sean Plunkett 
 * @version 2015-10-28 Ver. 1.0
 */
public class TreasureHunter extends Robot
{
    public TreasureHunter(int st, int ave, Direction dir, int beeps)
    {
        super(st, ave, dir, beeps);
    }

    public int countBeepers()
    {
        int x = 0;

        while (nextToABeeper()) {
            pickBeeper();
            x++;
        }
        
        while (anyBeepersInBeeperBag()) {
            putBeeper();
        }

        return x;
    }

    public void moveToNextClue()
    {
        while (!nextToABeeper()) {
            move();
        }
    }

    public void work() 
    {
        while (true) {
            moveToNextClue();
            
            if (countBeepers() == 1) {
                faceNorth();
            }

            else if (countBeepers() == 2) {
                faceWest();
            }

            else if (countBeepers() == 3) {
                faceSouth();
            }

            else if (countBeepers() == 4) {
                faceEast();
            }

            else {
                turnOff();
            }
            
            move();
        }
    }

    public void faceNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }

    public void faceSouth() {
        while (!facingSouth()) {
            turnLeft();
        }
    }

    public void faceEast() {
        while (!facingEast()) {
            turnLeft();
        }
    }

    public void faceWest() {
        while (!facingWest()) {
            turnLeft();
        }
    }
}
