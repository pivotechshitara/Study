package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TaskEntity;
import com.example.demo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

/**
 * タスク情報 Serviceクラス
 * 
 * ビジネスロジックを記述するクラス
 * ControllerとRepositoryの橋渡しを行う
 */
@Service
@RequiredArgsConstructor
public class TaskService {

    /** Repository */
    private final TaskRepository repository;

    /**
     * タスク一覧取得
     */
    public List<TaskEntity> findAll() {
        return repository.findAll();
    }

    /**
     * タスク1件取得
     */
    public TaskEntity findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("タスクが存在しません"));
    }

    /**
     * タスク登録・更新
     */
    public void save(TaskEntity entity) {
        repository.save(entity);
    }

    /**
     * タスク削除
     */
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}