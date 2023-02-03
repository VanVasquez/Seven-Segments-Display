package com.vvv.sevensegments.display;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Segment extends JPanel {
    final HexadecimalNumbers hex = new HexadecimalNumbers();
    Integer number = 0;
    String segments;
    Color color;

    public Segment() {
        color = Color.WHITE;
        setPreferredSize(new Dimension(200, 300));
        setOpaque(false);
        setSegments();
    }


    public void setNumber(Integer number) {
        this.number = number;
        setSegments();
        repaint();
    }

    public String getSegments() {
        return segments;
    }

    public void setSegments() {
        this.segments = intToBinary();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    private String intToBinary() {
        return String.format("%7s", Integer.toBinaryString(hex.getEncodings(number))).replaceAll(" ", "0");
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        char[] segment = segments.toCharArray();
        if (segment[0] != '0') {
            g.fillRect(120, 20, 78, 18);
        }
        if (segment[1] != '0') {
            g.fillRect(200, 40, 18, 98);
        }
        if (segment[2] != '0') {
            g.fillRect(200, 160, 18, 98);
        }
        if (segment[3] != '0') {
            g.fillRect(120, 260, 78, 18);
        }
        if (segment[4] != '0') {
            g.fillRect(90, 160, 18, 98);
        }
        if (segment[5] != '0') {
            g.fillRect(90, 40, 18, 98);
        }
        if (segment[6] != '0') {
            g.fillRect(120, 140, 78, 18);
        }
    }
}

class HexadecimalNumbers {
    private final Map<Integer, Integer> encodings = new HashMap<>();

    public HexadecimalNumbers() {
        encodings.put(0, 0x7E);
        encodings.put(1, 0x30);
        encodings.put(2, 0x6D);
        encodings.put(3, 0x79);
        encodings.put(4, 0x33);
        encodings.put(5, 0x5B);
        encodings.put(6, 0x5F);
        encodings.put(7, 0x70);
        encodings.put(8, 0x7F);
        encodings.put(9, 0x7B);
    }

    public Integer getEncodings(Integer key) {
        key = key % 10;
        return encodings.get(key);
    }
}
