package org.danyuan.application.application.crawler.config.service;

import java.util.List;

import org.danyuan.application.application.crawler.config.po.SysSeedResultRulerInfo;
import org.danyuan.application.application.crawler.config.vo.SysSeedResultRulerVo;

public interface SysSeedResultRulerService {

	List<SysSeedResultRulerInfo> findAllBySysSeedResultRulerInfo(SysSeedResultRulerInfo info);
	
	List<SysSeedResultRulerInfo> saveSysSeedResultRulerInfo(SysSeedResultRulerVo vo);
	
}
