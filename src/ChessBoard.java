import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {
    private int boardSize;
    private int[][] board;

    public ChessBoard(int n) {
        boardSize = n;
        board = new int[boardSize][boardSize];

        setPreferredSize(new Dimension(251, 251));
    }

    public void placeQueen(int row, int col) {
        board[row][col] = 1;
        repaint();
    }
    public void setSize(int n) {
        boardSize = n;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / boardSize;
        int cellHeight = height / boardSize;

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }

                g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);

                if (board[row][col] == 1) {
                    if ((row + col) % 2 == 0) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                    g.fillOval(col * cellWidth + cellWidth / 4, row * cellHeight + cellHeight / 4, cellWidth / 2, cellHeight / 2);
                }
            }
        }
    }
}
