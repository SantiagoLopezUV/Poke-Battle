import ui.PokeStadiums;

import javax.swing.*;

void main() {
  SwingUtilities.invokeLater(() -> {
    JFrame frame = new JFrame("PokeApi");
    frame.setContentPane(new PokeStadiums().mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null); // después de pack() y antes de setVisible()
    frame.setResizable(true);
    frame.setVisible(true);
  });
}
