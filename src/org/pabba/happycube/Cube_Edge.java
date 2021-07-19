package org.pabba.happycube;
import java.util.ArrayList;
import java.util.List;
public class Cube_Edge {
    private Cube_Edge pre;
    private String value;
    private List<Cube_Corner> corners= new ArrayList<>();
    public Cube_Edge(int value)
    {
        this.value=Cube_Conversion.decimalToBinary(value);
    }
    public Cube_Edge getPre(){return pre;}
    public void setPre(Cube_Edge pre){this.pre=pre;}
    public String getValue(){return value;}
    public void setValue(String value){this.value=value; }
    public List<Cube_Corner> getCorners(){return corners;}
    public void addCorner(Cube_Corner corner){corners.add(corner);}
}
