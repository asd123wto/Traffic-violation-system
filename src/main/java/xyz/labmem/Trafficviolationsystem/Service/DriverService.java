package xyz.labmem.Trafficviolationsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.labmem.Trafficviolationsystem.Entity.DirverEntity;
import xyz.labmem.Trafficviolationsystem.Mapper.DriverMapper;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Service
public class DriverService implements DriverMapper {

    @Autowired
    private DriverMapper driverMapper;

    /**
     * 通过驾驶执照号查询信息
     * @param driveNo
     * @return
     */
    @Override
    public DirverEntity getDirverEntityByNo(String driveNo) {
        return driverMapper.getDirverEntityByNo(driveNo);
    }

    @Override
    public void addDirver(DirverEntity dirverEntity) {
        driverMapper.addDirver(dirverEntity);
    }
}
