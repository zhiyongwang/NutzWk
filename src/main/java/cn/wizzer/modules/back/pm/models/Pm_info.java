package cn.wizzer.modules.back.pm.models;

import cn.wizzer.common.base.Model;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wizzer on 2016/6/21.
 */
@Table("pm_info")
public class Pm_info extends Model implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("昵称")
    @ColDefine(type = ColType.VARCHAR, width = 100)
    private String nickname;

    @Column
    @Comment("联系方式")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String contact;

    @Column
    @Comment("项目简介")
    @ColDefine(type = ColType.VARCHAR, width = 500)
    private String note;

    @Column
    @Comment("捐赠金额")
    @ColDefine(type = ColType.INT, width = 5)
    private Integer money;

    @Column
    @Comment("捐赠时间")
    @ColDefine(type = ColType.VARCHAR, width = 20)
    private String payat;

    @Column
    @Comment("隐藏")
    @ColDefine(type = ColType.BOOLEAN)
    private boolean disabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPayat() {
        return payat;
    }

    public void setPayat(String payat) {
        this.payat = payat;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
