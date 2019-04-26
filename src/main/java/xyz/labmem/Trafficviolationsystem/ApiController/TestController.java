package xyz.labmem.Trafficviolationsystem.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.labmem.Trafficviolationsystem.Entity.CarEntity;
import xyz.labmem.Trafficviolationsystem.Entity.DirverEntity;
import xyz.labmem.Trafficviolationsystem.Entity.TicketEntity;
import xyz.labmem.Trafficviolationsystem.Mapper.TicketMapper;
import xyz.labmem.Trafficviolationsystem.Service.CarService;
import xyz.labmem.Trafficviolationsystem.Service.DriverService;
import xyz.labmem.Trafficviolationsystem.Service.TicketService;
import xyz.labmem.Trafficviolationsystem.VO.ResultVO;
import xyz.labmem.Trafficviolationsystem.VO.ResultVOUtil;

import java.util.List;
import java.util.Map;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@RestController
public class TestController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/test")
    public ResultVO<Map<String, String>> test(){
        CarEntity carEntity=carService.findWithDriverByCarId("1");
        return ResultVOUtil.success(carEntity);
    }

    @GetMapping("/test1")
    public ResultVO<Map<String, String>> test1(){
        DirverEntity carEntity=driverService.getDirverEntityByNo("1");
        return ResultVOUtil.success(carEntity);
    }

    @GetMapping("/test2")
    public ResultVO<Map<String, String>> test2(){
        List<TicketEntity> ticketEntity=ticketService.findAllInfo();
        return ResultVOUtil.success(ticketEntity);
    }

}
