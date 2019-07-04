package com.alerter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alerter.entity.Alerts;
import com.alerter.repository.AlertsRepository;

@RestController
@RequestMapping(path = "/alerts")
public class AlertsController {

	@Autowired
	private AlertsRepository repository;

	@GetMapping
	public Iterable<Alerts> getAllAlerts() {
		List<Alerts> alerts = repository.findAll();
		repository.truncateAlertsTable();
		return alerts;
	}

	@PostMapping
	public Iterable<Alerts> getAllAlertsByRank(@RequestBody List<Integer> input) {
		List<Alerts> alerts = null;
		boolean flag = false;

		// Combination ( , ,3)
		if (!input.contains(1) & !input.contains(2) & input.contains(3)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList3 = repository.getRank3();
			mlist.add(dbList3);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		// Combination ( ,2,3)
		else if (!input.contains(1) & input.contains(2) & input.contains(3)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList2 = repository.getRank2();
			List<Alerts> dbList3 = repository.getRank3();
			mlist.add(dbList2);
			mlist.add(dbList3);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		// Combination ( ,2, )
		else if (!input.contains(1) & input.contains(2) & !input.contains(1)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList2 = repository.getRank2();
			mlist.add(dbList2);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		// Combination (1,2,3)
		else if (input.contains(1) & input.contains(2) & input.contains(3)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList1 = repository.getRank1();
			List<Alerts> dbList2 = repository.getRank2();
			List<Alerts> dbList3 = repository.getRank3();
			mlist.add(dbList1);
			mlist.add(dbList2);
			mlist.add(dbList3);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		// Combination (1, ,3)
		else if (input.contains(1) & !input.contains(2) & input.contains(3)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList1 = repository.getRank1();
			List<Alerts> dbList3 = repository.getRank3();
			mlist.add(dbList1);
			mlist.add(dbList3);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		// Combination (1,2, )
		else if (input.contains(1) & input.contains(2) & !input.contains(3)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList1 = repository.getRank1();
			List<Alerts> dbList2 = repository.getRank2();
			mlist.add(dbList1);
			mlist.add(dbList2);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		// Combination (1, , )
		else if (input.contains(1) & !input.contains(2) & !input.contains(3)) {
			alerts = new ArrayList<>();
			List<List<Alerts>> mlist = new ArrayList<>();
			List<Alerts> dbList1 = repository.getRank1();
			mlist.add(dbList1);
			for (List<Alerts> list : mlist) {
				for (Alerts l : list) {
					alerts.add(l);
				}
			}
			flag = true;
		}

		else {
			flag = false;
		}

		if (flag == true) {
			repository.truncateAlertsTable();
		} else {
			// No Action Required
		}

		return alerts;
	}

}
