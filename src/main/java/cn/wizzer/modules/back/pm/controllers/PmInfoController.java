package cn.wizzer.modules.back.pm.controllers;

import cn.wizzer.common.base.Result;
import cn.wizzer.common.filter.PrivateFilter;
import cn.wizzer.common.page.DataTableColumn;
import cn.wizzer.common.page.DataTableOrder;
import cn.wizzer.modules.back.pm.models.Pm_info;
import cn.wizzer.modules.back.pm.services.PmInfoService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by wizzer on 2016/7/3.
 */
@IocBean
@At("/private/pm/info")
@Filters({@By(type = PrivateFilter.class)})
public class PmInfoController {
    private static final Log log = Logs.get();
    @Inject
    PmInfoService pmInfoService;


    @At("")
    @Ok("beetl:/private/pm/info/index.html")
    @RequiresAuthentication
    public void index() {

    }

    @At
    @Ok("beetl:/private/pm/info/add.html")
    @RequiresAuthentication
    public void add() {

    }

    @At
    @Ok("json")
    @RequiresAuthentication
    @RequiresPermissions("pm.info.add")
    public Object addDo(@Param("..") Pm_info info, HttpServletRequest req) {
        try {
            pmInfoService.insert(info);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/edit/?")
    @Ok("beetl:/private/pm/info/edit.html")
    @RequiresAuthentication
    public Object edit(String id) {
        return pmInfoService.fetch(id);
    }

    @At
    @Ok("json")
    @RequiresAuthentication
    @RequiresPermissions("pm.info.edit")
    public Object editDo(@Param("..") Pm_info info, HttpServletRequest req) {
        try {
            pmInfoService.updateIgnoreNull(info);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/delete/?")
    @Ok("json")
    @RequiresAuthentication
    @RequiresPermissions("pm.info.delete")
    public Object delete(String id, HttpServletRequest req) {
        try {
            pmInfoService.delete(id);
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At
    @Ok("json:full")
    @RequiresAuthentication
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
        Cnd cnd = Cnd.NEW();
        return pmInfoService.data(length, start, draw, order, columns, cnd, null);
    }
}
