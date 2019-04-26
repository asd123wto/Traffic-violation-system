package xyz.labmem.Trafficviolationsystem.ApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.labmem.Trafficviolationsystem.Entity.CarEntity;
import xyz.labmem.Trafficviolationsystem.Entity.DirverEntity;
import xyz.labmem.Trafficviolationsystem.Entity.TicketEntity;
import xyz.labmem.Trafficviolationsystem.Service.CarService;
import xyz.labmem.Trafficviolationsystem.Service.DriverService;
import xyz.labmem.Trafficviolationsystem.Service.TicketService;
import xyz.labmem.Trafficviolationsystem.VO.ResultVO;
import xyz.labmem.Trafficviolationsystem.VO.ResultVOUtil;
import xyz.labmem.Trafficviolationsystem.utils.Conversion;

import java.util.Date;
import java.util.Map;

/**
 * @author Labmem-刘天予
 * @date 2019/4/27
 */
@RestController
public class ApiController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private CarService carService;

    @Autowired
    private DriverService driverService;

    /**
     * 添加违章通知
     *
     * @param numberPlate 车牌号
     * @param Id          编号
     * @param address     地点
     * @param record      记载
     * @param violation   违章时间
     * @param punishment  处罚方式
     * @param policeName  警察签字
     * @param policeNo    警察编号
     * @param partyName   处罚人姓名
     * @return json
     */
    @PostMapping("/addTicket")
    public ResultVO<Map<String, String>> addTicket(@RequestParam("numberPlate") String numberPlate, @RequestParam("Id") String Id,
                                                   @RequestParam("address") String address, @RequestParam("record") String record, @RequestParam("violation") String violation
            , @RequestParam("punishment") String punishment, @RequestParam("policeName") String policeName, @RequestParam("policeNo") String policeNo,
                                                   @RequestParam("partyName") String partyName) {
        try {
            CarEntity carEntity = null;
            if (!numberPlate.trim().equals("")) {
                carEntity = carService.findWithDriverByNumberPlate(numberPlate);
                if (carEntity == null)
                    return ResultVOUtil.error("车牌号有误，请先确认车牌号");
            } else
                return ResultVOUtil.error("车牌号有误，请先确认车牌号");
            System.out.println(carEntity.getId());
            if (Id.trim().length() != 7)
                return ResultVOUtil.error("请输入7位违章编号");
            if (address.trim().length() > 200 || address.trim().length() < 1)
                return ResultVOUtil.error("请输入小于200字的违章地点");
            if (record.trim().length() > 200 || record.trim().length() < 1)
                return ResultVOUtil.error("请输入小于200字的违章记载");
            if (violation.trim().length() < 2)
                return ResultVOUtil.error("请输入违章日期");
            if (policeName.trim().length() < 1 || policeName.trim().length() > 20)
                return ResultVOUtil.error("请输入警察签名 小于20字");
            if (policeNo.trim().length() != 6)
                return ResultVOUtil.error("请输入警察编号 6位");
            if (partyName.trim().length() < 1 || partyName.trim().length() > 20)
                return ResultVOUtil.error("请输入被处罚人姓名 小于20字");
            if (ticketService.findById(Id) != null)
                return ResultVOUtil.error("该违章编号已存在");
            TicketEntity ticketEntity = new TicketEntity();
            ticketEntity.setId(Id);
            ticketEntity.setCarId(carEntity.getId());
            ticketEntity.setAddress(address);
            ticketEntity.setRecord(record);
            ticketEntity.setViolationDate(Conversion.strToDate(violation));
            ticketEntity.setNoticeTime(new Date());
            ticketEntity.setPunishmentType(punishment);
            ticketEntity.setPoliceName(policeName);
            ticketEntity.setPoliceNo(policeNo);
            ticketEntity.setPartyName(partyName);
            ticketEntity.setCreateTime(new Date());
            ticketService.addTicket(ticketEntity);
        } catch (Exception e) {
            return ResultVOUtil.error(e.getMessage());
        }
        return ResultVOUtil.success();
    }

    /**
     * 确认车牌号
     *
     * @param NumberPlate 车牌号
     * @return
     */
    @PostMapping("/determineNP")
    public ResultVO<Map<String, String>> determineNumberPlate(@RequestParam("NumberPlate") String NumberPlate) {

        if (NumberPlate.trim().equals(""))
            return ResultVOUtil.error("请输入车牌号");

        CarEntity carEntity = carService.findWithDriverByNumberPlate(NumberPlate);
        if (carEntity == null)
            return ResultVOUtil.error("该车牌号未录入，请先录入信息");

        return ResultVOUtil.success(carEntity);
    }

    /**
     * 确认驾驶执照号
     *
     * @param DirverNo 驾驶执照号
     * @return
     */
    @PostMapping("/determineDN")
    public ResultVO<Map<String, String>> determineDirverNo(@RequestParam("DirverNo") String DirverNo) {

        if (DirverNo.trim().equals(""))
            return ResultVOUtil.error("驾驶执照号");
        DirverEntity dirverEntity = driverService.getDirverEntityByNo(DirverNo);
        if (dirverEntity == null)
            return ResultVOUtil.error("驾驶执照号未录入，请先录入信息");

        return ResultVOUtil.success(dirverEntity);
    }


    /**
     * 添加驾驶员信息
     *
     * @param dirverName 姓名
     * @param dirverNo   驾驶证号
     * @param address    地址
     * @param zip        邮编
     * @param phone      电话
     * @return
     */
    @PostMapping("/addDirver")
    public ResultVO<Map<String, String>> addDirver(@RequestParam("dirverName") String dirverName
            , @RequestParam("dirverNo") String dirverNo, @RequestParam("address") String address, @RequestParam("zip") String zip
            , @RequestParam("phone") String phone) {

        try {
            if (dirverName.trim().length() > 20 || dirverName.trim().length() < 2)
                return ResultVOUtil.error("请输入驾驶人员姓名 20字内");
            if (dirverNo.trim().length() != 18)
                return ResultVOUtil.error("请输入18位驾驶执照号 ");
            if (driverService.getDirverEntityByNo(dirverNo) != null)
                return ResultVOUtil.error("该驾驶执照号以存在");
            if (address.trim().length() > 100 || address.trim().length() < 5)
                return ResultVOUtil.error("请输入5-100字的地址 ");
            if (zip.trim().length() != 6)
                return ResultVOUtil.error("请输入6位邮编");
            if (phone.trim().length() < 4 || phone.trim().length() > 25)
                return ResultVOUtil.error("请输入4-25位电话号码");
            DirverEntity dirverEntity = new DirverEntity();
            dirverEntity.setName(dirverName);
            dirverEntity.setAddress(address);
            dirverEntity.setCreateTime(new Date());
            dirverEntity.setNum(dirverNo);
            dirverEntity.setPhone(phone);
            dirverEntity.setZip(zip);
            driverService.addDirver(dirverEntity);
        } catch (Exception e) {
            return ResultVOUtil.error(e.getMessage());
        }
        return ResultVOUtil.success();
    }


    /**
     * 添加车辆
     *
     * @param DirverNo     驾驶证号
     * @param numberPlate  车牌号
     * @param model        型号
     * @param manufacturer 制造厂
     * @param production   生产日期
     * @return
     */
    @PostMapping("/addCar")
    public ResultVO<Map<String, String>> addCar(@RequestParam("DirverNo") String DirverNo, @RequestParam("numberPlate") String numberPlate,
                                                @RequestParam("model") String model, @RequestParam("manufacturer") String manufacturer,
                                                @RequestParam("production") String production) {
        try {
            if (DirverNo.trim().length() != 18)
                return ResultVOUtil.error("请输入18位驾驶执照号 ");
            if (driverService.getDirverEntityByNo(DirverNo) == null)
                return ResultVOUtil.error("请先确认驾驶执照号存在");
            if (numberPlate.trim().length() != 8)
                return ResultVOUtil.error("请输入8位车牌号");
            if (model.trim().length() > 100 || model.trim().length() < 2)
                return ResultVOUtil.error("请输入100字内的车辆型号");
            if (manufacturer.trim().length() < 2 || manufacturer.trim().length() > 100)
                return ResultVOUtil.error("请输入100字内的制造厂");
            if (production.trim().length() < 2)
                return ResultVOUtil.error("请输入车辆生产日期");
            CarEntity carEntity = new CarEntity();
            carEntity.setDirveNo(DirverNo);
            carEntity.setModel(model);
            carEntity.setCreateTime(new Date());
            carEntity.setProduction(Conversion.strToDate(production));
            carEntity.setManufacturer(manufacturer);
            carEntity.setNumberPlate(numberPlate);
            carService.addCar(carEntity);
        } catch (Exception e) {
            return ResultVOUtil.error(e.getMessage());
        }
        return ResultVOUtil.success();
    }
}
