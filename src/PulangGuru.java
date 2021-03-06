
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
import java.util.Date;
import javax.swing.ImageIcon;
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
public class PulangGuru extends javax.swing.JFrame {

    /**
     * Creates new form Pulang
     */
    public PulangGuru() {
        setUndecorated(true);
        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
//        myinitComponents();
    }

    public PulangGuru(db db) {
        setUndecorated(true);
        setResizable(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
        myinitComponents(db);
    }

    private void myinitComponents(db db1) {

//        tempelkanjari.setVisible(false);
        db = db1;
        guru = db.getGuru();
        if (!guru.isEmpty()) {
            bioGuru = db.getBioguru();
        }
        for (Guru s : guru) {
            System.out.println(s.nama + "||");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        tempelkanjari = new javax.swing.JLabel();
        refresh = new javax.swing.JLabel();
        jam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(447, 74, 0, 0);

        scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hadir scan.png"))); // NOI18N
        scan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scanMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                scanMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                scanMouseReleased(evt);
            }
        });
        getContentPane().add(scan);
        scan.setBounds(100, 160, 280, 330);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(880, 510, 0, 0);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/hadir utama.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(800, 520, 200, 70);

        nama.setEditable(false);
        nama.setFont(new java.awt.Font("Robaga Rounded Black", 1, 18)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        getContentPane().add(nama);
        nama.setBounds(500, 270, 320, 40);

        tempelkanjari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tulisanscan.png"))); // NOI18N
        getContentPane().add(tempelkanjari);
        tempelkanjari.setBounds(170, 30, 680, 110);

        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh4.png"))); // NOI18N
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(30, 520, 70, 60);

        jam.setEditable(false);
        jam.setFont(new java.awt.Font("Robaga Rounded Black", 1, 18)); // NOI18N
        getContentPane().add(jam);
        jam.setBounds(500, 370, 320, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gurupulang br.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-100, 0, 1130, 810);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        Main r = new Main(db);
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void scanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanMouseClicked

        Pulang();
    }//GEN-LAST:event_scanMouseClicked

    private void scanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanMousePressed

    }//GEN-LAST:event_scanMousePressed

    private void scanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scanMouseReleased

    }//GEN-LAST:event_scanMouseReleased

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
// TODO add your handling code here:

        db = new db();
        guru = db.getGuru();
        if (!guru.isEmpty()) {
            bioGuru = db.getBioguru();
        }
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/refresh4.png"));
        JOptionPane.showMessageDialog(null, "Data telah di Refresh",
                "Informasi", JOptionPane.INFORMATION_MESSAGE, icon);
    }//GEN-LAST:event_refreshMouseClicked

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

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
            java.util.logging.Logger.getLogger(Pulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pulang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pulang().setVisible(true);
            }
        });
    }

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
//            System.out.println("eror template : " + err);
        }

        return regMin;
    }

    public void Pulang() {
        Scanning scan = new Scanning();

        tmp1 = getTemplate(scan.sgfplib, scan.deviceInfo);
        for (Biometric bio : bioGuru) {
            tmp2 = bio.getTmp();
            long err = scan.sgfplib.MatchTemplate(tmp1, tmp2, SGFDxSecurityLevel.SL_NORMAL, matched);
            if (matched[0]) {
                System.out.println("ketemu");
                for (Guru g : guru) {
                    if (g.getIdf() == bio.getIdf()) {
                        try {
//                            Uid.setText(Integer.toString(p.getIds()));
                            nama.setText(g.getNama());
                            int counter = 0;

                            counter = db.ceksudahPulangGuru(g.idg);
                            System.out.println("counter : " + counter);
                            String pesan = "";
                            if (counter == 0) {
                                pesan = g.getNama() + " Belum Melakukan Absen Pagi";
                                nama.setText("");
                                jam.setText("");
                                JOptionPane.showMessageDialog(null, pesan, "Message", JOptionPane.OK_OPTION);
                                return;
                            } else if (counter == -1) {

                            } else {
                                pesan = g.getNama() + " Telah melakukan absen siang";
                                nama.setText("");
                                jam.setText("");
                                JOptionPane.showMessageDialog(null, pesan, "Message", JOptionPane.OK_OPTION);
                                return;
                            }

                            Date date = new Date();
                            DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                            Time t = Time.valueOf(timeFormat.format(date));
                            Time t2 = new Time(t.getTime());
                            System.out.println("sql time : " + t2);
                            System.out.println("sql date : " + sqlDate);
                            //                            INSERT JAM
                            db.insertJamkeluarGuru(con, g.getIdg(), bio.getIdf(), t2, sqlDate);
                            System.out.println(g.nama);
                            jam.setText(String.valueOf(t2).substring(0, 5));
                            return;
                        } catch (ClassNotFoundException ex) {
                            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Maaf, sidikjari tidak terdaftar", "Message", JOptionPane.OK_OPTION);
//        tidakketemu1.setVisible(true);
//        Uid.setText("");
        nama.setText("");
        jam.setText("");
        System.out.println();
    }

    ArrayList<Guru> guru = new ArrayList<>();
    ArrayList<Biometric> bioGuru = new ArrayList<>();

    db db;
    java.sql.Connection con = db.getkoneksi();
    byte[] tmp1 = new byte[400];
    byte[] tmp2 = new byte[400];
    boolean[] matched = new boolean[1];
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jam;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel refresh;
    private javax.swing.JLabel scan;
    private javax.swing.JLabel tempelkanjari;
    // End of variables declaration//GEN-END:variables
}
