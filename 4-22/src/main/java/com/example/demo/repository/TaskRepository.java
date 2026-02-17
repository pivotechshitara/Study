package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TaskEntity;

/**
 * タスク情報 Repositoryインターフェース
 * 
 * データベース操作（CRUD）を行うクラス
 * Spring Data JPAが自動で実装してくれる
 */
@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

}