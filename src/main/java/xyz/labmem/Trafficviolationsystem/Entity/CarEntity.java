package xyz.labmem.Trafficviolationsystem.Entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Data
public class CarEntity {

    //Id
    private Integer id;

    //驾驶执照号
    private String dirveNo;

    //车辆型号
    private String model;

    //车牌号
    private String numberPlate;

    //制造厂
    private String manufacturer;

    //生产日期
    private Date production;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //标记
    private String flag;

    //驾照表
    private DirverEntity dirverEntity;

}
