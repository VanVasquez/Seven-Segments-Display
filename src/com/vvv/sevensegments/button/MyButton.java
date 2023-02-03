package com.vvv.sevensegments.button;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String text) {
        setText(text);
        setFont(new Font("Comic Sans", Font.BOLD, 25));
        setFocusable(false);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setHorizontalTextPosition(JButton.CENTER);
        setVerticalTextPosition(JButton.CENTER);
        setPreferredSize(new Dimension(50, 20));
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
    }
    public MyButton(Color color) {
        setBackground(color);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setSize(80, 40);
    }
}
