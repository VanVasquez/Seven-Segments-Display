package com.vvv.sevensegments;

import com.vvv.sevensegments.button.MyButton;
import com.vvv.sevensegments.display.Segment;
import com.vvv.sevensegments.frame.MyFrame;
import com.vvv.sevensegments.panel.MyPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static boolean is_running = false;
    static int numberInSegment = 0;
    static int elapsedTime = 0;
    static Actions actionHandler = new Actions();
    static Segment left_num = new Segment();
    static Segment right_num = new Segment();
    static Timer timer = new Timer(1000, new Actions() {
        public void actionPerformed(ActionEvent e) {
            numberInSegment = 0;
            elapsedTime = elapsedTime + 1000;
            numberInSegment = (elapsedTime / 1000) % 60;
            left_num.setNumber(numberInSegment / 10);
            right_num.setNumber(numberInSegment % 10);
        }
    });
    public static void main(String[] args) {

        MyButton inc_button = new MyButton(">>");
                inc_button.setActionCommand("inc");
                inc_button.addActionListener(actionHandler);
        MyButton dec_button = new MyButton("<<");
                dec_button.setActionCommand("dec");
                dec_button.addActionListener(actionHandler);
        MyButton auto_button = new MyButton("auto");
                auto_button.setActionCommand("auto");
                auto_button.addActionListener(actionHandler);
        MyButton yellow_button = new MyButton(Color.YELLOW);
                yellow_button.setActionCommand("yellow");
                yellow_button.addActionListener(actionHandler);
        MyButton blue_button = new MyButton(Color.BLUE);
                blue_button.setActionCommand("blue");
                blue_button.addActionListener(actionHandler);
        MyButton green_button = new MyButton(Color.GREEN);
                green_button.setActionCommand("green");
                green_button.addActionListener(actionHandler);
        MyPanel num_buttons_panel = new MyPanel(new Dimension(0, 100));
                num_buttons_panel.setLayout(new GridLayout(1, 3, 10, 20));
                num_buttons_panel.setBorder(new EmptyBorder(10, 50, 10 , 50));
                num_buttons_panel.add(dec_button);
                num_buttons_panel.add(auto_button);
                num_buttons_panel.add(inc_button);

        MyPanel color_buttons_panel = new MyPanel(new Dimension(600, 100));
                color_buttons_panel.setLayout(new GridLayout(1, 3, 10, 10));
                color_buttons_panel.setBorder(new EmptyBorder(10, 10, 10, 10));
                color_buttons_panel.add(yellow_button);
                color_buttons_panel.add(blue_button);
                color_buttons_panel.add(green_button);

        MyPanel main_screen = new MyPanel(new Dimension(0, 562));
                main_screen.setBackground(Color.BLACK);
                main_screen.setLayout(new GridLayout(1, 2));
                main_screen.setBorder(new EmptyBorder(100, 50, 0, 100));
                main_screen.add(left_num);
                main_screen.add(right_num);

        MyPanel secondary_screen = new MyPanel(new Dimension(0, 200));
                secondary_screen.setBackground(Color.BLACK);
                secondary_screen.setLayout(new GridLayout(2, 1));
                secondary_screen.setBorder(new EmptyBorder(10, 0, 10, 0));
                secondary_screen.add(num_buttons_panel);
                secondary_screen.add(color_buttons_panel);

        MyFrame frame = new MyFrame();
                frame.add(main_screen, BorderLayout.NORTH);
                frame.add(secondary_screen, BorderLayout.SOUTH);


    }
    public static class Actions implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            switch (action) {
                case "inc" -> {
                    numberInSegment++;
                    left_num.setNumber(numberInSegment / 10);
                    right_num.setNumber(numberInSegment % 10);
                }
                case "dec" -> {
                    if (numberInSegment >= 1)
                        numberInSegment--;
                    left_num.setNumber(numberInSegment / 10);
                    right_num.setNumber(numberInSegment % 10);
                }
                case "auto" -> {
                    elapsedTime = 0;
                    if(!is_running) {
                        start();
                        is_running = true;
                    } else {
                        stop();
                        is_running = false;
                    }
                }
                case "yellow" -> {
                    left_num.setColor(Color.YELLOW);
                    right_num.setColor(Color.YELLOW);
                }
                case "blue" -> {
                    left_num.setColor(Color.BLUE);
                    right_num.setColor(Color.BLUE);
                }
                case "green" -> {
                    left_num.setColor(Color.GREEN);
                    right_num.setColor(Color.GREEN);
                }
            }
        }
        public void start(){
            timer.start();
        }
        public void stop() {
            timer.stop();
        }
    }
}