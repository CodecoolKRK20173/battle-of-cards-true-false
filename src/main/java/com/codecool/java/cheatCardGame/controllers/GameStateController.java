package com.codecool.java.cheatCardGame.controllers;

import com.codecool.java.cheatCardGame.models.GDrive;
import com.google.api.services.drive.Drive;
import java.io.IOException;


public class GameStateController {

    private String fileId;
    private String fileName;
    private Drive service;

    public GameStateController(String fileName) {
        this.fileName = fileName;
        try {
            this.service = GDrive.getDriveService();
            this.fileId = GDrive.getFileId(this.service, this.fileName);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public String getGameState() {
        return GDrive.getFileContent(this.service, this.fileId);
    }

    public void updateGameState(String fileContent) {
        if(GDrive.removeFile(this.service, this.fileId)) {
            this.fileId = GDrive.setNewFile(this.service, this.fileName, fileContent);
        }
    }

    public String getFileId() {
        return this.fileId;
    }




}
