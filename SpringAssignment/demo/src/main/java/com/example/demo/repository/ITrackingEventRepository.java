package com.example.demo.repository;

import com.example.demo.entity.TrackingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrackingEventRepository extends JpaRepository<TrackingEvent, Long> {
}
