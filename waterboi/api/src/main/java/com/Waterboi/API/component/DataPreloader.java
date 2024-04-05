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

        unitOfMeasureRepository.save(new Unit("liter", 1));
        unitOfMeasureRepository.save(new Unit("cup", 0.236588));
        unitOfMeasureRepository.save(new Unit("pint", 0.473176));
        unitOfMeasureRepository.save(new Unit("quart", 0.946353));
        unitOfMeasureRepository.save(new Unit("gallon", 3.78541));
        loadDevData();

    }

    private void loadDevData() {
        Appuser appuser = new Appuser("user", passwordEncoder.encode("password"));
        appuserRepository.save(appuser);
        waterPostRepository.save(
                new WaterPost(
                        appuserRepository.findByUsernameIgnoreCase(appuser.getUsername()).orElseThrow().getId(),
                        1,
                        unitOfMeasureRepository.findByNameIgnoreCase("liter").orElseThrow().getId(),
                        LocalDateTime.now()
                )
        );
        waterPostRepository.save(
                new WaterPost(
                        appuserRepository.findByUsernameIgnoreCase(appuser.getUsername()).orElseThrow().getId(),
                        1,
                        unitOfMeasureRepository.findByNameIgnoreCase("liter").orElseThrow().getId(),
                        LocalDateTime.now().minusDays(2L)
                )
        );
        waterPostRepository.save(
                new WaterPost(
                        appuserRepository.findByUsernameIgnoreCase(appuser.getUsername()).orElseThrow().getId(),
                        1,
                        unitOfMeasureRepository.findByNameIgnoreCase("liter").orElseThrow().getId(),
                        LocalDateTime.now().minusWeeks(2L)
                )
        );
        waterPostRepository.save(
                new WaterPost(
                        appuserRepository.findByUsernameIgnoreCase(appuser.getUsername()).orElseThrow().getId(),
                        1,
                        unitOfMeasureRepository.findByNameIgnoreCase("liter").orElseThrow().getId(),
                        LocalDateTime.now().minusMonths(2L)
                )
        );
    }
}
