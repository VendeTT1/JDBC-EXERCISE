package ma.enset.tpjdbc2025.dao;


import ma.enset.tpjdbc2025.entities.Patient;

import java.util.List;

public class DaoTest {
    public static void main(String[] args) {
        PatientDao patientDao = new PatientDaoImpl();
//        Insert new patient into the database
//        Patient patient = new Patient("saidi","salah","44444444","s@email.ma");
//        Patient patient1 = new Patient("nekkach","brahim","666666666","n@email.ma");
//        Patient patient2 = new Patient("fetah","said","10010101","sf@email.ma");
//
//        patientDao.create(patient);
//        patientDao.create(patient1);
//        patientDao.create(patient2);

//        Get list of patient in database
//        List<Patient> patientList = patientDao.findAll();
//        for (Patient patient : patientList) {
//            System.out.println(patient);
//        }

//        find patient by id and updated
//        Patient patient = patientDao.findById(2);
//        System.out.println(patient);
//
//        patient.setNom("rabeh");
//        patientDao.update(patient);
//        System.out.println(patient);

//        delete patient by its id and list the patients in the database
        patientDao.delete(2l);
        List<Patient> patientList = patientDao.findAll();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }

    }
}
