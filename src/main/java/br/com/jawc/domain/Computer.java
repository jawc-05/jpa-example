/**
 * @author jawc
 */
package br.com.jawc.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "computer_seq")
    @SequenceGenerator(name="computer_sq", sequenceName = "sq_computer", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "code", length = 10, nullable = false,  unique = true)
    private String code;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @ManyToMany(mappedBy = "computers")
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
