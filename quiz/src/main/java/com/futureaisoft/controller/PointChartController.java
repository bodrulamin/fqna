package com.futureaisoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.futureaisoft.model.PointChart;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

public class PointChartController {

	Logger log = LoggerFactory.getLogger(PointChartController.class);

	@Autowired
	private MyService service;

	private final ApiResponse res = MyConstant.apiRes;

	@GetMapping(value = "")
	public ResponseEntity<ApiResponse> getPointCharts(@RequestParam(defaultValue = "1") int page) {
		log.info("Starting getPointCharts: getPointCharts(@RequestParam long page)");
		try {
			List<PointChart> pointChart = service.getPointChart(page - 1);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("PointChart loaded successfully ");
			res.setData(pointChart);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("PointChart loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<ApiResponse> save(@RequestBody PointChart entity) {

		log.info("Starting save: save(@RequestBody PointChart entity)");
		try {
			PointChart pointChart = service.savePointChart(entity);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("PointChart saved successfully");
			res.setData(pointChart);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("PointChart added failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable(value = "id") Long id) {
		log.info("Starting PointChartDelete: delete(@PathVariable(value = \"id\") Long id)");

		PointChart pointChart = service.getPointChart(id);
		try {
			service.deletePointChart(pointChart);
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("PointChart deleted successfully");
			res.setData(pointChart);
			return ResponseEntity.ok(res);
		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("PointChart deletation failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}
}
