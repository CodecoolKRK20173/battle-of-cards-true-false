package com.codecool.java.cheatCardGame.models;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.*;
import com.google.api.services.drive.Drive;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class GDrive {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME =
            "Cheat Card Game";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/cheat-game-api-credentials");


    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     * <p>
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/drive-java-quickstart
     */
    private static final List<String> SCOPES =
            Arrays.asList(DriveScopes.DRIVE);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     *
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        String key = "{\"installed\":{\"client_id\":\"768306259393-sssosccv1q3lt3vlv0b9i3ktq6qhgbkr.apps.googleusercontent.com\",\"project_id\":\"nifty-buffer-200612\",\"auth_uri\":\"https://accounts.google.com/o/oauth2/auth\",\"token_uri\":\"https://accounts.google.com/o/oauth2/token\",\"auth_provider_x509_cert_url\":\"https://www.googleapis.com/oauth2/v1/certs\",\"client_secret\":\"zLvkr7DbC9stGQlPWCtjZ-Om\",\"redirect_uris\":[\"urn:ietf:wg:oauth:2.0:oob\",\"http://localhost\"]}}";
        InputStream in = new ByteArrayInputStream(key.getBytes(StandardCharsets.UTF_8));


        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Drive client service.
     *
     * @return an authorized Drive client service
     * @throws IOException
     */
    public static Drive getDriveService() throws IOException {
        Credential credential = authorize();
        return new Drive.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static String getGameStateFile(String id) throws IOException {
        Drive service = getDriveService();

        String fileId = id;
        OutputStream outputStream = new ByteArrayOutputStream();
        service.files().get(fileId).executeMediaAndDownloadTo(outputStream);

        return outputStream.toString();
    }

    public static String updateFile(Drive service, String fileId, String fileName, String fileContent) {
        try {
            removeFile(service, fileId);

            File fileMetadata = new File();
            fileMetadata.setName(fileName);
            // fileMetadata.setParents(Collections.singletonList("kk"));

            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println(fileContent);
            writer.close();

            java.io.File filePath = new java.io.File(fileName);
            FileContent mediaContent = new FileContent("application/json", filePath);
            File file = service.files().create(fileMetadata, mediaContent).setFields("id").execute();

            return file.getId();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static boolean removeFile(Drive service, String fileId) {
        try {
            service.files().delete(fileId).execute();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void setCofigFile(Drive service, String fileId, String content) throws IOException {

        File fileMetadata = new File();
        fileMetadata.setName("config.json");
        // fileMetadata.setParents(Collections.singletonList("kk"));

        PrintWriter writer = new PrintWriter("config.json", "UTF-8");
        writer.println(content);
        writer.close();

        java.io.File filePath = new java.io.File("config.json");
        FileContent mediaContent = new FileContent("application/json", filePath);
        File file = service.files().create(fileMetadata, mediaContent).setFields("id").execute();
        System.out.println("File ID: " + file.getId());
    }

    public static String getFileId(Drive service, String fileId) throws IOException {
        String configID = null;
        FileList result = service.files().list()
                .setPageSize(10)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        List<File> files = result.getFiles();
        if (files == null || files.size() == 0) {
            System.out.println("No files found.");
        } else {
            for (File file : files) {
                if (file.getName().equals(fileId)) {
                    configID = file.getId();
                    break;
                }
            }
        }
        return configID;
    }

    public static File updateFile(Drive service,
                                  String fileId,
                                  String newDescription,
                                  String newMimeType,
                                  String newFilename) {
        try {

            // First retrieve the file from the API.
            File file = service.files().get(fileId).execute();

            // File's new metadata.
            file.setDescription(newDescription);
            file.setMimeType(newMimeType);

            // File's new content.
            java.io.File fileContent = new java.io.File("config.json");


            PrintWriter writer = new PrintWriter("config.json", "UTF-8");
            writer.println(newFilename);
            writer.close();

            FileContent mediaContent = new FileContent(newMimeType, fileContent);

            // Send the request to the API.
            File updatedFile = service.files().update(fileId, file, mediaContent).execute();

            return updatedFile;
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            return null;
        }
    }

}

// public static void main(String[] args) throws IOException {
// Build a new authorized API client service.

// // Print the names and IDs for up to 10 files.
// FileList result = service.files().list()
//      .setPageSize(10)
//      .setFields("nextPageToken, files(id, name)")
//      .execute();
// List<File> files = result.getFiles();
// if (files == null || files.size() == 0) {
//     System.out.println("No files found.");
// } else {
//     System.out.println("Files:");
//     for (File file : files) {
//         // System.out.printf("%s (%s)\n", file.getName(), file.getId());
//     }
// }


// String fileId = "1HkRkQHitIWOlets9uRhlm5ObrWXIw62g";
// OutputStream outputStream = new ByteArrayOutputStream();
// service.files().get(fileId).executeMediaAndDownloadTo(outputStream);


// System.out.println(getGameStateFile("1gwSIY-CjJsZvhM7cHT4Q-O5pQReV_VYu"));
// }