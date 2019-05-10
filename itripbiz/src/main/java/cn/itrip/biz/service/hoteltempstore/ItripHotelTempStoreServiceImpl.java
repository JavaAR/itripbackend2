package cn.itrip.biz.service.hoteltempstore;

import cn.itrip.beans.vo.store.StoreVO;
import cn.itrip.dao.hoteltempstore.ItripHotelTempStoreMapper;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.itrip.common.Constants;

@Service
public class ItripHotelTempStoreServiceImpl implements ItripHotelTempStoreService {

    @Resource
    private ItripHotelTempStoreMapper itripHotelTempStoreMapper;

    public ItripHotelTempStore getItripHotelTempStoreById(Long id) throws Exception {
        return itripHotelTempStoreMapper.getItripHotelTempStoreById(id);
    }

    public List<ItripHotelTempStore> getItripHotelTempStoreListByMap(Map<String, Object> param) throws Exception {
        return itripHotelTempStoreMapper.getItripHotelTempStoreListByMap(param);
    }

    public Integer getItripHotelTempStoreCountByMap(Map<String, Object> param) throws Exception {
        return itripHotelTempStoreMapper.getItripHotelTempStoreCountByMap(param);
    }

    public Integer itriptxAddItripHotelTempStore(ItripHotelTempStore itripHotelTempStore) throws Exception {
        itripHotelTempStore.setCreationDate(new Date());
        return itripHotelTempStoreMapper.insertItripHotelTempStore(itripHotelTempStore);
    }

    public Integer itriptxModifyItripHotelTempStore(ItripHotelTempStore itripHotelTempStore) throws Exception {
        itripHotelTempStore.setModifyDate(new Date());
        return itripHotelTempStoreMapper.updateItripHotelTempStore(itripHotelTempStore);
    }

    public Integer itriptxDeleteItripHotelTempStoreById(Long id) throws Exception {
        return itripHotelTempStoreMapper.deleteItripHotelTempStoreById(id);
    }

    public Page<ItripHotelTempStore> queryItripHotelTempStorePageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize) throws Exception {
        Integer total = itripHotelTempStoreMapper.getItripHotelTempStoreCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripHotelTempStore> itripHotelTempStoreList = itripHotelTempStoreMapper.getItripHotelTempStoreListByMap(param);
        page.setRows(itripHotelTempStoreList);
        return page;
    }

    /***
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param roomId    房间ID
     * @param hotelId   酒店ID
     * @return
     * @throws Exception
     */
    @Override
    public List<StoreVO> queryRoomStore(Map<String, Object> param) throws Exception {
        itripHotelTempStoreMapper.flushStore(param);
        return itripHotelTempStoreMapper.queryRoomStore(param);
    }

    /***
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param roomId    房间ID
     * @param hotelId   酒店ID
     * @param count     数目
     * @return
     * @throws Exception
     */
    @Override
    public boolean validateRoomStore(Map<String, Object> param) throws Exception {
        Integer count = (Integer) param.get("count");
        itripHotelTempStoreMapper.flushStore(param);
        List<StoreVO> storeVOList = itripHotelTempStoreMapper.queryRoomStore(param);
        if(EmptyUtils.isEmpty(storeVOList)){
            return false;
        }
        for (StoreVO vo : storeVOList) {
            if (vo.getStore() < count) {
                return false;
            }
        }
        return true;
    }

    /***
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param roomId    房间ID
     * @param count     数目
     * @return
     * @throws Exception
     */
    public boolean updateRoomStore(Map<String, Object> param) throws Exception {
        Integer flag = itripHotelTempStoreMapper.updateRoomStore(param);
        return flag == 0 ? false : true;
    }
}
