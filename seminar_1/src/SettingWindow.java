import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WIDTH = 250;
    private static final int HEIGHT = 300;

    private int MODE = 0;
    private int SIZE = 3;
    private int WIN_LEN;

    JButton btnStart;


    SettingWindow(GameWindow gameWindow) {
        btnStart = new JButton("Start new game");

        setLocationRelativeTo(gameWindow);
        setSize(WIDTH, HEIGHT);

        JPanel settings = new JPanel(new GridLayout(3,1));
        settings.add(createModePanel());
        settings.add(createChoiceSize());
        settings.add(createChoiceWinLen());

        add(settings);
        add(btnStart, BorderLayout.SOUTH);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                if (WIN_LEN > SIZE) WIN_LEN = SIZE;
                gameWindow.startNewGame(MODE, SIZE, SIZE, WIN_LEN);
            }
        });


    }

    private JPanel createModePanel() {
        JPanel modePanel = new JPanel(new GridLayout(3,1));

        modePanel.add(new JLabel("Выберите режим игры"));
        JRadioButton rdbAiMode = new JRadioButton("Человек против компьютера", true);
        JRadioButton rdbHumanMode = new JRadioButton("Человек против компьютера");
        ButtonGroup btnGrMode = new ButtonGroup();
        btnGrMode.add(rdbAiMode);
        btnGrMode.add(rdbHumanMode);
        modePanel.add(rdbAiMode);
        modePanel.add(rdbHumanMode);

        rdbAiMode.addActionListener(e -> MODE = 0);
        rdbHumanMode.addActionListener(e -> MODE = 1);

        return modePanel;
    }

    private JPanel createChoiceSize() {
        JPanel sizePanel = new JPanel(new GridLayout(3,1));
        sizePanel.add(new JLabel("Выберите размеры поля"));
        JSlider size = new JSlider(3,10,SIZE);
        size.setMinorTickSpacing(1);
        size.setPaintTicks(true);
        JLabel labelSize = new JLabel("Выбранный размер: " + size.getValue());
        size.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                SIZE = size.getValue();
                labelSize.setText("Выбранный размер: " + size.getValue());
            }
        });
        sizePanel.add(labelSize);
        sizePanel.add(size);
        return sizePanel;
    }

    private JPanel createChoiceWinLen() {
        JPanel winLenPanel = new JPanel(new GridLayout(3,1));
        winLenPanel.add(new JLabel("Выберите длину для победы"));
        JSlider setWinLen = new JSlider(3,10,3);
        JLabel labelWinLen = new JLabel("Выбранный размер:" + setWinLen.getValue());
        setWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (setWinLen.getValue() > SIZE) {
                    setWinLen.setValue(SIZE);
                    WIN_LEN = SIZE;
                }
                WIN_LEN = setWinLen.getValue();
                labelWinLen.setText("Выбранный размер:" + setWinLen.getValue());
            }
        });
        setWinLen.setMinorTickSpacing(1);
        setWinLen.setPaintTicks(true);
        winLenPanel.add(labelWinLen);
        winLenPanel.add(setWinLen);
        return winLenPanel;
    }
}
