package com.alerter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alerter.entity.Alerts;

@Repository
@Transactional
public interface AlertsRepository extends JpaRepository<Alerts, Integer> {

	@Modifying
	@Query(value = "truncate table alerts", nativeQuery = true)
	void truncateAlertsTable();

	@Query(value = "select * from alerts where rank = 1", nativeQuery = true)
	public List<Alerts> getRank1();

	@Query(value = "select * from alerts where rank = 2", nativeQuery = true)
	public List<Alerts> getRank2();

	@Query(value = "select * from alerts where rank = 3", nativeQuery = true)
	public List<Alerts> getRank3();

}
