package hu.elte.CbPlanner.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Comp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false, unique=false)
    private Long Round;
    @Column(nullable=false, unique=false)
    private Long damage;
    @Column(nullable=false, unique=false)
    private Long boss;
    @Column(nullable=true, unique=false)
    private String Notes;

    // Relations
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Unit unit1;
    @ManyToOne
    @JoinColumn
    private Unit unit2;
    @ManyToOne
    @JoinColumn
    private Unit unit3;
    @ManyToOne
    @JoinColumn
    private Unit unit4;
    @ManyToOne
    @JoinColumn
    private Unit unit5;

    // Back-Relations
    @JsonIgnore
    @OneToMany(mappedBy = "comp")
    private List<Plan> plans;

    // TimeStamp
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
