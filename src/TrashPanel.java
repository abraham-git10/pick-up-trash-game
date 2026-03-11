import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TrashPanel extends JPanel implements MouseListener {
    private int[] arr = new int[400];
    private int[] re = new int[400];
    public TrashPanel(int w, int h) {
        super();
        setSize(w, h);
        addMouseListener(this);
        int e = 0;
        for(int i = 0;i < 400;i++) {
            int a = (int) Math.round(Math.random());
            if(a == 0) {
                arr[e] = 0;
            }
            else if(a == 1) {
                arr[e] = 1;
            }
            e++;
        }
    }
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 376, 376);
        int w = 0;
        int e = 0;
        for(int i = 50;i < 326;i+=14) {
            for (int c = 50; c < 326; c += 14) {
                g.setColor(Color.BLACK);
                g.drawRect(c, i, 10, 10);
                if(arr[e] == 0) {
                    g.fillRect(c - 2, i - 2, 10, 10);
                }
                else if(arr[e] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect(c - 2, i - 2, 10, 10);
                    w++;
                }
                e++;
            }
        }
        int f = 0;
        for(int r = 0;r < 20;r++) {
            for(int c = 0;c < 20;c++) {
                if(re[f] == 1) {
                    g.setColor(Color.WHITE);
                    g.fillRect(c * 14 + 48, r * 14 + 48, 10, 10);
                    w++;
                }
                f++;
            }
        }
        if(w == 400) {
            g.fillRect(0, 0, 376, 376);
            g.setColor(Color.BLACK);
            g.drawString("You cleared all the trash", 50, 50);
        }
    }
    public void pickUpTrash(int c, int r) {
        int index = r * 20 + c;
        if(re[index] == 1) {
            return;
        }
        re[index] = 1;
        if(c > 0) {
            if (arr[r * 20 + (c - 1)] == 0) {
                pickUpTrash(c - 1, r);
            }
        }
        if(c < 19) {
            if (arr[r * 20 + (c + 1)] == 0) {
                pickUpTrash(c + 1, r);
            }
        }
        if(r > 0) {
            if (arr[(r - 1) * 20 + c] == 0) {
                pickUpTrash(c, r - 1);
            }
        }
        if(r < 19) {
            if (arr[(r + 1) * 20 + c] == 0) {
                pickUpTrash(c, r + 1);
            }
        }
        repaint();
    }
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(x >= 48 && x <= 324 && y >= 48 && y <= 324) {
            x -= 48;
            y -= 48;
            int c = x / 14;
            int r = y / 14;
            int index = r * 20 + c;
            if (arr[index] == 0) {
                pickUpTrash(c, r);
            }
        }
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
}