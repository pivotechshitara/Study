package com.example.demo.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * タスク情報 入力フォームクラス
 * 
 * 画面から受け取る入力値を管理するクラス
 * バリデーション（入力チェック）もここで行う
 */
public class TaskForm {

    /** タスクID */
    private Integer taskId;

    /** タスク名 */
    @NotBlank(message = "タスク名は必須です")
    @Size(max = 20, message = "20文字以内で入力してください")
    private String taskName;

    /** タスク状況 */
    @NotBlank(message = "タスク状況は必須です")
    @Size(max = 20, message = "20文字以内で入力してください")
    private String taskStatus;

    /** 開始日 */
    private LocalDate startDate;

    /** 終了日 */
    private LocalDate endDate;

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