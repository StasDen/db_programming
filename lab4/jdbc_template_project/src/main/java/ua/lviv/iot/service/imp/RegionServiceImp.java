package ua.lviv.iot.service.imp;

import ua.lviv.iot.dao.RegionDao;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import ua.lviv.iot.service.RegionService;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImp implements RegionService {
    @Autowired
    public RegionDao regionDao;

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public Optional<Region> findById(Integer id) {
        return regionDao.findById(id);
    }

    @Override
    public int create(Region region) {
        return regionDao.create(region);
    }

    @Override
    public int update(Integer id, Region region) {
        return regionDao.update(id, region);
    }

    @Override
    public int delete(Integer id) {
        return regionDao.delete(id);
    }
}
