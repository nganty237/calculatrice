import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
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

    String[] buttonValues = {
            "AC", "+/-", "%", "/",
            "7", "8", "9", "*",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "V", "="
    };
    String[] rightSymbols = { "/", "*", "-", "+", "=" };
    String[] topSymbols = { "AC", "+/-", "%" };

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

        buttonPanel.setLayout(new GridLayout(5, 4));// nouvelle disposition de grid 5 lignes 4 colonnes
        buttonPanel.setBackground(black);
        frame.add(buttonPanel);

        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonvalue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonvalue);
            button.setFocusable(false);// reste cliquable a la souris desactive la selection via le clavier
            button.setBorder(new LineBorder(black));// bordure des button en noire

            if (Arrays.asList(topSymbols).contains(buttonvalue)) {
                button.setBackground(gray);
                button.setForeground(Color.black);// couleur du texte en blanc
            } else if (Arrays.asList(rightSymbols).contains(buttonvalue)) {
                button.setBackground(orange);
                button.setForeground(Color.white);
            } else {
                button.setBackground(dark);
                button.setForeground(Color.white);
            }
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();// e est l'evenement d'action et la source est la
                                                             // provenance de cet evenement clique qui est un boutton
                                                             // JButton
                    String buttonvalue = button.getText();

                    // Arrays.aslist converti le tableau rightSymbols en liste
                    if (Arrays.asList(rightSymbols).contains(buttonvalue)) {

                    } else if (Arrays.asList(topSymbols).contains(buttonvalue)) {
                        // si buttonvalue est dans le tableau topSymbole
                    } else {
                        if (buttonvalue == ".") {

                        } else if ("0123456789".contains(buttonvalue)) {
                            // verifie si buttonvalue est l'un des caracteres de 0-9
                            if (displayLabel.getText().equals("0")) {
                                displayLabel.setText(buttonvalue);// remplace "0" par la valeur du button appuyé
                            } else {
                                displayLabel.setText(displayLabel.getText() + buttonvalue);
                                // Si displayLabel affiche "12" et qu'on appuie sur "3" → "123" permet de
                                // concatener

                            }
                        }
                    }
                }
            });
        }
    }
}
