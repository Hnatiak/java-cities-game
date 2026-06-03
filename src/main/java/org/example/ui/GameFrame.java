package org.example.ui;

import org.example.game.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private final GameEngine gameEngine =
            new GameEngine();

    public GameFrame() {

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource("/icon.png")
                );

        setIconImage(icon.getImage());

        setTitle("Міста");

        setSize(400, 500);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JTextField input =
                new JTextField(20);

        JLabel answer =
                new JLabel("Введіть місто");

        JButton button =
                new JButton("Зробити хід");

        add(input);
        add(button);
        add(answer);

        button.addActionListener(e -> {

            String city = input.getText().trim();

            if ("здаюсь".equalsIgnoreCase(city)) {

                JOptionPane.showMessageDialog(
                        this,
                        "🏆 Комп'ютер переміг!\n\n" +
                                "Ваш рахунок: " +
                                gameEngine.getScore()
                );

                dispose();

                return;
            }

            try {

                String result =
                        gameEngine.makeMove(city);

                if (result == null) {

                    JOptionPane.showMessageDialog(
                            this,
                            "🏆 Ви перемогли!\n\n" +
                                    "Ваш рахунок: " +
                                    gameEngine.getScore() +
                                    "\n\n" +
                                    "У грі було використано " +
                                    gameEngine.getUsedCitiesCount() +
                                    " з 461 різних міст.\n\n" +
                                    "Комп'ютер вичерпав усі доступні варіанти відповіді. Та ви геній!\n" +
                                    "Дякуємо вам за гру!"
                    );

                    dispose();

                    return;
                }

                answer.setText("Комп'ютер: " + result);

                input.setText("");

            } catch (IllegalArgumentException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage(),
                        "Помилка",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }
}