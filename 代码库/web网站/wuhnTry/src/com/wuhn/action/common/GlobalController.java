package com.wuhn.action.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wuhn.utils.IntegralConstant;

/**
 * @author wuhn
 * @创建时间 2015-12-02
 * @功能 
 * **/
public class GlobalController {
	 private static final Logger logger = LoggerFactory.getLogger(GlobalController.class);
	/** 
     * 异常页面控制 
     *  
     * @param runtimeException 
     * @return 
     */  
    @ExceptionHandler(RuntimeException.class)  
    public String runtimeExceptionHandler(RuntimeException runtimeException,  
            ModelMap modelMap) {  
        logger.error(runtimeException.getLocalizedMessage());  
        modelMap.put("message", runtimeException.getMessage());  
        return "error/errorpage";  
    }  
}
