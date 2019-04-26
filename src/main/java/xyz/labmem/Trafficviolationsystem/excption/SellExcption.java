package xyz.labmem.Trafficviolationsystem.excption;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
public class SellExcption extends RuntimeException {

    private Integer code;

    public SellExcption(String message) {
        super(message);
        this.code = 40001;
    }

    public SellExcption(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
