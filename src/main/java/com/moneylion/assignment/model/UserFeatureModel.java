package com.moneylion.assignment.model;

public class UserFeatureModel {

    private String email;
    private String featureName;
    private boolean enable;

    public UserFeatureModel() {
    }

    public UserFeatureModel(String email, String featureName, boolean enable) {
        this.email = email;
        this.featureName = featureName;
        this.enable = enable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public boolean isEnabled() {
        return enable;
    }

    public void setEnabled(boolean enable) {
        this.enable = enable;
    }
}
