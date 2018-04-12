package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.view.View;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Button;
import javax.swing.JFrame;
import java.lang.Character;

public class KeyReader extends JFrame implements KeyListener {

    private View view;


    public KeyReader(View view) {
        super("");
        this.view = view;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        add(getHiddenButton());
    }

    public void keyPressed(KeyEvent e) {
        String highlightedPlayerMove1 = "\u001B[46m1) Throw a card  \u001B[0m";
        String highlightedPlayerMove2 = "\u001B[46m  2) Check stack\u001B[0m";
        if (Character.toString(e.getKeyChar()).equalsIgnoreCase("a")) {
            view.setHighlightedPlayerMove(highlightedPlayerMove1, "  2) Check stack");
            view.showCurrentGameStage();
        } else if (Character.toString(e.getKeyChar()).equalsIgnoreCase("d")) {
            view.setHighlightedPlayerMove("1) Throw a card  ", highlightedPlayerMove2);
            view.showCurrentGameStage();
        } else if (e.getKeyCode() == 10) {
            view.showPlayerMove(highlightedPlayerMove1, highlightedPlayerMove2);
        }
    }

    private Button getHiddenButton() {
        Button hiddenButton = new Button("button");
        hiddenButton.addKeyListener(this);
        return hiddenButton;
    }

    public void keyReleased(KeyEvent e) {
        //System.out.println("key released");
    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("as");
    }
}
