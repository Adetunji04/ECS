/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecs;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dosunmu5
 */
@Entity
@Table(name = "SUBMISSION")
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findByModuleCode", query = "SELECT s FROM Submission s WHERE s.moduleCode = :moduleCode"),
    @NamedQuery(name = "Submission.findByModuleTitle", query = "SELECT s FROM Submission s WHERE s.moduleTitle = :moduleTitle"),
    @NamedQuery(name = "Submission.findByTutorResponsible", query = "SELECT s FROM Submission s WHERE s.tutorResponsible = :tutorResponsible"),
    @NamedQuery(name = "Submission.findByCourseworkNo", query = "SELECT s FROM Submission s WHERE s.courseworkNo = :courseworkNo"),
    @NamedQuery(name = "Submission.findByCourseworkTitle", query = "SELECT s FROM Submission s WHERE s.courseworkTitle = :courseworkTitle"),
    @NamedQuery(name = "Submission.findByIssueDate", query = "SELECT s FROM Submission s WHERE s.issueDate = :issueDate"),
    @NamedQuery(name = "Submission.findByDueDate", query = "SELECT s FROM Submission s WHERE s.dueDate = :dueDate"),
    @NamedQuery(name = "Submission.findByAssessmentType", query = "SELECT s FROM Submission s WHERE s.assessmentType = :assessmentType"),
    @NamedQuery(name = "Submission.findByPercentageOfmoduleMark", query = "SELECT s FROM Submission s WHERE s.percentageOfmoduleMark = :percentageOfmoduleMark")})
public class Submission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MODULE_CODE")
    private String moduleCode;
    @Basic(optional = false)
    @Column(name = "MODULE_TITLE")
    private String moduleTitle;
    @Basic(optional = false)
    @Column(name = "TUTOR_RESPONSIBLE")
    private String tutorResponsible;
    @Basic(optional = false)
    @Column(name = "COURSEWORK_NO")
    private int courseworkNo;
    @Basic(optional = false)
    @Column(name = "COURSEWORK_TITLE")
    private String courseworkTitle;
    @Basic(optional = false)
    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Basic(optional = false)
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "ASSESSMENT_TYPE")
    private String assessmentType;
    @Basic(optional = false)
    @Column(name = "PERCENTAGE_OFMODULE_MARK")
    private int percentageOfmoduleMark;

    public Submission() {
    }

    public Submission(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Submission(String moduleCode, String moduleTitle, String tutorResponsible, int courseworkNo, String courseworkTitle, Date issueDate, Date dueDate, String assessmentType, int percentageOfmoduleMark) {
        this.moduleCode = moduleCode;
        this.moduleTitle = moduleTitle;
        this.tutorResponsible = tutorResponsible;
        this.courseworkNo = courseworkNo;
        this.courseworkTitle = courseworkTitle;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.assessmentType = assessmentType;
        this.percentageOfmoduleMark = percentageOfmoduleMark;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public void setModuleTitle(String moduleTitle) {
        this.moduleTitle = moduleTitle;
    }

    public String getTutorResponsible() {
        return tutorResponsible;
    }

    public void setTutorResponsible(String tutorResponsible) {
        this.tutorResponsible = tutorResponsible;
    }

    public int getCourseworkNo() {
        return courseworkNo;
    }

    public void setCourseworkNo(int courseworkNo) {
        this.courseworkNo = courseworkNo;
    }

    public String getCourseworkTitle() {
        return courseworkTitle;
    }

    public void setCourseworkTitle(String courseworkTitle) {
        this.courseworkTitle = courseworkTitle;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public int getPercentageOfmoduleMark() {
        return percentageOfmoduleMark;
    }

    public void setPercentageOfmoduleMark(int percentageOfmoduleMark) {
        this.percentageOfmoduleMark = percentageOfmoduleMark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleCode != null ? moduleCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.moduleCode == null && other.moduleCode != null) || (this.moduleCode != null && !this.moduleCode.equals(other.moduleCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ecs.Submission[ moduleCode=" + moduleCode + " ]";
    }

    void setCourseworkNumber(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setDue(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setIssued(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setPercentageOfModuleMark(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
