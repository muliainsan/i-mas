
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author insan
 */
public class Jam {
    int idf;
    Date waktu;
    Date tgl;
    String status;

    public Jam(int idf, Date waktu, Date tgl, String status) {
        this.idf = idf;
        this.waktu = waktu;
        this.tgl = tgl;
        this.status = status;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
//    public boolean insertJam(Connection con, int idf,Date waktu,Date tgl) throws ClassNotFoundException {
//
//        try {
//            
//            Class.forName("com.mysql.jdbc.Driver");
//            String query = "INSERT INTO `datajam` (`idj`, `idf`, `waktu`, `tanggal`, `status`) VALUES (NULL, ?, ?, ?, ?)";
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setInt(1, idf);
//            preparedStmt.setDate(2, tgl);
//            
//            preparedStmt.execute();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
//        }
//        return true;
//    }
    
    
}
