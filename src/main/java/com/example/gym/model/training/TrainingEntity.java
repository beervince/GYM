package com.example.gym.model.training;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name="training")
public class TrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trainingName;
    @Enumerated(EnumType.STRING)
    private TrainingType trainingType;
    private Long price;
    private String trainerName;
}
