package ma.enset.tpjdbc2025.dao;

import ma.enset.tpjdbc2025.entities.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
    @Override
    public List<Patient> findAll() {
        Connection conn = DbConnexionSingleton.getConnection();
        List<Patient> patients = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from PATIENTS");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient();
                patient.setIdPatient(rs.getLong("ID_PATIENT"));
                patient.setNom(rs.getString("NOM"));
                patient.setPrenom(rs.getString("PRENOM"));
                patient.setTel(rs.getString("TEL"));
                patient.setEmail(rs.getString("EMAIL"));

                patients.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patients;
    }

    @Override
    public Patient findById(int id) {
        Connection conn = DbConnexionSingleton.getConnection();
        Patient patient = new Patient();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * from PATIENTS WHERE ID_PATIENT = ?");
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                patient.setIdPatient(rs.getLong("ID_PATIENT"));
                patient.setNom(rs.getString("NOM"));
                patient.setPrenom(rs.getString("PRENOM"));
                patient.setEmail(rs.getString("EMAIL"));
                patient.setTel(rs.getString("TEL"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return patient;
    }

    @Override
    public void create(Patient patient) {
    Connection conn = DbConnexionSingleton.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PATIENTS (NOM,PRENOM,TEL,EMAIL) VALUES (?,?,?,?)");
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getPrenom());
            pstmt.setString(3, patient.getTel());
            pstmt.setString(4, patient.getEmail());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        Connection conn = DbConnexionSingleton.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM PATIENTS WHERE ID_PATIENT = ?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    @Override
    public void update(Patient patient) {
        Connection conn = DbConnexionSingleton.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE PATIENTS  SET NOM=?,PRENOM=?,EMAIL=?,TEL=? WHERE ID_PATIENT = ?");
            pstmt.setString(1, patient.getNom());
            pstmt.setString(2, patient.getPrenom());
            pstmt.setString(3, patient.getTel());
            pstmt.setString(4, patient.getEmail());
            pstmt.setLong(5, patient.getIdPatient());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
