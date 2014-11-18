/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Peter
 */
@Embeddable
public class SubmissionsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASSIGNMENT_ID")
    private int assignmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "STUDENT_ID")
    private String studentId;

    public SubmissionsPK() {
    }

    public SubmissionsPK(int assignmentId, String studentId) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) assignmentId;
        hash += (studentId != null ? studentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubmissionsPK)) {
            return false;
        }
        SubmissionsPK other = (SubmissionsPK) object;
        if (this.assignmentId != other.assignmentId) {
            return false;
        }
        if ((this.studentId == null && other.studentId != null) || (this.studentId != null && !this.studentId.equals(other.studentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SubmissionsPK[ assignmentId=" + assignmentId + ", studentId=" + studentId + " ]";
    }
    
}
