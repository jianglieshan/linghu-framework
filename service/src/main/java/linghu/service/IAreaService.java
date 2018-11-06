package linghu.service;

import linghu.dto.AreaDTO;

import java.util.List;

public interface IAreaService {
    AreaDTO findCityByCode(String code);
    List<AreaDTO> findCityByLevel(String level);

}
