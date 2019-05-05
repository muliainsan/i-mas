
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author isa
 */
public class db {

    private String url = "jdbc:mysql://149.56.36.129/sekolah";
    private String dbuser = "aditya";
    private String dbpasswd = "aditya";
    private Statement stmt = null;
    Connection con = null;
    private ResultSet rs = null;
    private static Connection koneksi;

    public db() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "JDBC DRIVER ERROR", JOptionPane.WARNING_MESSAGE);
        }
        try {
            con = DriverManager.getConnection(url, dbuser, dbpasswd);
            stmt = con.createStatement();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Connection Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static Connection getkoneksi() {
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://149.56.36.129/sekolah";
                String user = "aditya";
                String password = "aditya";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
        return koneksi;
    }

    public ResultSet getData(String SQLString) {
        try {
            rs = stmt.executeQuery(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }

    public void query(String SQLString) {
        try {
            stmt.executeUpdate(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public ArrayList<Siswa> getSiswa() {
        ArrayList<Siswa> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM `siswa`");
            while (rs.next()) {
                Siswa siswa = new Siswa(rs.getInt("ids"), rs.getInt("idf"), rs.getString("nama"));
                s.add(siswa);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }
    
    public ArrayList<Guru> getGuru() {
        ArrayList<Guru> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM `guru`");
            while (rs.next()) {
                Guru guru = new Guru(rs.getInt("idg"), rs.getInt("idf"),rs.getString("nip"), rs.getString("nama"));
                s.add(guru);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }

    public ArrayList<Penjemput> getPenjemput() {
        ArrayList<Penjemput> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM `penjemput`");
            while (rs.next()) {
                Penjemput penjemput = new Penjemput(rs.getInt("idp"), rs.getInt("ids"), rs.getInt("idf"), rs.getString("nama"));
                s.add(penjemput);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }

    public ArrayList<Admin> getAdmin() {
        ArrayList<Admin> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM `admin`");
            while (rs.next()) {
                Admin admin = new Admin(rs.getInt("ida"), rs.getInt("idf"), rs.getString("nama"));
                s.add(admin);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }

    public ArrayList<Biometric> getBiometric() {
        ArrayList<Biometric> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT * FROM `biometric`");
            while (rs.next()) {
                Biometric biometric = new Biometric(rs.getInt("idf"), rs.getBytes("template"));
                s.add(biometric);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }

    public ArrayList<Biometric> getBiosiswa() {
        ArrayList<Biometric> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT biometric.idf,biometric.template FROM biometric INNER JOIN siswa ON biometric.idf = siswa.idf");
            while (rs.next()) {
                Biometric biometric = new Biometric(rs.getInt("idf"), rs.getBytes("template"));
                s.add(biometric);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }
    
    public ArrayList<Biometric> getBioguru() {
        ArrayList<Biometric> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT biometric.idf,biometric.template FROM biometric INNER JOIN guru ON biometric.idf = guru.idf");
            while (rs.next()) {
                Biometric biometric = new Biometric(rs.getInt("idf"), rs.getBytes("template"));
                s.add(biometric);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return s;
    }

    public ArrayList<Biometric> getBiopenjemput() {
        ArrayList<Biometric> s = new ArrayList<>();
        try {
            rs = stmt.executeQuery("SELECT biometric.idf,biometric.template FROM biometric INNER JOIN penjemput ON biometric.idf = penjemput.idf");
            while (rs.next()) {
                Biometric biometric = new Biometric(rs.getInt("idf"), rs.getBytes("template"));
                s.add(biometric);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return s;
    }

    public boolean insertTemplate(Connection con, byte[] tmp) throws ClassNotFoundException {

        try {
            System.out.println(tmp.length);
            Class.forName("com.mysql.jdbc.Driver");
            String query = "INSERT INTO `biometric` (`idf`,`template`) VALUES (NULL,?)";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setBinaryStream(1, new ByteArrayInputStream(tmp), tmp.length);
            preparedStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean ceksudahMasuk(int ids) {

        try {
            rs = stmt.executeQuery("SELECT * FROM datajam WHERE datajam.tanggal = CURDATE() and datajam.ids = " + ids);
            while (rs.next()) {
                System.out.println(rs.getString("status"));
                if (rs.getInt("status") == 0) {
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public int ceksudahPulang(int ids, List<Penjemput> penjemput) {
        int counter = 0;
//        String status = "Siswa belum melakukan absen pagi";
        try {
            rs = stmt.executeQuery("SELECT * FROM datajam WHERE datajam.tanggal = CURDATE() and datajam.ids = " + ids);
            while (rs.next()) {
                if (rs.getInt("status") == 0) {
                    counter--;
//                    status = "";
                }

                if (rs.getInt("status") == 1) {
                    counter=rs.getInt("idf");
                    
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
//        if counter0 = siswa tidak masuk, if counter1 = bisa dijemput, if counter2 = sudah dijemput
        return counter;
    }
    
    public boolean ceksudahMasukGuru(int idg) {

        try {
            rs = stmt.executeQuery("SELECT * FROM datajamguru WHERE datajamguru.tanggal = CURDATE() and datajamguru.idg = " + idg);
            while (rs.next()) {
                System.out.println(rs.getString("status"));
                if (rs.getInt("status") == 0) {
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public int ceksudahPulangGuru(int idg) {
        int counter = 0;
//        String status = "Siswa belum melakukan absen pagi";
        try {
            rs = stmt.executeQuery("SELECT * FROM datajamguru WHERE datajamguru.tanggal = CURDATE() and datajamguru.idg = " + idg);
            while (rs.next()) {
                if (rs.getInt("status") == 0) {
                    counter--;
//                    status = "";
                }

                if (rs.getInt("status") == 1) {
                    counter=rs.getInt("idf");
                    
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
//        if counter0 = siswa tidak masuk, if counter1 = bisa dijemput, if counter2 = sudah dijemput
        return counter;
    }

    public int getlastIdf() throws ClassNotFoundException {
        int result = 0;
        try {
            rs = stmt.executeQuery("select idf from `biometric` ORDER BY idf DESC LIMIT 1");
            while (rs.next()) {
                result = rs.getInt("idf");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }

        return result;
    }

    public boolean updateIdf(Connection con, String table, String a, int idf, int id) throws ClassNotFoundException {

        try {

            String query = "update " + table + " set idf = ? where " + a + " = ?";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, idf);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    public boolean updateTemplate(Connection con, byte[] template, int idf) throws ClassNotFoundException {

        try {

            String query = "update biometric set template = ? where idf = ?";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setBinaryStream(1, new ByteArrayInputStream(template), template.length);
            preparedStmt.setInt(2, idf);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean insertJam(Connection con, int ids, int idf, Time waktu, Date tgl, int status) throws ClassNotFoundException {

        try {
            System.out.println("status : " + status);
            Class.forName("com.mysql.jdbc.Driver");
            String query = "INSERT INTO `datajam` (`idj`, `ids`,`idf`, `waktu`, `tanggal`, `status`) VALUES (NULL, ?, ?, ?, ?, ? )";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, ids);
            preparedStmt.setInt(2, idf);
            preparedStmt.setTime(3, waktu);
            preparedStmt.setDate(4, tgl);
            preparedStmt.setInt(5, status);

            preparedStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    public boolean insertJamkeluar(Connection con, int ids, int idf, Time waktu, Date tgl, int status, int idp) throws ClassNotFoundException {

        try {
            System.out.println("status : " + status);
            Class.forName("com.mysql.jdbc.Driver");
            String query = "INSERT INTO `datajam` (`idj`, `ids`,`idf`, `waktu`, `tanggal`, `status`, `idp`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, ids);
            preparedStmt.setInt(2, idf);
            preparedStmt.setTime(3, waktu);
            preparedStmt.setDate(4, tgl);
            preparedStmt.setInt(5, status);
             preparedStmt.setInt(6, idp);

            preparedStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    
    public boolean insertJamGuru(Connection con, int idg, int idf, Time waktu, Date tgl) throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String query = "INSERT INTO `datajamguru` (`idjg`, `idg`,`idf`, `waktu`, `tanggal`, `status`) VALUES (NULL, ?, ?, ?, ?, ? )";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, idg);
            preparedStmt.setInt(2, idf);
            preparedStmt.setTime(3, waktu);
            preparedStmt.setDate(4, tgl);
            preparedStmt.setInt(5, 0);

            preparedStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    public boolean insertJamkeluarGuru(Connection con, int idg, int idf, Time waktu, Date tgl) throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String query = "INSERT INTO `datajamguru` (`idjg`, `idg`,`idf`, `waktu`, `tanggal`, `status`) VALUES (NULL, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, idg);
            preparedStmt.setInt(2, idf);
            preparedStmt.setTime(3, waktu);
            preparedStmt.setDate(4, tgl);
            preparedStmt.setInt(5, 1);
             

            preparedStmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
//    INSERT INTO `datajam` (`idj`, `idf`, `waktu`, `tanggal`, `status`) VALUES (NULL, NULL, '', '', '')

    public boolean deleteIdf(Connection con, String table, String a, int id) throws ClassNotFoundException {
//        UPDATE `siswa` SET `idf` = NULL WHERE `siswa`.`ids` = 6
        try {

            String query = "update " + table + " set idf = NULL where " + a + " = ?";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean deleteBio(Connection con, int idf) throws ClassNotFoundException {
//      DELETE FROM `siswa` WHERE `siswa`.`ids` = 8
        try {

            String query = "DELETE FROM `biometric` WHERE `idf` =?";
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, idf);
            preparedStmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

}
