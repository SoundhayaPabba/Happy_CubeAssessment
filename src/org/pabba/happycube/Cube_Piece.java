package org.pabba.happycube;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Cube_Piece {
    private Cube_Edge[] edges = new Cube_Edge[4];
    private int name;

    public Cube_Piece(Cube_Edge[] edges, int name) {
        this.edges = edges;
        this.name = name;
    }

    public Cube_Piece(int name, int topEdge, int rightEdge, int bottomEdge, int leftEdge) {
        this.edges[0] = new Cube_Edge(topEdge);
        this.edges[1] = new Cube_Edge(rightEdge);
        this.edges[2] = new Cube_Edge(bottomEdge);
        this.edges[3] = new Cube_Edge(leftEdge);
        this.name = name;
        this.draw();
        System.out.println();
    }

    public List<Cube_Piece> getAllPositions() {

        List<Cube_Piece> positions = new ArrayList<>();
        Cube_Piece copy = this;

        for (int i = 0; i < 4; i++) {
            positions.add(copy);
            copy.rotateClockWise();
        }
        copy.flipTopDown();
        for (int i = 0; i < 3; i++) {
            positions.add(copy);
            copy.rotateClockWise();
        }

        return positions;
    }

    public Cube_Edge[] getEdges() {
        return edges;
    }

    public Cube_Edge getEdge(int index) {
        return edges[index];
    }

    public void setEdges(Cube_Edge[] edges) {
        this.edges = edges;
    }

    public void setEdge(int index, Cube_Edge edge) {
        this.edges[index] = edge;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    /*
     * Rotate Piece 90 degree clockwise
     */
    public void rotateClockWise() {
        Cube_Edge temp = edges[3];

        for (int i = 1; i < edges.length; i++) {
            edges[i] = edges[i - 1];
        }

        edges[0] = temp;
    }

    /*
     * Flip piece in direction of up-bottom
     */
    public void flipTopDown() {
        Cube_Edge temp = edges[2];
        edges[1].setValue(Cube_Conversion.reverseBinary(edges[1].getValue()));
        edges[3].setValue(Cube_Conversion.reverseBinary(edges[3].getValue()));
        edges[2] = edges[0];
        edges[0] = temp;
    }

    /*
     * Flip piece in direction of right-left
     */
    public void flipRightLeft() {
        Cube_Edge temp = edges[1];
        edges[0].setValue(Cube_Conversion.reverseBinary(edges[0].getValue()));
        edges[2].setValue(Cube_Conversion.reverseBinary(edges[2].getValue()));
        edges[1] = edges[3];
        edges[3] = temp;
    }

    public void draw() {
        String[] rep = new String[5];

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                rep[i] = edges[i].getValue();
            } else if (i == 4) {
                rep[i] = edges[2].getValue();

            } else {
                rep[i] = edges[3].getValue().charAt(i) + "111" + edges[1].getValue().charAt(i);
            }
            rep[i] = rep[i].replace("1", "X");
            rep[i] = rep[i].replace("0", " ");
            System.out.println(rep[i]);
        }
    }

    public void drawLine(int i) {
        String[] rep = new String[1];
        if (i == 0) {
            rep[i] = edges[i].getValue();
        } else if (i == 4) {
            rep[i] = edges[2].getValue();

        } else {
            rep[i] = edges[3].getValue().charAt(i) + "111" + edges[1].getValue().charAt(i);
        }
        rep[i] = rep[i].replace("1", "X");
        rep[i] = rep[i].replace("0", " ");
        System.out.print(rep[i]);
    }
}
