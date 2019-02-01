package org.danyuan.application.oauth2;

import java.util.ArrayList;
import java.util.List;

import org.danyuan.application.user.SysRolesInfo;
import org.danyuan.application.user.SysUserBaseInfo;
import org.danyuan.application.user.SysUserLoginFein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 * 文件名 ： CustomUserDetailsService.java
 * 包 名 ： tk.ainiyue.danyuan.application.common.config
 * 描 述 ： TODO(用一句话描述该文件做什么)
 * 机能名称：
 * 技能ID ：
 * 作 者 ： wang
 * 时 间 ： 2017年10月8日 上午9:10:01
 * 版 本 ： V1.0
 */
@Repository
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	SysUserLoginFein	sysUserLoginFein;
	
	@Autowired
	PasswordEncoder				passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.err.println("CustomUserDetailsService.loadUserByUsername");
		System.err.println(passwordEncoder.encode("test"));
		SysUserBaseInfo user = new SysUserBaseInfo();
		try {
			user.setUserName(userName);
			user =sysUserLoginFein.findByName(userName);
			
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
			
		}
		if (user == null) {
			throw new UsernameNotFoundException("no user found");
		} else {
			System.err.println(user.getPassword());
			try {
				List<SysRolesInfo> menu = sysUserLoginFein.getRoleByUser(user);
				List<GrantedAuthority> gas = new ArrayList<>();
				if (menu != null) {
					for (SysRolesInfo sysRolesInfo : menu) {
						gas.add(new SimpleGrantedAuthority(sysRolesInfo.getRoleName()));
					}
				}
				
				//				gas.add(new SwitchUserGrantedAuthority("ROLE_USER", new Authentication()));
				UserDetails users = new User(user.getUserName(), user.getPassword(), true, true, true, true, gas);
				return users;
			} catch (Exception e) {
				throw new UsernameNotFoundException("user role select fail");
			}
		}
	}
	
}
