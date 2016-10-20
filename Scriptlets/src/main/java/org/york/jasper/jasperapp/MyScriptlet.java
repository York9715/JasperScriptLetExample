package org.york.jasper.jasperapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

public class MyScriptlet extends JRDefaultScriptlet {
	// List<Map<String, ?>> dataList = new ArrayList<Map<String, ?>>();

	public void getDataList() {
		List<Map<String, ?>> maps = new ArrayList<Map<String, ?>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("city", "Beijing99");
		map.put("street", "11 Wulidian00");
		maps.add(map);

		map = new HashMap<String, Object>();
		map.put("city", "Beijing299");
		map.put("street", "22 Wulidian200");
		maps.add(map);

		try {
			this.setVariableValue("dataList", maps);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateVariables() throws JRScriptletException {
		System.out.println("call afterReportInit()");

		String york = (String) this.getParameterValue("york");
		String chen = (String) this.getParameterValue("chen");

		System.out.println("updateVariables, v york=" + york);
		System.out.println("updateVariables, v chen=" + chen);
		this.setVariableValue("york", new String("updateVariables, V york="
				+ york));
		this.setVariableValue("chen", new String("updateVariables, V chen="
				+ chen));

		getDataList();
	}

	public String hello() throws JRScriptletException {
		return "Hello! I'm the report's scriptlet object.";
	}

	public void beforeReportInit() throws JRScriptletException {
		System.out.println("call beforeReportInit()");
	}

	public void afterReportInit() throws JRScriptletException {
		System.out.println("call afterReportInit()");
	}

	public void beforePageInit() throws JRScriptletException {
		System.out.println("call beforePageInit()");
	}

	public void afterPageInit() throws JRScriptletException {
		System.out.println("call afterPageInit()");
	}

	public void beforeColumnInit() throws JRScriptletException {
		System.out.println("call beforeColumnInit()");
	}

	public void afterColumnInit() throws JRScriptletException {
		System.out.println("call afterColumnInit()");
	}

	public void beforeDetailEval() throws JRScriptletException {
		System.out.println("call beforeDetailEval()");
	}

	public void afterDetailEval() throws JRScriptletException {
		System.out.println("call afterDetailEval()");
		updateVariables();
	}

}