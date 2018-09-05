package game.game;

import java.io.Serializable;

public class Table implements Serializable {

    private int[][] table = new int[5][5];

    public Table() {
        for (int i = 0; i<table.length; i++) {
            for(int j = 0; j<table[i].length; j++)
                table[i][j] = 0;
        }
    }

    public int[][] increment(int x, int y) {
        table[x][y]++;
        return table;
    }

}
