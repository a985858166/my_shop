package xin.inote.my.shop.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import xin.inote.my.shop.commons.persistence.BaseEntity;

import javax.validation.constraints.NotNull;

@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    @Length(min = 1,max = 20,message = "分类名称必须介于1-20位之间")
    private String name;
    private Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    private Boolean isParent;
    private TbContentCategory parent;

}
