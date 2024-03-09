package ma.enset.jpaap;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null, "Hassan", new Date(), false, 4));
        patientRepository.save(new Patient(null, "Khalid", new Date(), false, 5));
        patientRepository.save(new Patient(null, "Omar", new Date(), true, 6));
        patientRepository.save(new Patient(null, "Salma", new Date(), false, 7));
        patientRepository.save(new Patient(null, "Hanae", new Date(), true, 8));

        /*System.out.println("***********************************");
        System.out.println("Liste des patients");
        patientRepository.findAll().forEach(p -> {
            System.out.println("_________________________");
            System.out.println(p.getName());
            System.out.println(p.getDateOfBirth());
            System.out.println(p.isMalade());
        });

        System.out.println("***********************************");
        Patient patient = patientRepository.findById(3L).orElse(null);
        if (patient != null) {
            System.out.println("Nom du patient : " + patient.getName());
            System.out.println("Date de naissance : " + patient.getDateOfBirth());
            System.out.println("Malade : " + patient.isMalade());
        }
        System.out.println("***********************************");
        patient.setScore(38);*/
        /*
        * La méthode save permet de faire un insert ou un update
        * si l'objet patient a un id alors c'est un update sinon c'est un insert
         */
        //patientRepository.save(patient);

        System.out.println("***********************************");
        System.out.println("Pagination des patients");
        for (int i = 0; i <100 ; i++) {
            patientRepository.save(new Patient(null, "Nom"+i, new Date(), (Math.random()) > 0.5, (int)(Math.random()*100)));
        }

        /*
        Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(3, 5));
        System.out.println("Nombre de pages : " + pagePatients.getTotalPages());
        System.out.println("Nombre de patients : " + pagePatients.getTotalElements());
        System.out.println("Taille de la page : " + pagePatients.getSize());
        System.out.println("Numéro de la page : " + pagePatients.getNumber());
           */
        //pagePatients.getContent().forEach(System.out::println);
        //pagePatients.forEach(System.out::println);
        /*
        *pagePatients.getContent().forEach(System.out::println);
        * est équivalent à
        * pagePatients.forEach(p -> {
        *  System.out.println(p);
        * });
         */

        System.out.println("***********************************");
        System.out.println("Recherche des patients malades");
        //patientRepository.findByMalade(true).forEach(System.out::println);
        Page<Patient> pagePatients = patientRepository.findByMalade(true, PageRequest.of(0, 10));
        pagePatients.getContent().forEach(System.out::println);



    }
}
