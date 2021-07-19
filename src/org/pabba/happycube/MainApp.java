package org.pabba.happycube;

public class MainApp {
    public static void main(String args[])
    {
Cube c=new Cube(Cube_Puzzle.RED);
Cube_Solver cs=new Cube_Solver();
cs.solve(0,c.getPieces());
    }
}
