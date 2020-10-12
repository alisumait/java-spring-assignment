package com.moneylion.assignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "Users_Features")
public class UserFeature {

    private int id;
    private String email;
    private String featureName;
    private boolean enable;

    public UserFeature() {

    }

    public UserFeature(String email, String featureName, boolean enable) {
        this.email = email;
        this.featureName = featureName;
        this.enable = enable;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    @Email(message = "Email must be a valid email address")
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "feature_name", nullable = false)
    public String getFeatureName() {
        return featureName;
    }
    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }


    @Column(name = "can_access", nullable = false)
    public boolean isEnabled() {
        return enable;
    }
    @JsonProperty("enable")
    public void setEnabled(boolean enable) {
        this.enable = enable;
    }
}