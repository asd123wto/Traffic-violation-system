package xyz.labmem.Trafficviolationsystem.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.labmem.Trafficviolationsystem.Entity.TicketEntity;
import xyz.labmem.Trafficviolationsystem.Service.TicketService;
import xyz.labmem.Trafficviolationsystem.excption.SellExcption;
import xyz.labmem.Trafficviolationsystem.utils.Conversion;

import java.util.List;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Controller
public class IndexController {

    @Autowired
    private TicketService ticketService;

    /**
     * 首页
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {
        try {
            List<TicketEntity> Tickets = ticketService.findAllInfo();
            model.addAttribute("Conversion", new Conversion());
            model.addAttribute("Tickets", Tickets);
        } catch (Exception e) {
            throw new SellExcption(e.getMessage());
        }
        return "index";
    }

    /**
     * 交通违章通知书
     *
     * @param id
     * @return
     */
    @GetMapping("/Ticket/{id}")
    public String ticketInfo(@PathVariable String id, Model model) {
        try {
            if (id.trim().equals(""))
                return "error/404";
            TicketEntity Ticket = ticketService.findInfoById(id);
            if(Ticket==null)
                return "error/404";
            JSONObject Result =JSON.parseObject(Ticket.getPunishmentType());
            //警告
            if(Result.get("1").equals(0))
                model.addAttribute("select1", false);
            else
                model.addAttribute("select1", true);
            //罚款
            if(Result.get("2").equals(0))
                model.addAttribute("select2", false);
            else
                model.addAttribute("select2", true);
            //暂扣驾驶证
            if(Result.get("3").equals(0))
                model.addAttribute("select3", false);
            else
                model.addAttribute("select3", true);
            model.addAttribute("Ticket", Ticket);
            model.addAttribute("ViolationDate", Conversion.dateToStrLong(Ticket.getViolationDate()));
            model.addAttribute("Production", Conversion.dateToStrLong(Ticket.getCarEntity().getProduction()));
            model.addAttribute("NoticeTime",  Conversion.dateToStrLong(Ticket.getNoticeTime()));
        } catch (Exception e) {
            throw new SellExcption(e.getMessage());
        }
        return "ticket";
    }

    /**
     * 添加通知书
     *
     * @return
     */
    @GetMapping("/addTicket")
    public String managementTicket() {
        return "addTicket";
    }

    /**
     * 添加汽车
     *
     * @return
     */
    @GetMapping("/addCar")
    public String managementCar() {

        return "addCar";
    }

    /**
     * 添加驾驶人员信息
     *
     * @return
     */
    @GetMapping("/addDirver")
    public String managementDirver() {
        return "addDirver";
    }

}
