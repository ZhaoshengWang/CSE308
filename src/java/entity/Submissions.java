/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Peter
 */
@Entity
@Table(name = "SUBMISSIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submissions.findAll", query = "SELECT s FROM Submissions s"),
    @NamedQuery(name = "Submissions.findByAssignmentId", query = "SELECT s FROM Submissions s WHERE s.submissionsPK.assignmentId = :assignmentId"),
    @NamedQuery(name = "Submissions.findByStudentId", query = "SELECT s FROM Submissions s WHERE s.submissionsPK.studentId = :studentId"),
    @NamedQuery(name = "Submissions.findByDateSubmit", query = "SELECT s FROM Submissions s WHERE s.dateSubmit = :dateSubmit"),
    @NamedQuery(name = "Submissions.findByGrade", query = "SELECT s FROM Submissions s WHERE s.grade = :grade"),
    @NamedQuery(name = "Submissions.findByComment", query = "SELECT s FROM Submissions s WHERE s.comment = :comment"),
    @NamedQuery(name = "Submissions.findByResponse", query = "SELECT s FROM Submissions s WHERE s.response = :response"),
    @NamedQuery(name = "Submissions.findByFilename", query = "SELECT s FROM Submissions s WHERE s.filename = :filename")})
public class Submissions implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubmissionsPK submissionsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_SUBMIT")
    @Temporal(TemporalType.DATE)
    private Date dateSubmit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRADE")
    private int grade;
    @Size(max = 100)
    @Column(name = "COMMENT")
    private String comment;
    @Size(max = 100)
    @Column(name = "RESPONSE")
    private String response;
    @Size(max = 100)
    @Column(name = "FILENAME")
    private String filename;
    @JoinColumn(name = "ASSIGNMENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Assignment assignment;
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Submissions() {
    }

    public Submissions(SubmissionsPK submissionsPK) {
        this.submissionsPK = submissionsPK;
    }

    public Submissions(SubmissionsPK submissionsPK, Date dateSubmit, int grade) {
        this.submissionsPK = submissionsPK;
        this.dateSubmit = dateSubmit;
        this.grade = grade;
    }

    public Submissions(int assignmentId, String studentId) {
        this.submissionsPK = new SubmissionsPK(assignmentId, studentId);
    }

    public SubmissionsPK getSubmissionsPK() {
        return submissionsPK;
    }

    public void setSubmissionsPK(SubmissionsPK submissionsPK) {
        this.submissionsPK = submissionsPK;
    }

    public Date getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(Date dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submissionsPK != null ? submissionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submissions)) {
            return false;
        }
        Submissions other = (Submissions) object;
        if ((this.submissionsPK == null && other.submissionsPK != null) || (this.submissionsPK != null && !this.submissionsPK.equals(other.submissionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Submissions[ submissionsPK=" + submissionsPK + " ]";
    }
    
}
