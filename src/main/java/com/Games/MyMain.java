package com.Games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MyMain {
    static int delay;
    static int onGame = 0; //0 is not started, 1 is ingame, 2 is GAME OVER
    static int wid = 750;
    static int hei = 860;
    public static void main(String[] args) {
        JFrame window  = new JFrame("SNAKE");

        CanvasPanel canvasPanel = new CanvasPanel();
        delay = canvasPanel.score/100;

        JMenuBar jMenubar = new JMenuBar();
        window.setJMenuBar(jMenubar);
        JMenu Settings = new JMenu("Settings");
        jMenubar.add(Settings);
        JMenuItem Restart = Settings.add("Restart?");
        Restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canvasPanel.init();
                canvasPanel.direct = 0;
                onGame = 1;
            }
        });
        window.setPreferredSize(new Dimension(wid, hei));

        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'w' && canvasPanel.canGoNorth == true) {
                    canvasPanel.direct = 3;
                }
                if (e.getKeyChar() == 'a' && canvasPanel.canGoEast == true) {
                    canvasPanel.direct = 1;
                }
                if (e.getKeyChar() == 's' && canvasPanel.canGoSouth == true) {
                    canvasPanel.direct = 0;
                }
                if (e.getKeyChar() == 'd' && canvasPanel.canGoWest == true) {
                    canvasPanel.direct = 2;
                }
                if (e.getKeyChar() == ' ' && onGame == 0) {
                    onGame = 1;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Thread t = new Thread(()->{
        while (true) {
            try {
                if (100-(delay) < 60) {
                    delay = 40;
                }
                Thread.sleep(100-(delay));
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            canvasPanel.movegame();
            canvasPanel.repaint();
        }
        });
        t.start();
        window.getContentPane().add(canvasPanel, BorderLayout.CENTER);
        canvasPanel.setPreferredSize(new Dimension(wid, hei));

        window.pack();
        window.setVisible(true);

    }
}
