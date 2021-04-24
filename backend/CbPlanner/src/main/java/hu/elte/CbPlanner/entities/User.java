package hu.elte.CbPlanner.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
  private Long id;

  //Values
  //TODO: Getters/Data refuse to work
  @Column(length=50, nullable=false, unique=true)
  private String username;
  public String getUsername() {return new String(username);};

  @JsonIgnore
  @Column(length=50, nullable=false, unique=false)
  private String password;
  public String getPassword() {return new String(password);};

  @Column(length=9, nullable=false, unique=true)
  private String uid;

  @Column(length=9, nullable=false, unique=true)
  private String role;
  public String getRole() {return new String(role);};

  // Back-Relations
  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Comp> comps;

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Plan> plans;

  @ManyToMany
  @JoinTable
  private List<Unit> units;

  // TimeStamp
  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created_at;

  @Column
  @UpdateTimestamp
  private LocalDateTime updated_at;
}