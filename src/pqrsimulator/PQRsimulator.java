package pqrsimulator;

import Formularios.MainFrame;

public class PQRsimulator {  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {             
        MainFrame mainFrame = new MainFrame();
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.show();
    }    
}
