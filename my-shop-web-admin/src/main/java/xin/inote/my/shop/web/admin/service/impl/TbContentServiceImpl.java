package xin.inote.my.shop.web.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.commons.validator.BeanValidator;
import xin.inote.my.shop.domain.TbContent;
import xin.inote.my.shop.web.admin.dao.TbContentDao;
import xin.inote.my.shop.web.admin.service.TbContentService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TbContentServiceImpl implements TbContentService {
    @Autowired
    TbContentDao tbContentDao;
    @Override
    public BaseResult save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        //验证不通过
        if (validator != null){
          return BaseResult.fail(validator);
        }{
            tbContent.setUpdated(new Date());
            // 新增
            if (tbContent.getId() == null) {
                tbContent.setCreated(new Date());
                tbContentDao.insert(tbContent);
            }

            // 编辑内容
            else {
                tbContentDao.update(tbContent);
            }
            return BaseResult.success("保存内容信息成功");
        }

    }

    @Override
    public TbContent getById(Long id) {
        return tbContentDao.getById(id);
    }

    @Override
    public void deleteMulti(String[] idArray) {
        tbContentDao.deleteMulti(idArray);
    }

    @Override
    public PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent) {
        Map<String,Object> map = new HashMap<>();
        int count = tbContentDao.count(tbContent);
        map.put("start",start);
        map.put("length",length);
        map.put("tbContent",tbContent);
        PageInfo<TbContent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);

        pageInfo.setData(tbContentDao.page(map));
        return pageInfo;
    }
}

