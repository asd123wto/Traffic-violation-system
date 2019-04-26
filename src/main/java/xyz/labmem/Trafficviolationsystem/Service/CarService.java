package xyz.labmem.Trafficviolationsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.labmem.Trafficviolationsystem.Entity.CarEntity;
import xyz.labmem.Trafficviolationsystem.Mapper.CarMapper;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Service
public class CarService implements CarMapper {

    @Autowired
    private CarMapper carMapper;

    /**
     * 通过carid查询车辆及拥有者信息
     *
     * @param CarId
     * @return
     */
    @Override
    public CarEntity findWithDriverByCarId(String CarId) {
        return carMapper.findWithDriverByCarId(CarId);
    }

    /**
     * 通过车牌号获取信息
     *
     * @param NumberPlate
     * @return
     */
    @Override
    public CarEntity findWithDriverByNumberPlate(String NumberPlate) {
        return carMapper.findWithDriverByNumberPlate(NumberPlate);
    }

    /**
     * 添加车辆
     * @param carEntity
     */
    @Override
    public void addCar(CarEntity carEntity) {
        carMapper.addCar(carEntity);
    }
}
