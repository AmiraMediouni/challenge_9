package com.example.challenge_9;

import com.example.challenge_9.entities.User;
import com.example.challenge_9.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication

public class Challenge9Application   {
    public static void main(String[] args) {
        SpringApplication.run(Challenge9Application.class, args);
    }

  /*  @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(Challenge9Application.class, args);
    }

    // this bean used to crypt the password
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoderBean = applicationContext.getBean(BCryptPasswordEncoder.class);
        return passwordEncoderBean;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Clean up database tables
//		this.roleRepository.deleteAllInBatch();
//		this.userRepository.deleteAllInBatch();
//		this.userDetailsRepository.deleteAllInBatch();
//		this.postRepository.deleteAllInBatch();
//		this.tagRepository.deleteAllInBatch();
//		this.commentRepository.deleteAllInBatch();


        // Save users
       User user1 = new User(1,"hatem", "dagbouj",
                "hatem.dagbouj@fivepoints.fr",
                this.passwordEncoder().encode("123456789"));


        this.userRepository.save(user1);


    }*/
}