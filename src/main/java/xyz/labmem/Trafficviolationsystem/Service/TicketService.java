package xyz.labmem.Trafficviolationsystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.labmem.Trafficviolationsystem.Entity.CarEntity;
import xyz.labmem.Trafficviolationsystem.Entity.TicketEntity;
import xyz.labmem.Trafficviolationsystem.Mapper.TicketMapper;

import java.util.List;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Service
public class TicketService implements TicketMapper {

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public TicketEntity findInfoById(String Id) {
        return ticketMapper.findInfoById(Id);
    }

    @Override
    public List<TicketEntity> findAllInfo() {
        return ticketMapper.findAllInfo();
    }

    @Override
    public void addTicket(TicketEntity ticketEntity) {
        ticketMapper.addTicket(ticketEntity);
    }

    @Override
    public TicketEntity findById(String Id) {
        return ticketMapper.findById(Id);
    }
}
