package com.codecool.java.cheatCardGame.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Button;
import javax.swing.JFrame;
import java.lang.Character;

public class KeyReader extends JFrame implements KeyListener {

    private KeyEvent keyEvent;
    private View view;


    public KeyReader(View view) {
        super("");
        this.view = view;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        Button i = new Button("button");
        i.addKeyListener(this);
        char a = (char) 97;
        add(i);
    }

    public void keyPressed(KeyEvent e) {
        if (Character.toString(e.getKeyChar()).equalsIgnoreCase("a")) {
            view.setHighlightedPlayerMove("\u001B[46m1) Throw a card  \u001B[0m", "  2) Check stack");
            view.showCurrentGameStage();
        } else if (Character.toString(e.getKeyChar()).equalsIgnoreCase("d")) {
            view.setHighlightedPlayerMove("1) Throw a card  ", "\u001B[46m  2) Check stack\u001B[0m");
            view.showCurrentGameStage();
        }
    }

    public void keyReleased(KeyEvent e) {
        //System.out.println("key released");
    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("as");
    }
}
