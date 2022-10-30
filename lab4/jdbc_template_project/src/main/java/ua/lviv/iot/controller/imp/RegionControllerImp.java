package ua.lviv.iot.controller.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Region;
import ua.lviv.iot.service.RegionService;
import ua.lviv.iot.controller.RegionController;

import java.util.List;
import java.util.Optional;

@Service
public class RegionControllerImp implements RegionController {
    @Autowired
    public RegionService regionService;

    @Override
    public List<Region> findAll() {
        return regionService.findAll();
    }

    @Override
    public Optional<Region> findById(Integer id) {
        return regionService.findById(id);
    }

    @Override
    public int create(Region region) {
        return regionService.create(region);
    }

    @Override
    public int delete(Integer id) {
        return regionService.delete(id);
    }

    @Override
    public int update(Integer id, Region region) {
        return regionService.update(id, region);
    }
}
