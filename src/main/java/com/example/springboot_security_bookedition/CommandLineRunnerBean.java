package com.example.springboot_security_bookedition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    CarRepo carRepo;

    public void run(String...args){
        User user = new User("bart", "bart@domain.com", "bart", "Bart","Simpson", true);
        Role userRole = new Role("bart", "ROLE_USER");
        userRepo.save(user);
        roleRepo.save(userRole);

        User admin = new User("super", "super@domain.com", "super", "Super", "Hero", true);
        Role adminRole1 = new Role("super", "ROLE_ADMIN");
        Role adminRole2 = new Role("super", "ROLE_USER");

        userRepo.save(admin);
        roleRepo.save(adminRole1);
        roleRepo.save(adminRole2);

        Car car = new Car("DBS Superleggaera", "Red", "Aston Martin", "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2019-aston-martin-dbs-superleggera-mmp-1545071883.jpg?crop=0.723xw:0.724xh;0.277xw,0.153xh&resize=980:*");
        carRepo.save(car);
    }

}
