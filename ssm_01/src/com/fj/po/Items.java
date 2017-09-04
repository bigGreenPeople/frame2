package com.fj.po;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fj.valid.ValidGroup1;
import com.fj.valid.ValidGroup2;

public class Items {
    private Integer id;

    private Date createtime;
    @NotEmpty(message="{item.price.notNull.erro}",groups={ValidGroup1.class})
    private String detail;
    //商品名必须在1到30个字符
    @Size(min=1,max=30,message="{item.name.length.erro}",groups={ValidGroup2.class})
    private String name;

    private Float pic;
    //商品的价格不能为空
   
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPic() {
        return pic;
    }

    public void setPic(Float pic) {
        this.pic = pic;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}