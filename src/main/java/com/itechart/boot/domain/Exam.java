package com.itechart.boot.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Exam {
    private Integer id;
    private TrainingCourse trainingCourse;
    private Teacher teacherReplacement;
    private Timestamp date;
    private List<ExamStudentResult> examStudentResults;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_course_id", referencedColumnName = "id", nullable = false)
    public TrainingCourse getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourse trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", nullable = false)
    public Teacher getTeacherReplacement() {
        return teacherReplacement;
    }

    public void setTeacherReplacement(Teacher teacherReplacement) {
        this.teacherReplacement = teacherReplacement;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
    public List<ExamStudentResult> getExamStudentResults() {
        return examStudentResults;
    }

    public void setExamStudentResults(List<ExamStudentResult> examStudentResults) {
        this.examStudentResults = examStudentResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exam exam = (Exam) o;

        if (id != null ? !id.equals(exam.id) : exam.id != null) return false;
        if (trainingCourse != null ? !trainingCourse.equals(exam.trainingCourse) : exam.trainingCourse != null)
            return false;
        if (teacherReplacement != null ? !teacherReplacement.equals(exam.teacherReplacement) : exam.teacherReplacement != null)
            return false;
        if (date != null ? !date.equals(exam.date) : exam.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (trainingCourse != null ? trainingCourse.hashCode() : 0);
        result = 31 * result + (teacherReplacement != null ? teacherReplacement.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
