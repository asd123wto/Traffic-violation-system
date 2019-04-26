package xyz.labmem.Trafficviolationsystem.Mapper;

import org.apache.ibatis.annotations.*;
import xyz.labmem.Trafficviolationsystem.Entity.CarEntity;
import xyz.labmem.Trafficviolationsystem.Entity.DirverEntity;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Mapper
public interface CarMapper {

    String database="car";

    /**
     * 通过carid获取信息
     * @param CarId
     * @return
     */
    @Select("SELECT * FROM "+database+" where id=#{CarId}")
    @Results({
            @Result(property = "dirverEntity", column = "dirve_no", one = @One(select = "xyz.labmem.Trafficviolationsystem.Mapper.DriverMapper.getDirverEntityByNo"))
    })
    CarEntity findWithDriverByCarId(String CarId);

    /**
     * 通过车牌号获取信息
     * @param NumberPlate
     * @return
     */
    @Select("SELECT * FROM "+database+" where number_plate=#{NumberPlate}")
    @Results({
            @Result(property = "dirverEntity", column = "dirve_no", one = @One(select = "xyz.labmem.Trafficviolationsystem.Mapper.DriverMapper.getDirverEntityByNo"))
    })
    CarEntity findWithDriverByNumberPlate(String NumberPlate);


    /**
     * 添加车辆
     * @param carEntity
     */
    @Insert("INSERT INTO " + database + "(dirve_no,model,number_plate,manufacturer,production,create_time) VALUES(#{dirveNo}, #{model}, #{numberPlate},#{manufacturer},#{production}" +
            ",#{createTime})")
    void addCar(CarEntity carEntity);

}
