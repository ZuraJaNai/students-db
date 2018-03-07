package no.itera.model;

import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils.*;

@org.hibernate.annotations.GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "JPWH_SEQUENCE"
                ),
                @org.hibernate.annotations.Parameter(
                        name = "initial_value",
                        value = "1000"
                )
        }
)

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private int id;

    @Column(nullable = false,name = "LASTNAME")
    private String lastName;

    @Column(nullable = false,name = "FIRSTNAME")
    private String firstName;

    @Column(nullable = false,name = "PATRONYMIC")
    private String patronymic;

    @Column(name = "EMAIL")
    private String email;

    @Column(nullable = false,name = "YEAR")
    private String yearOfStudy;

    @Column(name = "INTERNSHIP")
    private String internship;

    @Column(name = "PRACTICE")
    private String practice;

    @Column(name = "COMMENT")
    private String comment;
//    @Embedded // Not necessary...
//    @AttributeOverrides({
//            @AttributeOverride(name = "attachments",
//                    column = @Column(name = "ATTACHMENTS"))
//    })
//    private ArrayList<Attachment> attachments;

    public Person(String lastName, String firstName, String patronymic,
                  String email, String yearOfStudy, String internship, String practice,
                  String comment){
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.yearOfStudy = yearOfStudy;
        this.internship = internship;
        this.practice = practice;
        this.comment = comment;
    }

    public Person(int id){
        this.id = id;
        this.lastName = "default";
        this.firstName = "default";
        this.patronymic = "default";
        this.email = "default@mail.com";
        this.yearOfStudy = "0";
        this.internship = "default";
        this.practice = "default";
        this.comment = null;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getInternship() {
        return internship;
    }

    public void setInternship(String internship) {
        this.internship = internship;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("ID: %d\n", id));
        if(StringUtils.isNoneEmpty(lastName)){
            info.append(String.format("Last name: %s\n",lastName));
        }
        if(StringUtils.isNoneEmpty(firstName)){
            info.append(String.format("First name: %s\n",firstName));
        }
        if(StringUtils.isNoneEmpty(patronymic)){
            info.append(String.format("Patronymic: %s\n",patronymic));
        }
        if(StringUtils.isNoneEmpty(email)){
            info.append(String.format("Email: %s\n",email));
        }
        if(StringUtils.isNoneEmpty(yearOfStudy)){
            info.append(String.format("Year of study: %s\n",yearOfStudy));
        }
        if(StringUtils.isNoneEmpty(internship)){
            info.append(String.format("Internship: %s\n",internship));
        }
        if(StringUtils.isNoneEmpty(practice)){
            info.append(String.format("Practice: %s\n",practice));
        }
        return info.toString();
    }

}
