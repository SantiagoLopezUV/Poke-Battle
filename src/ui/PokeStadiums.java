package ui;

import model.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PokeStadiums {
    private JPanel JPanelArena;
    private JPanel JPanelTittle;
    private JLabel lblTittlePoke;
    private JLabel lblPoke;
    private JPanel JPanelRounds;
    private JLabel PanelRound_lblRound;
    private JLabel PanelRound_lblNumberRound;
    private JLabel lblSubTittle;
    private JPanel JPanelLeft;
    private JPanel JPanelCenter;
    private JLabel lbl_Fighter_1;
    private JPanel JPanelTittle_1;
    private JPanel JPanelDetails_1;
    private JLabel lblPoke1;
    private JPanel JPanelBar_1;
    private JPanel JPanelDetailsStats_1;
    private JPanel JPanelLoad_1;
    private JPanel JPanelShow_1;
    private JPanel JPanelName_1;
    private JLabel lbl_Image_1;
    private JLabel lbl_TittleName_1;
    private JTextField tfName_1;
    private JButton RANDOMButton1;
    private JButton LOADButton1;
    private JLabel JPanelName_lblTittleName_1;
    private JLabel JPanelName_SetName_1;
    private JLabel JPanelName_lblTittleType_1;
    private JLabel JPanelName_SetType_1;
    private JLabel JPanelStats_lbl_TittleStats1;
    private JLabel JPanelStats_lbl_TittleHp_1;
    private JLabel JPanelStats_lbl_TittleAttack_1;
    private JLabel JPanelStats_lbl_TittleDefense_1;
    private JLabel JPanelStats_lbl_TittleSpeed_1;
    private JLabel JPanelStats_lblSetHp_1;
    private JLabel JPanelStats_lblSetAttack_1;
    private JLabel JPanelStats_lblSetDefense_1;
    private JLabel JPanelStats_lblSetSpeed_1;
    private JProgressBar JPanelBar_ProgressBar1;
    private JLabel JPanelBar_lblTittleHp_1;
    private JPanel mainPanel;
    private JPanel JPanelRight;
    private JPanel JPanelTittle_2;
    private JPanel JPanelDetails_2;
    private JLabel lbl_Fighter_2;
    private JLabel lblPoke2;
    private JPanel JPanelBar_2;
    private JPanel JPanelDetailsStats_2;
    private JProgressBar JPanelBar_ProgressBar2;
    private JLabel JPanelBar_lblTittleHp_2;
    private JLabel JPanelStats_lbl_TittleStats2;
    private JLabel JPanelStats_lbl_TittleHp_2;
    private JLabel JPanelStats_lbl_TittleAttack_2;
    private JLabel JPanelStats_lbl_TittleDefense_2;
    private JLabel JPanelStats_lbl_TittleSpeed_2;
    private JLabel JPanelStats_lblSetHp_2;
    private JLabel JPanelStats_lblSetAttack_2;
    private JLabel JPanelStats_lblSetDefense_2;
    private JLabel JPanelStats_lblSetSpeed_2;
    private JPanel JPanelLoad_2;
    private JPanel JPanelShow_2;
    private JLabel lbl_TittleName_2;
    private JTextField tfName_2;
    private JButton RANDOMButton2;
    private JButton LOADButton2;
    private JPanel JPanelName_2;
    private JLabel lbl_Image_2;
    private JLabel JPanelName_lblTittleName_2;
    private JLabel JPanelName_SetName_2;
    private JLabel JPanelName_SetType_2;
    private JLabel JPanelName_lblTittleType_2;
    private JLabel lbl_VS;
    private JButton FIGHTButton;
    private JTextArea taRegisterBattle;
    private JLabel lbl_TittleRegisterBattle;
    private JPanel JPanelBattle;

    public PokeStadiums() {
        ImageIcon original = new ImageIcon(getClass().getResource("/ui/resources/pokebola.png"));
        Image escalada = original.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        lblPoke.setIcon(new ImageIcon(escalada));
        lbl_Fighter_1.setIcon(new ImageIcon(original.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        lbl_Fighter_2.setIcon(new ImageIcon(original.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

        String placeHolderWritePoke = "Escribe un Pokemon";
        this.tfName_1.setText(placeHolderWritePoke);
        this.tfName_1.setForeground(Color.GRAY);
        this.tfName_2.setText(placeHolderWritePoke);
        this.tfName_2.setForeground(Color.GRAY);

        this.tfName_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                if(tfName_1.getText().equals(placeHolderWritePoke)){
                    tfName_1.setText("");
                    tfName_1.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (tfName_1.getText().isBlank()){
                    tfName_1.setText(placeHolderWritePoke);
                    tfName_1.setForeground(Color.GRAY);
                }
            }
        });

        this.tfName_2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e){
                if(tfName_2.getText().equals(placeHolderWritePoke)){
                    tfName_2.setText("");
                    tfName_2.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e){
                if (tfName_2.getText().isBlank()){
                    tfName_2.setText(placeHolderWritePoke);
                    tfName_2.setForeground(Color.GRAY);
                }
            }
        });


        LOADButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namePokeSelected = tfName_1.getText();
                Pokemon poke1 = new Pokemon().getPoke(namePokeSelected);
                showPokemon1(poke1);
            }
        });

        LOADButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String namePokeSelected = tfName_2.getText();
                Pokemon poke2 = new Pokemon().getPoke(namePokeSelected);
                showPokemon2(poke2);
            }
        });
    }

    private void loadProgressBar(JProgressBar ProgressBar, Pokemon poke) {
        ProgressBar.setMinimum(0);
        ProgressBar.setMaximum(poke.getHp());
        ProgressBar.setValue(poke.getCurrentHp());
        ProgressBar.setStringPainted(true);
        ProgressBar.setString(poke.getCurrentHp() + "/" + poke.getHp());
    }

    private void showPokemon1(Pokemon p1){
        JPanelName_SetName_1.setText(p1.getName());
        JPanelName_SetType_1.setText(p1.getType());
        JPanelStats_lblSetAttack_1.setText(String.valueOf(p1.getAttack()));
        JPanelStats_lblSetDefense_1.setText(String.valueOf(p1.getDefense()));
        JPanelStats_lblSetHp_1.setText(String.valueOf(p1.getHp()));
        JPanelStats_lblSetSpeed_1.setText(String.valueOf(p1.getSpeed()));
        loadProgressBar(JPanelBar_ProgressBar1, p1);
    }

    private void showPokemon2(Pokemon p2){
        JPanelName_SetName_2.setText(p2.getName());
        JPanelName_SetType_2.setText(p2.getType());
        JPanelStats_lblSetAttack_2.setText(String.valueOf(p2.getAttack()));
        JPanelStats_lblSetDefense_2.setText(String.valueOf(p2.getDefense()));
        JPanelStats_lblSetHp_2.setText(String.valueOf(p2.getHp()));
        JPanelStats_lblSetSpeed_2.setText(String.valueOf(p2.getSpeed()));
        loadProgressBar(JPanelBar_ProgressBar2, p2);
    }

    static void main() {
        JFrame frame = new JFrame("PokeApi");
        frame.setContentPane(new PokeStadiums().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);


    }
}

