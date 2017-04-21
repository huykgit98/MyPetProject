package maks.core;

import maks.core.repo.ClothesRepo;
import maks.core.repo.GroupInvitationRepo;
import maks.core.repo.UserGroupRepo;
import maks.core.repo.UserRepo;
import maks.core.service.UserService;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepo userRepo, ClothesRepo clothesRepo, GroupInvitationRepo repo, UserGroupRepo userGroupRepo, UserService userService) {
        return (args) -> {
            User gosha = new User("gosha", "mail@amil.com");
            User golchaMan = new User("GolchaMan", "GlchaMan@amil.com");
            Clothes boots = new Clothes("adidas");
            Clothes shorts = new Clothes("puma");
            Clothes cap = new Clothes("puma cap");
            UserGroup userGroup = new UserGroup("Soccer payers");

            gosha = userRepo.save(gosha);
            golchaMan = userRepo.save(golchaMan);
            userRepo.findAll().forEach(System.out::println);
            boots = clothesRepo.save(boots);
            shorts = clothesRepo.save(shorts);
            cap = clothesRepo.save(cap);
            golchaMan.addClothes(boots);
            golchaMan.addClothes(shorts);
            gosha.addClothes(cap);
            userRepo.save(golchaMan);
            userRepo.save(gosha);
            Set<User> users = userRepo.findAll();
            for (User user : users) {
//                Hibernate.initialize(user.getClothesSet());
                Set<Clothes> clothes = userService.getClothes(user);
                for (Clothes clothe : clothes) {
                    System.out.println(clothe);
                }
            }

        };
    }
}
