package xin.inote.my.shop.domain;

import lombok.Data;
import xin.inote.my.shop.commons.persistence.BaseEntity;
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    private Boolean isParent;

}
