package threads;

import javafx.application.Platform;
import ui.ControllerGUI;

import java.io.IOException;

public class ProgressBarThread extends Thread {

    private final ControllerGUI controllerGUI;

    public ProgressBarThread(ControllerGUI controllerGUI) {
        this.controllerGUI = controllerGUI;
    }

//    @Override
//    public void run() {
//
//        int sec = 60;
//        int milliseconds = 0;
//        int width = 0;
//        boolean active = true;
//
//        while(active) {
//
//            try {
//                Thread.sleep(4);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            milliseconds += 4;
//
//            if(milliseconds == 1000) {
//
//                milliseconds = 0;
//                sec--;
//                width = 5;
//
//                controllerGUI.changeProgressBar(width);
//
//                Platform.runLater(new Thread() {
//
//                    public void run() {
//
//                        try {
//                            controllerGUI.changeTimer();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//
//                if(sec == 0) {
//
//                    active = false;
//                }
//            }
//        }
//    }
}