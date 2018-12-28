package xin.inote.my.shop.web.admin.service;

import xin.inote.my.shop.commons.dto.BaseResult;
import xin.inote.my.shop.commons.dto.PageInfo;
import xin.inote.my.shop.domain.TbContent;

public interface TbContentService {
    PageInfo<TbContent> page(int start, int length, int draw, TbContent tbContent);

    BaseResult save(TbContent tbContent);

    void deleteMulti(String[] idArray);

    TbContent getById(Long id);
}
