package com.example.DTO.bootstrap;

import com.example.DTO.domain.Citizen;
import com.example.DTO.domain.Doctor;
import com.example.DTO.domain.Speciality;
import com.example.DTO.domain.User;
import com.example.DTO.repository.CitizenRepository;
import com.example.DTO.repository.DoctorRepository;
import com.example.DTO.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final CitizenRepository citizenRepository;
    private final DoctorRepository doctorRepository;

    public Bootstrap(UserRepository userRepository, CitizenRepository citizenRepository, DoctorRepository doctorRepository) {
        this.userRepository = userRepository;
        this.citizenRepository = citizenRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setId(1L);
        user.setUsername("AnasMarg");
        user.setPassword("12345");


        userRepository.save(user);

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("AntMol");
        user2.setPassword("AgiaAikaterini");

        userRepository.save(user2);

        User user3 = new User();
        user3.setId(3L);
        user3.setUsername("GeorKost");
        user3.setPassword("psixologika");

        userRepository.save(user3);


        Citizen citizen = new Citizen();
        citizen.setId(1L);
        citizen.setFirstName("Anastasios");
        citizen.setLastName("Margaritis");
        citizen.setAddress("Taxiarhon 24");
        citizen.setEmail("anastasismargaritis@gmail.com");
        citizen.setTelephone("6982131395");

        Citizen citizen1 = new Citizen();
        citizen1.setId(2L);
        citizen1.setFirstName("Anthi");
        citizen1.setLastName("Molozi");
        citizen1.setAddress("Taxiarhon 24");
        citizen1.setEmail("anthi.molozi@gmail.com");
        citizen1.setTelephone("6984999092");

        citizen.setUser(user);
        citizen1.setUser(user2);

        citizenRepository.save(citizen);
        citizenRepository.save(citizen1);

        Doctor doctor = new Doctor();
        doctor.setId(1L);
        doctor.setFirstName("George");
        doctor.setLastName("Kostopoulos");
        doctor.setEmail("georgekost@outlook.com");
        doctor.setTelephone("6978965322");
        doctor.setSpeciality(Speciality.PSYCHO);

        doctor.setUser(user3);

        doctorRepository.save(doctor);


    }
}
