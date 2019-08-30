package com.Hooks;

import com.BaseUtils.BaseUtil;

import cucumber.api.java.Before;

public class Hooks extends BaseUtil {
	
	@Before
	public void SetUp() {
	 accesskey=getAcccessKey();
	
	}
	
	

}
