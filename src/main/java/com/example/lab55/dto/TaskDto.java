package com.example.lab55.dto;

import com.example.lab55.entity.User;
import lombok.*;

import java.time.LocalDateTime;
enum Status{
    NEW,
    WORKING,
    COMPLETE
}
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto  {
    private Long id;
    private String header;
    private String description;
    private User owner;
    private LocalDateTime deadline;

}
