import java.awt.*;
import java.awt.event.*;
import java.util.Arrays.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {
    int boardwidth = 360;
    int boardheight = 540;

    Color gray = new Color(212, 212, 210);
    Color dark = new Color(80, 80, 80);
    Color black = new Color(28, 28, 28);
    Color orange = new Color(255, 149, 0);

    JFrame frame = new JFrame("calculatrice");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    Calculator() {
        frame.setVisible(true);
        frame.setSize(boardwidth, boardheight);
        frame.setLocationRelativeTo(null);// mettre le cadre au centre
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// permet la fermeture de la fenetre
        frame.setLayout(new BorderLayout());// permet de placer les composants de tout les quatres cotes

        displayLabel.setBackground(black);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);
    }
}
