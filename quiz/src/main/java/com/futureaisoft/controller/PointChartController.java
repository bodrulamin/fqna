package com.futureaisoft.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futureaisoft.model.PointChart;
import com.futureaisoft.service.MyService;
import com.futureaisoft.util.ApiResponse;
import com.futureaisoft.util.MyConstant;

@RestController
@RequestMapping("api/v1/point_chart")
@CrossOrigin(origins = "*")
public class PointChartController {

	Logger log = LoggerFactory.getLogger(PointChartController.class);

	@Autowired
	private MyService service;

	private final ApiResponse res = MyConstant.apiRes;

	@GetMapping(value = "")
	public ResponseEntity<?> getPointCharts() {
		log.info("Starting getPointCharts: getPointCharts()");
		try {
			List<PointChart> pointCharts = service.getPointCharts();
			res.setStatus(MyConstant.SUCCESS);
			res.setMessage("PointChart loaded successfully ");
			res.setData(pointCharts);
			return ResponseEntity.ok(res);

		} catch (Exception e) {
			log.trace(e.getMessage(), e);
			res.setMessage("PointChart loading failed!");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
		}
	}

	@PostMapping(value = "")
	public ResponseEntity<?> save(@RequestBody PointChart entity) {

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
	
	@GetMapping(value = "/{id}")
    public ResponseEntity<?> getPointChart(@PathVariable(value = "id") long id) {
        log.info("Starting getPointChart: getPointChart(@PathVariable(value = \"id\") long id) ");
        try {
        	PointChart pointChart = service.getPointChart(id);
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

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
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
