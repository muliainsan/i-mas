
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author insan
 */
public class Biometric {
    int idf;
    byte[] tmp;

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public byte[] getTmp() {
        return tmp;
    }

    public void setTmp(byte[] tmp) {
        this.tmp = tmp;
    }

    public Biometric(int idf, byte[] tmp) {
        this.idf = idf;
        this.tmp = tmp;
    }

        
}
