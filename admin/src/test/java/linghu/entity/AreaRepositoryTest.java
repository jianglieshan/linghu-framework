package linghu.entity;

import linghu.ApplicationTests;
import linghu.dto.AreaDTO;
import linghu.service.IAreaService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaRepositoryTest extends ApplicationTests {
    @Autowired
    IAreaService areaService;

    @Test
    public void testFindOne(){
        AreaDTO a = areaService.findCityByCode("0");
        Assert.assertEquals("中华人民共和国",a.getName());
    }
}
