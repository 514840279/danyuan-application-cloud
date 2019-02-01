package org.danyuan.application.user;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 文件名 ： UserFein.java
 * 包 名 ： org.shumeng.sso.user
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： Administrator
 * 时 间 ： 2018年12月7日 下午3:52:17
 * 版 本 ： V1.0
 */

@FeignClient("danyuan-application-rbac-server")
public interface SysUserLoginFein {

	@RequestMapping(method = RequestMethod.GET, value = "/sysUserBase/findByName")
	SysUserBaseInfo findByName(String username);

	@RequestMapping(method = RequestMethod.GET, value = "/sysUserBase/getRoleByUser")
	List<SysRolesInfo>  getRoleByUser(SysUserBaseInfo entity);

	
}
