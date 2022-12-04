package ua.lviv.iot.service;

import ua.lviv.iot.domain.Region;

import java.util.List;

public interface RegionStoredProcedureService {
    List<Region> insertNonameRegions();
}
