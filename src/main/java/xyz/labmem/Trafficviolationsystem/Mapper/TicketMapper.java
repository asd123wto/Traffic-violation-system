package xyz.labmem.Trafficviolationsystem.Mapper;

import org.apache.ibatis.annotations.*;
import xyz.labmem.Trafficviolationsystem.Entity.CarEntity;
import xyz.labmem.Trafficviolationsystem.Entity.TicketEntity;

import java.util.List;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Mapper
public interface TicketMapper {

    String database = "ticket";

    /**
     * 通过处罚编号查询通知书
     *
     * @param Id
     * @return
     */
    @Select("SELECT * FROM " + database + " where id=#{Id}")
    @Results({
            @Result(property = "carEntity", column = "car_id", one = @One(select = "xyz.labmem.Trafficviolationsystem.Mapper.CarMapper.findWithDriverByCarId"))
    })
    TicketEntity findInfoById(String Id);


    /**
     * 通过处罚编号查询通知书
     *
     * @param Id
     * @return
     */
    @Select("SELECT * FROM " + database + " where id=#{Id}")
    TicketEntity findById(String Id);


    /**
     * 获取全部处罚通知书
     *
     * @return
     */
    @Select("SELECT * FROM " + database)
    @Results({
            @Result(property = "carEntity", column = "car_id", one = @One(select = "xyz.labmem.Trafficviolationsystem.Mapper.CarMapper.findWithDriverByCarId"))
    })
    List<TicketEntity> findAllInfo();

    /**
     * 添加处罚书
     * @param ticketEntity
     */
    @Insert("INSERT INTO " + database + "(id,car_id,address,record,violation_date,notice_time,punishment_type," +
            "police_name,police_no,party_name,create_time) VALUES(#{id}, #{carId}, #{address},#{record},#{violationDate}" +
            ",#{noticeTime},#{punishmentType},#{policeName},#{policeNo},#{partyName},#{createTime})")
    void addTicket(TicketEntity ticketEntity);

}
