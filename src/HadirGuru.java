
import SecuGen.FDxSDKPro.jni.JSGFPLib;
import SecuGen.FDxSDKPro.jni.SGDeviceInfoParam;
import SecuGen.FDxSDKPro.jni.SGFDxErrorCode;
import SecuGen.FDxSDKPro.jni.SGFDxSecurityLevel;
import SecuGen.FDxSDKPro.jni.SGFingerInfo;
import SecuGen.FDxSDKPro.jni.SGFingerPosition;
import SecuGen.FDxSDKPro.jni.SGImpressionType;
import java.awt.FlowLayout;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author insan
 */
public class HadirGuru extends javax.swing.JFrame {

    /**
     * Creates new form Hadir2
     */
    public HadirGuru() {
        initComponents();
    }

    public HadirGuru(db db) {
        setUndecorated(true);
        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
        myinitComponents(db);
//        Kehadiran();
    }

    private void myinitComponents(db db1) {
//        tidakketemu1.setVisible(false);
//tempelkanjari.setVisible(false);
        db = db1;
        guru = db.getGuru();
        System.out.println(guru.size());
        if (!guru.isEmpty()) {
            biometric = db.getBiometric();
            admin = db.getAdmin();
            bioGuru = db.getBioguru();
        }

        System.out.println(biometric);
        System.out.println(admin);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Scan = new javax.swing.JLabel();
        tempelkanjari = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        utama = new javax.swing.JLabel();
        jam = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hadir scan.png"))); // NOI18N
        Scan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ScanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ScanMouseReleased(evt);
            }
        });
        getContentPane().add(Scan);
        Scan.setBounds(90, 180, 280, 330);

        tempelkanjari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tulisanscan.png"))); // NOI18N
        getContentPane().add(tempelkanjari);
        tempelkanjari.setBounds(170, 30, 730, 110);

        nama.setEditable(false);
        nama.setFont(new java.awt.Font("Robaga Rounded Black", 1, 18)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(500, 270, 330, 40);

        utama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hadir utama.png"))); // NOI18N
        utama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                utamaMouseClicked(evt);
            }
        });
        getContentPane().add(utama);
        utama.setBounds(810, 520, 200, 70);

        jam.setEditable(false);
        jam.setFont(new java.awt.Font("Robaga Rounded Black", 1, 18)); // NOI18N
        jam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jamActionPerformed(evt);
            }
        });
        getContentPane().add(jam);
        jam.setBounds(500, 370, 330, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/guru br.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-150, 0, 1170, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ScanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanMouseClicked

        Kehadiran();
    }//GEN-LAST:event_ScanMouseClicked

    private void ScanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanMousePressed
        // TODO add your handling code here:

        //        tempelkanjari.setVisible(true);
    }//GEN-LAST:event_ScanMousePressed

    private void ScanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanMouseReleased

    }//GEN-LAST:event_ScanMouseReleased

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void utamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_utamaMouseClicked
        // TODO add your handling code here:
        Main r = new Main(db);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_utamaMouseClicked

    private void jamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static byte[] getTemplate(JSGFPLib sgfplib, SGDeviceInfoParam deviceInfo) {
        int[] quality = new int[1];
        byte[] regMin = new byte[400];
        byte[] imageBuffer = new byte[deviceInfo.imageHeight * deviceInfo.imageWidth];
        long err;
        SGFingerInfo fingerInfo = new SGFingerInfo();
        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
        fingerInfo.ViewNumber = 1;
        if (sgfplib.GetImageEx(imageBuffer, 5000, 0, 80) == SGFDxErrorCode.SGFDX_ERROR_NONE) {
            err = sgfplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer, quality);
            err = sgfplib.CreateTemplate(fingerInfo, imageBuffer, regMin);
            System.out.println("eror template : " + err);
        }

        return regMin;
    }

    public void Kehadiran() {

        Scanning scan = new Scanning();
        tmp1 = getTemplate(scan.sgfplib, scan.deviceInfo);
        System.out.println("Ukuran : " + bioGuru.size());
        for (Biometric bio : bioGuru) {

            System.out.println();
            System.out.println();
            tmp2 = bio.getTmp();
            long err = scan.sgfplib.MatchTemplate(tmp2, tmp1, SGFDxSecurityLevel.SL_NORMAL, matched);
            if (matched[0]) {
                System.out.println("ketemu");
                for (Guru g : guru) {
                    if (g.getIdf() == bio.getIdf()) {
                        try {
//                            Uid.setText(Integer.toString(s.getIds()));
                            nama.setText(g.getNama());
//                           SET TIME AND DATE
                            if (!db.ceksudahMasukGuru(g.idg)) {
                                JOptionPane.showMessageDialog(null,g.getNama()+" telah melakukan absen pagi", "Message" , JOptionPane.OK_OPTION);
                                return;

                            }
                            Date date = new Date();
                            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            Time t = Time.valueOf(timeFormat.format(date));
                            Time t2 = new Time(t.getTime());
                            System.out.println("sql time : " + String.valueOf(t2).substring(0, 5));
                            System.out.println("sql date : " + sqlDate);

//                            INSERT JAM
                            db.insertJamGuru(con, g.getIdg(), bio.getIdf(), t2, sqlDate);
                            jam.setText(String.valueOf(t2).substring(0, 5));
                            return;
                        } catch (ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage(), "Communication Error", JOptionPane.OK_OPTION);
                        }
                    }
                }
                break;
            }
//            tidakketemu1.setVisible(true);

        }

        JOptionPane.showMessageDialog(null, "Maaf sidikjari tidak ditemukan", "Informasi", JOptionPane.OK_OPTION);

//        Uid.setText("");
        nama.setText("");
        jam.setText("");
        System.out.println("Matching : " + matched[0]);
//        for (byte n : tmp1) {
//            System.out.print(n);
//        }
//        System.out.println();
//        for (byte n : tmp2) {
//            System.out.print(n);
//
//        }
//        System.out.println();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HadirGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HadirGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HadirGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HadirGuru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HadirGuru().setVisible(true);
            }
        });
    }

//    public void Kehadiran() {
//        
//        Scanning scan = new Scanning();
//
//        tmp1 = getTemplate(scan.sgfplib, scan.deviceInfo);
//        System.out.println("Ukuran : " + bioSiswa.size());
//        for (Biometric bio : bioSiswa) {
//
//            System.out.println();
//            System.out.println();
//            tmp2 = bio.getTmp();
//            long err = scan.sgfplib.MatchTemplate(tmp2, tmp1, SGFDxSecurityLevel.SL_NORMAL, matched);
//            if (matched[0]) {
//                System.out.println("ketemu");
//                for (Siswa s : siswa) {
//                    if (s.getIdf() == bio.getIdf()) {
//                        try {
////                            Uid.setText(Integer.toString(s.getIds()));
//                            nama.setText(s.getNama());
////                           SET TIME AND DATE
//                            if (!db.ceksudahMasuk(s.getIds())) {
//                                return;
//
//                            }
//                            Date date = new Date();
//                            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//                            Time t = Time.valueOf(timeFormat.format(date));
//                            Time t2 = new Time(t.getTime());
//                            System.out.println("sql time : " + t2);
//                            System.out.println("sql date : " + sqlDate);
////                            INSERT JAM
//                            db.insertJam(con, s.getIds(), bio.getIdf(), t2, sqlDate, 0);
//                            System.out.println(s.nama);
//                            return;
//                        } catch (ClassNotFoundException ex) {
//                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
//                        }
//                    }
//                }
//                break;
//            }
////            tidakketemu1.setVisible(true);
//
//        }
//        
//        
//        tempelkanjari.setVisible(false);
//        System.out.println("asuk");
//        JOptionPane.showMessageDialog(null, "Maaf sidikjari tidak ditemukan", "Communication Error", JOptionPane.OK_OPTION);
//
////        Uid.setText("");
//        nama.setText("");
//        System.out.println("Matching : " + matched[0]);
//        for (byte n : tmp1) {
//            System.out.print(n);
//        }
//        System.out.println();
//        for (byte n : tmp2) {
//            System.out.print(n);
//
//        }
//        System.out.println();
//    }
//    
//    public static byte[] getTemplate(JSGFPLib sgfplib, SGDeviceInfoParam deviceInfo) {
//        int[] quality = new int[1];
//        byte[] regMin = new byte[400];
//        byte[] imageBuffer = new byte[deviceInfo.imageHeight * deviceInfo.imageWidth];
//        long err;
//        SGFingerInfo fingerInfo = new SGFingerInfo();
//        fingerInfo.FingerNumber = SGFingerPosition.SG_FINGPOS_LI;
//        fingerInfo.ImpressionType = SGImpressionType.SG_IMPTYPE_LP;
//        fingerInfo.ViewNumber = 1;
//        if (sgfplib.GetImageEx(imageBuffer, 5000, 0, 80) == SGFDxErrorCode.SGFDX_ERROR_NONE) {
//            err = sgfplib.GetImageQuality(deviceInfo.imageWidth, deviceInfo.imageHeight, imageBuffer, quality);
//            err = sgfplib.CreateTemplate(fingerInfo, imageBuffer, regMin);
//            System.out.println("eror template : " + err);
//        }
//
//        return regMin;
//    }
    ArrayList<Guru> guru = new ArrayList<>();
    ArrayList<Admin> admin = new ArrayList<>();
    ArrayList<Biometric> biometric = new ArrayList<>();
    ArrayList<Biometric> bioGuru = new ArrayList<>();
    db db;
    java.sql.Connection con = db.getkoneksi();
    byte[] tmp1 = new byte[400];
    byte[] tmp2 = new byte[400];
    boolean[] matched = new boolean[1];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Scan;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jam;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel tempelkanjari;
    private javax.swing.JLabel utama;
    // End of variables declaration//GEN-END:variables
}