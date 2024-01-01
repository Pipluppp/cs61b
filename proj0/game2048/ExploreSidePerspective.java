package game2048;

/**
 * How does vtile() handle the calculation of the coordinates given the SIDE and the original coordinates
 *
 */
public class ExploreSidePerspective {
    public static void main(String[] args) {
        int[][] origTiles = new int[][] {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 3, 2, 1},
                {1, 4, 1, 1},
        };


        /** Change view to WEST
         *
            int[][] perspectiveTiles = new int[][] {
                {1, 1, 1, 1},
                {4, 3, 1, 1},
                {1, 2, 1, 1},
                {1, 1, 1, 1},
        };
        */



        Board board = new Board(origTiles, 0);

        board.setViewingPerspective(Side.WEST);

        int boardSize = board.size();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board.tile(j, boardSize - i - 1).value());
            }
            System.out.println();
        }


    }
}
