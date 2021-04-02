package hu.elte.CbPlanner.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  //Values
  @Column(length=50, nullable=false, unique=true)
  private String Name;
  
  @Column(length=50, nullable=false, unique=false)
  private String Password;
  
  @Column(length=9, nullable=false, unique=true)
  private String UID;

  // TimeStamp
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;

  @Column
  @UpdateTimestamp
  private LocalDateTime updated_at;
}