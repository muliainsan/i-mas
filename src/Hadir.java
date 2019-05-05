
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author insan
 */
public class Hadir extends javax.swing.JFrame {

    /**
     * Creates new form
     */
    public Hadir() {

        setUndecorated(true);
        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    public Hadir(db db) {

        setUndecorated(true);
        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
        myinitComponents(db);
    }

    private void myinitComponents(db db1) {
//        tidakketemu1.setVisible(false);
//        tempelkanjari.setVisible(false);
        smile.setVisible(false);
        db = db1;
        siswa = db.getSiswa();
        System.out.println(siswa.size());
        if (!siswa.isEmpty()) {
            biometric = db.getBiometric();
            admin = db.getAdmin();
            bioSiswa = db.getBiosiswa();
            bioPenjemput = db.getBiopenjemput();
        }

        System.out.println(penjemput);
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

        hentikan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        smile = new javax.swing.JLabel();
        Scan = new javax.swing.JLabel();
        utama = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        tempelkanjari = new javax.swing.JLabel();
        refresh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        hentikan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hentikan.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hentikan.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(444, 167, 0, 0);

        smile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/spongebob.png"))); // NOI18N
        smile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smileMouseClicked(evt);
            }
        });
        getContentPane().add(smile);
        smile.setBounds(20, 170, 480, 370);

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

        utama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hadir utama.png"))); // NOI18N
        utama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                utamaMouseClicked(evt);
            }
        });
        getContentPane().add(utama);
        utama.setBounds(790, 500, 200, 70);

        nama.setEditable(false);
        nama.setFont(new java.awt.Font("Robaga Rounded Black", 1, 18)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(500, 310, 320, 40);

        tempelkanjari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tulisanscan.png"))); // NOI18N
        getContentPane().add(tempelkanjari);
        tempelkanjari.setBounds(170, 30, 730, 110);

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh4.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(30, 520, 70, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hadir br.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1020, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void utamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_utamaMouseClicked
        // TODO add your handling code here:
        Main r = new Main(db);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_utamaMouseClicked

    private void ScanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanMousePressed
        // TODO add your handling code here:

//        tempelkanjari.setVisible(true);

    }//GEN-LAST:event_ScanMousePressed

    private void ScanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanMouseReleased


    }//GEN-LAST:event_ScanMouseReleased

    private void ScanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScanMouseClicked
//        tempelkanjari.setVisible(true);
//        hentikan1.setVisible(true);
//        ImageIcon icon = new ImageIcon(getClass().getResource("/image/menu2kecil.png"));
//        JOptionPane.showMessageDialog(null, "Siapkan jari kamu!",
//                "Informasi", JOptionPane.INFORMATION_MESSAGE, icon);
        Kehadiran();
//        tempelkanjari.setVisible(false);
//        hentikan1.setVisible(false);

    }//GEN-LAST:event_ScanMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:

        db = new db();
        siswa = db.getSiswa();
        if (!siswa.isEmpty()) {
            penjemput = db.getPenjemput();
            biometric = db.getBiometric();
            admin = db.getAdmin();
            bioSiswa = db.getBiosiswa();
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/refresh4.png"));
        JOptionPane.showMessageDialog(null, "Data telah di Refresh","Informasi", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_refreshMouseClicked

    private void smileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smileMouseClicked
        // TODO add your handling code here:
        smile.setVisible(false);
    }//GEN-LAST:event_smileMouseClicked

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
        System.out.println("Ukuran : " + bioSiswa.size());
        for (Biometric bio : bioSiswa) {

            System.out.println();
            System.out.println();
            tmp2 = bio.getTmp();
            long err = scan.sgfplib.MatchTemplate(tmp2, tmp1, SGFDxSecurityLevel.SL_NORMAL, matched);
            if (matched[0]) {
                System.out.println("ketemu");
                for (Siswa s : siswa) {
                    if (s.getIdf() == bio.getIdf()) {
                        try {
//                            Uid.setText(Integer.toString(s.getIds()));
                            nama.setText(s.getNama());
//                           SET TIME AND DATE
                            if (!db.ceksudahMasuk(s.getIds())) {
                                return;

                            }
                            Date date = new Date();
                            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            Time t = Time.valueOf(timeFormat.format(date));
                            Time t2 = new Time(t.getTime());
                            Time t3 = new Time(t.getTime());
                            System.out.println("sql time : " + t2);
                            System.out.println("sql date : " + sqlDate);
//                            INSERT JAM
                            db.insertJam(db.con, s.getIds(), bio.getIdf(), t2, sqlDate, 0);
                            System.out.println(s.nama);

                            Date yourDate = new Date();
                            Calendar now = Calendar.getInstance();
                            now.set(Calendar.HOUR_OF_DAY, 12);
                            now.set(Calendar.MINUTE, 00);
                            Calendar givenDate = Calendar.getInstance();
                            givenDate.setTime(yourDate);
                            boolean bol = false;
                            bol = now.after(givenDate);
//                            smile.setVisible(bol);

                            return;
                        } catch (ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);

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
        System.out.println("Matching : " + matched[0]);
        for (byte n : tmp1) {
            System.out.print(n);
        }
        System.out.println();
        for (byte n : tmp2) {
            System.out.print(n);

        }
        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Hadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hadir().setVisible(true);
            }
        });
    }

    HadirGuru rr;
    ArrayList<Siswa> siswa = new ArrayList<>();
    ArrayList<Admin> admin = new ArrayList<>();
    ArrayList<Penjemput> penjemput = new ArrayList<>();
    ArrayList<Biometric> biometric = new ArrayList<>();
    ArrayList<Biometric> bioSiswa = new ArrayList<>();
    ArrayList<Biometric> bioPenjemput = new ArrayList<>();
    db db;
//    java.sql.Connection con = db.getkoneksi();
    byte[] tmp1 = new byte[400];
    byte[] tmp2 = new byte[400];
    boolean[] matched = new boolean[1];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Scan;
    private javax.swing.JLabel hentikan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel refresh;
    private javax.swing.JLabel smile;
    private javax.swing.JLabel tempelkanjari;
    private javax.swing.JLabel utama;
    // End of variables declaration//GEN-END:variables

}