package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.service.RegionStoredProcedureService;
import ua.lviv.iot.repository.RegionRepository;
import ua.lviv.iot.domain.Region;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class RegionStoredProcedureServiceImp implements RegionStoredProcedureService {
    @Autowired
    RegionRepository regionRepository;

    @Transactional
    @Override
    public List<Region> insertNonameRegions() {
        return regionRepository.insertNonameRegions();
    }
}
