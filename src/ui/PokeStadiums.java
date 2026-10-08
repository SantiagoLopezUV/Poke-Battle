package ui;

import java.util.List;
import java.util.ArrayList;

import api.LoadPokemon;
import api.PokeApiClient;
import exceptions.PokemonException;
import model.Pokemon;

import battle.BattleListener;
import battle.Battle;
import battle.BattleListener;

import java.util.ArrayList;
import java.util.Random;

import java.net.URL;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PokeStadiums implements BattleListener {
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
    public JPanel mainPanel;
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
    private JScrollPane JScrollPanelBattle;

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private final Random random = new Random();

    private boolean fightLocked = false; // true mientras hay un ganador pendiente de nuevo combate
    private final List<TurnStep> shifts = new ArrayList<>();
    private String winnerPending;

    private static final PokeApiClient apiClient = new PokeApiClient();

    public PokeStadiums() {

        ImageIcon original = new ImageIcon(getClass().getResource("/ui/resources/pokebola.png"));
        Image climbing = original.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        lblPoke.setIcon(new ImageIcon(climbing));
        lbl_Fighter_1.setIcon(new ImageIcon(original.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        lbl_Fighter_2.setIcon(new ImageIcon(original.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

        DefaultCaret caret = (DefaultCaret) taRegisterBattle.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        FIGHTButton.setEnabled(false);

        String placeHolderWritePoke = "Escribe un Pokemon";
        this.tfName_1.setText(placeHolderWritePoke);
        this.tfName_1.setForeground(Color.GRAY);
        this.tfName_2.setText(placeHolderWritePoke);
        this.tfName_2.setForeground(Color.GRAY);

        this.tfName_1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfName_1.getText().equals(placeHolderWritePoke)) {
                    tfName_1.setText("");
                    tfName_1.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfName_1.getText().isBlank()) {
                    tfName_1.setText(placeHolderWritePoke);
                    tfName_1.setForeground(Color.GRAY);
                }
            }
        });

        this.tfName_2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfName_2.getText().equals(placeHolderWritePoke)) {
                    tfName_2.setText("");
                    tfName_2.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfName_2.getText().isBlank()) {
                    tfName_2.setText(placeHolderWritePoke);
                    tfName_2.setForeground(Color.GRAY);
                }
            }
        });
        LOADButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPokemon(tfName_1.getText().trim(), 1);
            }
        });
        LOADButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPokemon(tfName_2.getText().trim(), 2);
            }
        });
        RANDOMButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int randomId = 1 + random.nextInt(151); // primera generación, 1-151
                loadPokemon(String.valueOf(randomId), 1);
            }
        });
        RANDOMButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int randomId = 1 + random.nextInt(151); // primera generación, 1-151
                loadPokemon(String.valueOf(randomId), 2);
            }
        });
        FIGHTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                initBattle();
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

    private void showPokemon1(Pokemon p1) {
        JPanelName_SetName_1.setText(p1.getName());
        JPanelName_SetType_1.setText(p1.getType());
        JPanelStats_lblSetAttack_1.setText(String.valueOf(p1.getAttack()));
        JPanelStats_lblSetDefense_1.setText(String.valueOf(p1.getDefense()));
        JPanelStats_lblSetHp_1.setText(String.valueOf(p1.getHp()));
        JPanelStats_lblSetSpeed_1.setText(String.valueOf(p1.getSpeed()));
        loadProgressBar(JPanelBar_ProgressBar1, p1);
    }

    private void showPokemon2(Pokemon p2) {
        JPanelName_SetName_2.setText(p2.getName());
        JPanelName_SetType_2.setText(p2.getType());
        JPanelStats_lblSetAttack_2.setText(String.valueOf(p2.getAttack()));
        JPanelStats_lblSetDefense_2.setText(String.valueOf(p2.getDefense()));
        JPanelStats_lblSetHp_2.setText(String.valueOf(p2.getHp()));
        JPanelStats_lblSetSpeed_2.setText(String.valueOf(p2.getSpeed()));
        loadProgressBar(JPanelBar_ProgressBar2, p2);
    }

    private void loadPokemon(String name, int numPlayer) {//metodo para cargar el pokemon

        if (name == null || name.isBlank() || name.equalsIgnoreCase("Escribe un pokemon")) {
            JOptionPane.showMessageDialog(null, new PokemonException.InvalidName().getMessage());
            return;
        }
        SwingWorker<loadResult, Void> worker = new SwingWorker<>() {
            @Override
            protected loadResult doInBackground() throws Exception {
                // Todo lo lento (red) va aquí, fuera del EDT
                Pokemon pokemon = LoadPokemon.load(name);
                ImageIcon sprite = new ImageIcon(new URL(pokemon.getUrlSprite()));
                return new loadResult(pokemon, sprite);
            }

            @Override
            protected void done() {
                loadButtons(numPlayer, true);
                try {
                    loadResult result = get();
                    //cargar el pokemon
                    if (numPlayer == 1) {
                        pokemon1 = result.pokemon;
                        showPokemon1(result.pokemon);
                        lbl_Image_1.setIcon(result.sprite);
                    } else {
                        pokemon2 = result.pokemon;
                        showPokemon2(result.pokemon);
                        lbl_Image_2.setIcon(result.sprite);
                    }
                    fightLocked = false; // cargar un Pokémon nuevo siempre reactiva la posibilidad de pelear
                    updateFightButton(); //activar boton de pelea
                } catch (Exception ex) {
                    //causa del error desde background
                    Throwable cause = (ex.getCause() != null) ? ex.getCause() : ex;
                    if (cause instanceof PokemonException.NotFound) {
                        JOptionPane.showMessageDialog(null, cause.getMessage(), "Pokémon No encontrado", JOptionPane.WARNING_MESSAGE);
                    } else if (cause instanceof PokemonException.ApiError) {
                        JOptionPane.showMessageDialog(null, cause.getMessage(), "Error de Servidor PokeAPI", JOptionPane.ERROR_MESSAGE);
                    } else if (cause instanceof PokemonException.InvalidName) {
                        JOptionPane.showMessageDialog(null, cause.getMessage(), "Nombre inválido", JOptionPane.WARNING_MESSAGE);
                    } else if (cause instanceof PokemonException) {
                        JOptionPane.showMessageDialog(null, cause.getMessage(), "Error de Pokémon", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error inesperado: " + cause.getMessage(), "Error General", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        };
        worker.execute();
    }

    private void loadButtons(int numPlayer, boolean habilitado) {
        if (numPlayer == 1) {
            LOADButton1.setEnabled(habilitado);
            RANDOMButton1.setEnabled(habilitado);
        } else {
            LOADButton2.setEnabled(habilitado);
            RANDOMButton2.setEnabled(habilitado);
        }
    }

    private void updateFightButton() {
        FIGHTButton.setEnabled(pokemon1 != null && pokemon2 != null && !fightLocked);
    }

    private void initBattle() {
        if (pokemon1 == null || pokemon2 == null) {
            return;
        }
        taRegisterBattle.setText(""); // limpiar los logs cuando se reinice
        shifts.clear(); //limpiar los turnos
        winnerPending = null;

        // reiniciar el HP por si esocgen los mismos pokemones
        pokemon1.setCurrentHp(pokemon1.getHp());
        pokemon2.setCurrentHp(pokemon2.getHp());
        loadProgressBar(JPanelBar_ProgressBar1, pokemon1);
        loadProgressBar(JPanelBar_ProgressBar2, pokemon2);

        FIGHTButton.setEnabled(false); // se desactiva mientras pelean

        //iniciar la batalla
        Battle battle = new Battle(pokemon1, pokemon2);
        battle.addBattleListener(this);
        battle.start();

        playBattle();
    }

    // funcion complementaria para
    private static class TurnStep {
        final String attacker;
        final String defender;
        final int damage;
        final boolean critical;
        final double modifier;
        int hpAfter; // se completa cuando llega el onHpChanged correspondiente

        TurnStep(String attacker, String defender, int damage, boolean critical, double modifier) {
            this.attacker = attacker;
            this.defender = defender;
            this.damage = damage;
            this.critical = critical;
            this.modifier = modifier;
        }
    }

    //cargar imagen en segundo plano
    private static class loadResult {
        final Pokemon pokemon;
        final ImageIcon sprite;

        loadResult(Pokemon pokemon, ImageIcon sprite) {
            this.pokemon = pokemon;
            this.sprite = sprite;
        }
    }

    private static final int MILLISECONDS_BETWEEN_SHIFTS = 900;

    private void playBattle() {
        Timer timer = new Timer(MILLISECONDS_BETWEEN_SHIFTS, null);
        timer.addActionListener(new ActionListener() {
            private int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < shifts.size()) {
                    showTurn(shifts.get(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                    battleEnd();
                }
            }
        });
        timer.start();
    }

    private void showTurn(TurnStep shifts) {

        StringBuilder line = new StringBuilder();
        line.append(shifts.attacker).append(" ataca a ").append(shifts.defender)
                .append(" causando ").append(shifts.damage).append(" de daño");

        if (shifts.critical) line.append(" ¡Golpe crítico! ");
        if (shifts.modifier > 1.0) line.append(" Letal ");
        else if (shifts.modifier < 1.0) line.append(" Leve ");

        line.append("\n");
        taRegisterBattle.append(line.toString());
        taRegisterBattle.setCaretPosition(taRegisterBattle.getDocument().getLength());

        // la barra de HP baja en el mismo tiempo que aparece el log del ataque
        if (pokemon1.getName().equalsIgnoreCase(shifts.defender)) {
            pokemon1.setCurrentHp(shifts.hpAfter);
            loadProgressBar(JPanelBar_ProgressBar1, pokemon1);
        } else if (pokemon2.getName().equalsIgnoreCase(shifts.defender)) {
            pokemon2.setCurrentHp(shifts.hpAfter);
            loadProgressBar(JPanelBar_ProgressBar2, pokemon2);
        }
    }

    private void battleEnd() {
        taRegisterBattle.append("\n¡" + winnerPending + " gana la batalla!\n");
        taRegisterBattle.setCaretPosition(taRegisterBattle.getDocument().getLength());
        JOptionPane.showMessageDialog(null,
                winnerPending + " gana la batalla!",
                "Combate finalizado",
                JOptionPane.INFORMATION_MESSAGE);
        fightLocked = true;// se mantiene así hasta que se cargue un Pokémon nuevo, por Load o Random
        // FIGHTButton queda  deshabilitado
    }


    @Override
    public void onTurn(String attacker, String defender, int damage, boolean critical, double modifier) {
        shifts.add(new TurnStep(attacker, defender, damage, critical, modifier));
    }

    @Override
    public void onHpChanged(String pokemon, int hpCurrent) {
        if (!shifts.isEmpty()) {
            shifts.get(shifts.size() - 1).hpAfter = hpCurrent;
        }
    }

    @Override
    public void onBattleEnded(String winner) {
        winnerPending = winner;
    }





}

