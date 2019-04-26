package xyz.labmem.Trafficviolationsystem.VO;

/**
 * @author Labmem-刘天予
 * @date 2019/4/26
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("Success");
        resultVO.setCode(200);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(String msg, Integer code) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

    /**
     * 默认错误
     *
     * @param msg
     * @return
     */
    public static ResultVO error(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(333);
        return resultVO;
    }

    /**
     * 异常错误
     *
     * @param msg
     * @return
     */
    public static ResultVO exError(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(444);
        return resultVO;
    }

    public static ResultVO error(String msg, Integer code, Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}
