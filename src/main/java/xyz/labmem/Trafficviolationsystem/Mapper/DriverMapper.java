package xyz.labmem.Trafficviolationsystem.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.labmem.Trafficviolationsystem.Entity.DirverEntity;
import xyz.labmem.Trafficviolationsystem.Entity.TicketEntity;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Mapper
public interface DriverMapper {

    //驾驶员信息表
    String database="dirver";


    /**
     * 通过drive_no查找
     * @param dirveNo
     * @return
     */
    @Select("SELECT * FROM "+database+" WHERE num=#{dirveNo}")
    DirverEntity getDirverEntityByNo(String dirveNo);

    /**
     * 添加驾驶员信息
     * @param dirverEntity
     */
    @Insert("INSERT INTO " + database + "(num,name,address,zip,phone,create_time) VALUES(#{num}, #{name}, #{address},#{zip},#{phone}" +
            ",#{createTime})")
    void addDirver(DirverEntity dirverEntity);

}
