package cn.wizzer.modules.back.pm.services;

import cn.wizzer.common.base.Service;
import cn.wizzer.modules.back.pm.models.Pm_info;
import cn.wizzer.modules.back.sys.models.Sys_log;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * Created by wizzer on 2016/6/29.
 */
@IocBean(args = {"refer:dao"})
public class PmInfoService extends Service<Pm_info> {
    public PmInfoService(Dao dao) {
        super(dao);
    }
}
