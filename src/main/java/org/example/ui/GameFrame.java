package org.example.ui;

import org.example.game.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private final GameEngine gameEngine =
            new GameEngine();

    private JTextField input;

    private JLabel answer;

    private JButton button;

    public GameFrame() {

        initializeFrame();

        initializeComponents();

        registerListeners();

        setVisible(true);
    }

    private void initializeFrame() {

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource("/icon.png")
                );

        setIconImage(icon.getImage());

        setTitle("Міста");

        setSize(400, 500);

        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeComponents() {

        input = new JTextField(20);

        answer = new JLabel("Введіть місто");

        button = new JButton("Зробити хід");

        add(input);

        add(button);

        add(answer);
    }

    private void registerListeners() {

        button.addActionListener(
                e -> processMove()
        );
    }

    private void processMove() {

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
                                "Комп'ютер вичерпав усі доступні варіанти відповіді.\n" +
                                "Дякуємо вам за гру!"
                );

                dispose();

                return;
            }

            answer.setText(
                    "Комп'ютер: " + result
            );

            input.setText("");

        } catch (RuntimeException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Помилка",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}