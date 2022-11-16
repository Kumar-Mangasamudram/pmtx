package com.bottomline.pmtx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bottomline.pmtx.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findBytaskId(int taskId);

	List<Task> findAllByUserId(long userId);
}
