package com.vinsup.fms.dto;

import com.vinsup.fms.model.TaskStatus;
import jakarta.validation.constraints.NotNull;

public class TaskStatusUpdateDTO {

    @NotNull(message = "Status is required")
    private TaskStatus status;

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
}
