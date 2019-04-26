package xyz.labmem.Trafficviolationsystem.VO;

import lombok.Data;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
@Data
public class ResultVO<T> {

    //状态码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;

}
