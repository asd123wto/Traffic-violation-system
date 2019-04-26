package xyz.labmem.Trafficviolationsystem.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Data
public class TicketEntity {

    //违章编号
    private String id;

    //违章车辆id
    private Integer carId;

    //违章地点
    private String address;

    //违章记载
    private String record;

    //违章日期
    private Date violationDate;

    //通知时间
    private Date noticeTime;

    //处罚方式
    private String punishmentType;

    //警察签字
    private String policeName;

    //警察编号
    private String policeNo;

    //处罚人姓名
    private String partyName;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //标记
    private String flag;

    //汽车表
    private CarEntity carEntity;
}
