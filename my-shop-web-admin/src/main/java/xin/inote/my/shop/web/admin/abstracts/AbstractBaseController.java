package xin.inote.my.shop.web.admin.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import xin.inote.my.shop.commons.persistence.BaseEntity;
import xin.inote.my.shop.commons.persistence.BaseService;

public abstract class AbstractBaseController<T extends BaseEntity,S extends BaseService<T>> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;
}
