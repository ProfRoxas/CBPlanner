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
import javax.persistence.ManyToMany;
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
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=9, nullable=false, unique=true)
    private String name;

    // Back-Relations
    @JsonIgnore
    @ManyToMany(mappedBy = "units")
    private List<User> user;
    
    @JsonIgnore
    @OneToMany(mappedBy = "unit1")
    private List<Comp> comp1;
    @JsonIgnore
    @OneToMany(mappedBy = "unit2")
    private List<Comp> comp2;
    @JsonIgnore
    @OneToMany(mappedBy = "unit3")
    private List<Comp> comp3;
    @JsonIgnore
    @OneToMany(mappedBy = "unit4")
    private List<Comp> comp4;
    @JsonIgnore
    @OneToMany(mappedBy = "unit5")
    private List<Comp> comp5;

    // TimeStamp
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;

    @Column
    @UpdateTimestamp
    private LocalDateTime updated_at;
}
