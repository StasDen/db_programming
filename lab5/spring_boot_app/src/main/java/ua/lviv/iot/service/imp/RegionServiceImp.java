package ua.lviv.iot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.repository.RegionRepository;
import ua.lviv.iot.service.RegionService;
import ua.lviv.iot.exception.RegionNotFoundException;

import javax.transaction.Transactional;

import java.util.List;

@Service
public class RegionServiceImp implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    public Region findById(Integer id) {
        return regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException(id));
    }

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Transactional
    public Region create(Region region) {
        regionRepository.save(region);
        return region;
    }

    @Transactional
    public void update(Integer id, Region uRegion) {
        Region region = regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException(id));
        region.setName(uRegion.getName());
        regionRepository.save(region);
    }

    @Transactional
    public void delete(Integer id) {
        Region region = regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException(id));
        regionRepository.delete(region);
    }
}
