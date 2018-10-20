package pqrsimulator;

import Formularios.MainFrame;
import jdk.nashorn.internal.codegen.CompilerConstants;

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
