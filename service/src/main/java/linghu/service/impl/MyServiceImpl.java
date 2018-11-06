package linghu.service.impl;

import linghu.entity.Area;
import linghu.repository.IAreaRepository;
import linghu.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Autowired
    IAreaRepository areaRepository;


    @Override
    public Area hello() {
        Area a = areaRepository.findByCode("0");
        System.out.println("hello"+a.getName());
        return a;
    }
}
