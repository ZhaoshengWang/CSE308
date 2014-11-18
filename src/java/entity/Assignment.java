/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Peter, Edited by Guoliang Zhong
 */
@Entity
@Table(name = "ASSIGNMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignment.findAll", query = "SELECT a FROM Assignment a"),
    @NamedQuery(name = "Assignment.findById", query = "SELECT a FROM Assignment a WHERE a.id = :id"),
    @NamedQuery(name = "Assignment.findByName", query = "SELECT a FROM Assignment a WHERE a.name = :name"),
    @NamedQuery(name = "Assignment.findByDueDate", query = "SELECT a FROM Assignment a WHERE a.dueDate = :dueDate"),
    @NamedQuery(name = "Assignment.findByPoints", query = "SELECT a FROM Assignment a WHERE a.points = :points")})
public class Assignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "POINTS")
    private Integer points;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignment")
    private Collection<Submissions> submissionsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "assignmentId")
    private Course course;
    
    //Edited by Guoliang Zhong
    private String instruction;

    public Assignment() {
    }

    public Assignment(Integer id) {
        this.id = id;
    }

    public Assignment(Integer id, String name, String description, Date dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @XmlTransient
    public Collection<Submissions> getSubmissionsCollection() {
        return submissionsCollection;
    }

    public void setSubmissionsCollection(Collection<Submissions> submissionsCollection) {
        this.submissionsCollection = submissionsCollection;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignment)) {
            return false;
        }
        Assignment other = (Assignment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Assignment[ id=" + id + " ]";
    }
    
}
