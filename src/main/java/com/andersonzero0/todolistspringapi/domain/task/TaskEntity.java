package com.andersonzero0.todolistspringapi.domain.task;

import com.andersonzero0.todolistspringapi.domain.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table(name = "task_tb")
@Entity(name = "task_tb")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false)
    private String title;

    @Column()
    private String description;

    @Column(nullable = false)
    private Boolean done;

    @Column(nullable = false)
    private Boolean is_deleted;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    public TaskEntity(TaskInputDTO taskInputDTO) {
        //this.id = taskInputDTO.id();
        this.title = taskInputDTO.title();
        this.description = taskInputDTO.description();
        this.done = taskInputDTO.done();
        this.createdAt = taskInputDTO.createdAt();
        this.updatedAt = taskInputDTO.updatedAt();
    }
}
