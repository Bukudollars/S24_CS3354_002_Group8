package com.Waterboi.API.component;

import com.Waterboi.API.entity.Appuser;
import com.Waterboi.API.entity.Unit;
import com.Waterboi.API.entity.WaterPost;
import com.Waterboi.API.repository.AppuserRepository;
import com.Waterboi.API.repository.UnitRepository;
import com.Waterboi.API.repository.WaterPostRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataPreloader implements CommandLineRunner{

    private final AppuserRepository appuserRepository;
    private final WaterPostRepository waterPostRepository;
    private final UnitRepository unitOfMeasureRepository;
    private final PasswordEncoder passwordEncoder;

    public DataPreloader(AppuserRepository appuserRepository,
                         WaterPostRepository waterPostRepository,
                         UnitRepository unitOfMeasureRepository,
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
        Unit unitOfMeasure = new Unit("liter", 1);
        unitOfMeasureRepository.save(unitOfMeasure);
        unitOfMeasureRepository.save(new Unit("cup", 0.236588));
        unitOfMeasureRepository.save(new Unit("pint", 0.473176));
        unitOfMeasureRepository.save(new Unit("quart", 0.946353));
        unitOfMeasureRepository.save(new Unit("gallon", 3.78541));

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
