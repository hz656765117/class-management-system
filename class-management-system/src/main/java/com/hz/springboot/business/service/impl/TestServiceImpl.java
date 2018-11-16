package com.hz.springboot.business.service.impl;



import com.hz.springboot.base.utils.DateUtil;
import com.hz.springboot.business.mybatis.mapper.MkmRecommendPopupRecordsPoMapper;
import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPo;
import com.hz.springboot.business.pojo.MkmRecommendPopupRecordsPoExample;
import com.hz.springboot.business.service.TestService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


    @Autowired
    private MkmRecommendPopupRecordsPoMapper mkmRecommendPopupRecordsPoMapper;


    @Override
    public boolean checkNeedPopup(String channel) {
        List<MkmRecommendPopupRecordsPo> mkmRecommendPopupRecordsPos = queryPopupList(channel);
        return mkmRecommendPopupRecordsPos != null && mkmRecommendPopupRecordsPos.size() > 0 ? true : false;
    }


    public List<MkmRecommendPopupRecordsPo> queryPopupList(String channel) {
        MkmRecommendPopupRecordsPoExample example = new MkmRecommendPopupRecordsPoExample();
        String curTime = DateUtil.convertDateToString(new Date(), DateUtil.dataFormatHHmmss);
        example.createCriteria().andEffectBeginTimeLessThanOrEqualTo(curTime).andEffectEndTimeGreaterThanOrEqualTo(curTime).andChannelEqualTo(channel);
        List<MkmRecommendPopupRecordsPo> mkmRecommendPopupRecordsPos = mkmRecommendPopupRecordsPoMapper.selectByExample(example);
        logger.info("数据条数为：{}", mkmRecommendPopupRecordsPos != null ? mkmRecommendPopupRecordsPos.size() : 0);
        return mkmRecommendPopupRecordsPos;
    }


}
