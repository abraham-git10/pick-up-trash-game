import javax.swing.*;
import java.awt.*;
public class TrashFrame extends JFrame {
    public TrashFrame(String frameName, int panelWidth, int panelHeight) {
        super(frameName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        TrashPanel p = new TrashPanel(panelWidth, panelHeight);
        Insets frameInsets = getInsets();
        int frameWidth = panelWidth + (frameInsets.left + frameInsets.right);
        int frameHeight = panelHeight + (frameInsets.top + frameInsets.bottom);
        setPreferredSize(new Dimension(frameWidth, frameHeight));
        setLayout(null);
        add(p);
        pack();
        setVisible(true);
    }
}