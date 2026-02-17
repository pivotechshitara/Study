package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * タスク情報 Entityクラス
 * 
 * データベースのtaskテーブルと紐づくクラス
 * DBのデータを管理するためのクラス
 */
@Entity
@Table(name = "task")
public class TaskEntity {

    /** タスクID（主キー・自動採番） */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    /** タスク名 */
    @Column(name = "task_name", nullable = false, length = 20)
    private String taskName;

    /** タスク状況 */
    @Column(name = "task_status", nullable = false, length = 20)
    private String taskStatus;

    /** 開始日 */
    @Column(name = "start_date")
    private LocalDate startDate;

    /** 終了日 */
    @Column(name = "end_date")
    private LocalDate endDate;

    /** コンストラクタ */
    public TaskEntity() {}

    // getter / setter
    public Integer getTaskId() { return taskId; }
    public void setTaskId(Integer taskId) { this.taskId = taskId; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getTaskStatus() { return taskStatus; }
    public void setTaskStatus(String taskStatus) { this.taskStatus = taskStatus; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}