package org.danyuan.application.feign;

import java.util.List;

import org.danyuan.application.AuthorityzTreeVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="DANYUAN-APPLICATION-CRAWLER-SERVER")
public interface CrawlerFeign {
	
	  
//	  @RequestMapping( value = "/sysMenuInfo/findzTreeByUser",method = RequestMethod.POST)
	  public List<AuthorityzTreeVO> findzTreeByUser(@RequestBody String username);//复合类型好像默认是POST请求
}
