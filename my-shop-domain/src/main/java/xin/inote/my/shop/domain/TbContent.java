package xin.inote.my.shop.domain;

import lombok.Data;
import xin.inote.my.shop.commons.persistence.BaseEntity;
@Data
public class TbContent extends BaseEntity {
    private Long categoryId;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;

}
