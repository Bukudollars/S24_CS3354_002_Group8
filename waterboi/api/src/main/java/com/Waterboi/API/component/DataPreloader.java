package com.Waterboi.API.component;

import com.Waterboi.API.entity.Appuser;
import com.Waterboi.API.entity.UnitOfMeasure;
import com.Waterboi.API.entity.WaterPost;
import com.Waterboi.API.repository.AppuserRepository;
import com.Waterboi.API.repository.UnitOfMeasureRepository;
import com.Waterboi.API.repository.WaterPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataPreloader implements CommandLineRunner{

    private final AppuserRepository appuserRepository;
    private final WaterPostRepository waterPostRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final PasswordEncoder passwordEncoder;

    public DataPreloader(AppuserRepository appuserRepository,
                         WaterPostRepository waterPostRepository,
                         UnitOfMeasureRepository unitOfMeasureRepository,
                         PasswordEncoder passwordEncoder) {
        this.appuserRepository = appuserRepository;
        this.waterPostRepository = waterPostRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Appuser appuser = new Appuser("user", passwordEncoder.encode("password"));
        appuserRepository.save(appuser);
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure("liter", 1);
        unitOfMeasureRepository.save(unitOfMeasure);
        unitOfMeasureRepository.save(new UnitOfMeasure("cup", 0.236588));
        unitOfMeasureRepository.save(new UnitOfMeasure("pint", 0.473176));
        unitOfMeasureRepository.save(new UnitOfMeasure("quart", 0.946353));
        unitOfMeasureRepository.save(new UnitOfMeasure("gallon", 3.78541));

        waterPostRepository.save(
                new WaterPost(//1L, 1.0, 1L, LocalDateTime.now()
                        appuserRepository.findByUsernameIgnoreCase(appuser.getUsername()).orElseThrow().getId(),
                        1,
                        unitOfMeasureRepository.findByNameIgnoreCase(unitOfMeasure.getName()).orElseThrow().getId(),
                        LocalDateTime.now()
                )
        );
    }
}
