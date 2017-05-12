/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizationstudy;

import java.io.BufferedWriter;
import java.io.File;
import static java.io.File.separatorChar;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xchal
 */
public class Saver extends Thread {

    private String export;
    long duration;

    Saver(String export) {
        this.export = export;
        this.duration = duration;
    }

    @Override
    public void run() {       
        try {
            long timeStamp = System.currentTimeMillis();
            PrintWriter out = new PrintWriter("." + separatorChar + "results" + timeStamp + ".txt");
            out.write(export);
            out.close();

            FTPUploader uploader = new FTPUploader("files.000webhost.com", "fidentis", "fidentis");
            uploader.uploadFile("." + separatorChar + "results" + timeStamp + ".txt", "results" + timeStamp + ".txt", "/visualizationStudy/");
        } catch (FileNotFoundException ex) {
        } catch (Exception ex) {
        }
        
        System.exit(0);
    }
    
}
