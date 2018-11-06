package linghu.service.impl;

import linghu.dto.AreaDTO;
import linghu.entity.Area;
import linghu.repository.IAreaRepository;
import linghu.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    IAreaRepository areaRepository;

    @Override
    public AreaDTO findCityByCode(String code) {
        AreaDTO dto = new AreaDTO();
        Area city = areaRepository.findByCode(code);
        dto.setName(city.getName());
        return dto;
    }

    @Override
    public List<AreaDTO> findCityByLevel(String level) {
        List<Area> citys = areaRepository.findAreaByCityLevel(level);
        return null;
    }
}
