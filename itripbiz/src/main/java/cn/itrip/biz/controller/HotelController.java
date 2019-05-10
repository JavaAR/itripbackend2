package cn.itrip.biz.controller;

import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripAreaDicVO;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.biz.service.areadic.ItripAreaDicService;
import cn.itrip.biz.service.labeldic.ItripLabelDicService;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.ErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 酒店控制层
 */
@RequestMapping(value = "api/hotel")
@Controller
public class HotelController {
    @Resource
    private ItripAreaDicService itripAreaDicService;
    @Resource
    private ItripLabelDicService itripLabelDicService;

    /**
     * 查询酒店特色
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryhotelfeature",method = RequestMethod.GET,produces = "application/json")
    public Dto doQueryHotelFeatyre(){
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("parentId",16);
            List<ItripLabelDic> itripLabelDics = itripLabelDicService.getItripLabelDicListByMap(map);
            if (EmptyUtils.isNotEmpty(itripLabelDics)){
                ArrayList<ItripLabelDicVO> itripLabelDicVOS = new ArrayList<>();
                for (ItripLabelDic itripLabelDic : itripLabelDics) {
                    ItripLabelDicVO itripLabelDicVO = new ItripLabelDicVO();
                    BeanUtils.copyProperties(itripLabelDic,itripLabelDicVO);
                    itripLabelDicVOS.add(itripLabelDicVO);
                }
                return DtoUtil.returnDataSuccess(itripLabelDicVOS);
            }else{
                return DtoUtil.returnFail("查询失败",ErrorCode.BIZ_QUERY_FILED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("服务器异常",ErrorCode.BIZ_UNKNOWN);
        }

    }
    /**
     * 查询区域热门酒店
     * @param isChian
     * @return
     */
    @RequestMapping(value = "queryhotcity/{isChian}",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Dto doQueryHotCity(@PathVariable Integer isChian){
        //1 判空
        try {
            if(EmptyUtils.isNotEmpty(isChian)){
                //2 组织参数
                HashMap<String, Object> map = new HashMap<>();
                map.put("isChian",isChian);
                map.put("isHot",1);
                List<ItripAreaDic> itripAreaDicList = itripAreaDicService.getItripAreaDicListByMap(map);
               if (EmptyUtils.isNotEmpty(itripAreaDicList)){
                   ArrayList<ItripAreaDicVO> itripAreaDicVOS = new ArrayList<>();
                   for (ItripAreaDic itripAreaDic : itripAreaDicList) {
                       //组织返回给前端的数据
                       ItripAreaDicVO itripAreaDicVO = new ItripAreaDicVO();
                       BeanUtils.copyProperties(itripAreaDic,itripAreaDicVO);
                       itripAreaDicVOS.add(itripAreaDicVO);
                   }
                return DtoUtil.returnDataSuccess(itripAreaDicVOS);
               }else{
                   return DtoUtil.returnFail("查询失败",ErrorCode.BIZ_QUERY_FILED);
               }
            }else {
                return DtoUtil.returnFail("参数错误", ErrorCode.BIZ_PARAMETER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("服务器异常",ErrorCode.BIZ_UNKNOWN);
        }
    }
}
