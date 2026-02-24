package org.example;

import org.example.entity.*;
import org.example.service.*;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        DepartmentService departmentService = new DepartmentService();
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();


        Department department = new Department();
        department.setName("Cardiology");
        department.setLocation("Block A");
        department.setHeadDoctorName("Dev");
        departmentService.save(department);


        Doctor d1 = new Doctor();
        d1.setName("Dev");
        d1.setSpecialization("Cardiologist");
        d1.setLicenseNo("LIC001");
        d1.setDepartment(department);
        doctorService.save(d1);

        Doctor d2 = new Doctor();
        d2.setName("Abhi");
        d2.setSpecialization("General Physician");
        d2.setLicenseNo("LIC002");
        d2.setDepartment(department);
        doctorService.save(d2);

        Doctor d3 = new Doctor();
        d3.setName("Surbhi");
        d3.setSpecialization("Neurologist");
        d3.setLicenseNo("LIC003");
        d3.setDepartment(department);
        doctorService.save(d3);

        Doctor d4 = new Doctor();
        d4.setName("Kriti");
        d4.setSpecialization("Dentist");
        d4.setLicenseNo("LIC004");
        d4.setDepartment(department);
        doctorService.save(d4);


        Patient p1 = new Patient();
        p1.setName("Ramesh");
        p1.setDob(LocalDate.of(1990, 1, 10));
        p1.setBloodGroup("A+");
        p1.setPhone("9000000001");
        patientService.save(p1);

        Patient p2 = new Patient();
        p2.setName("Suresh");
        p2.setDob(LocalDate.of(1992, 2, 15));
        p2.setBloodGroup("B+");
        p2.setPhone("9000000002");
        patientService.save(p2);

        Patient p3 = new Patient();
        p3.setName("Ravi");
        p3.setDob(LocalDate.of(1995, 3, 20));
        p3.setBloodGroup("O+");
        p3.setPhone("9000000003");
        patientService.save(p3);

        Patient p4 = new Patient();
        p4.setName("Dikha");
        p4.setDob(LocalDate.of(1998, 4, 5));
        p4.setBloodGroup("AB+");
        p4.setPhone("9000000004");
        patientService.save(p4);

        Patient p5 = new Patient();
        p5.setName("Samikha");
        p5.setDob(LocalDate.of(2000, 6, 18));
        p5.setBloodGroup("A-");
        p5.setPhone("9000000005");
        patientService.save(p5);

        Patient p6 = new Patient();
        p6.setName("Preeti");
        p6.setDob(LocalDate.of(1993, 7, 25));
        p6.setBloodGroup("B-");
        p6.setPhone("9000000006");
        patientService.save(p6);

        Patient p7 = new Patient();
        p7.setName("Kabir");
        p7.setDob(LocalDate.of(1997, 8, 30));
        p7.setBloodGroup("O-");
        p7.setPhone("9000000007");
        patientService.save(p7);


        doctorService.assignPatient(d1.getId(), p1.getId());
        doctorService.assignPatient(d1.getId(), p2.getId());

        doctorService.assignPatient(d2.getId(), p3.getId());
        doctorService.assignPatient(d2.getId(), p4.getId());

        doctorService.assignPatient(d3.getId(), p5.getId());

        doctorService.assignPatient(d4.getId(), p6.getId());
        doctorService.assignPatient(d4.getId(), p7.getId());

        System.out.println("All data inserted successfully!");
    }
}