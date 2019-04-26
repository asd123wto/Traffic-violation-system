package xyz.labmem.Trafficviolationsystem.Entity;

import lombok.Data;

import java.util.Date;

/**
 * 驾驶人员
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Data
public class DirverEntity {

    //驾驶执照号
    private String num;

    //姓名
    private String name;

    //地址
    private String address;

    //邮编
    private String zip;

    //电话
    private String phone;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //标记
    private String flag;


}
