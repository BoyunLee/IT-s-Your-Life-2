package com.multi.jdbc;

public class ActionVO {
    private int action_id;
    private String action_name;
    private String action_description;
    private String action_date;

    public ActionVO() {
    }
    public ActionVO(String action_name, String action_description) {
        this.action_name = action_name;
        this.action_description = action_description;
    }

    public int getAction_id() {
        return action_id;
    }

    public void setAction_id(int action_id) {
        this.action_id = action_id;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public String getAction_description() {
        return action_description;
    }

    public void setAction_description(String action_description) {
        this.action_description = action_description;
    }

    public String getAction_date() {
        return action_date;
    }

    public void setAction_date(String action_date) {
        this.action_date = action_date;
    }

    @Override
    public String toString() {
        return "ActionVO{" +
                "action_id=" + action_id +
                ", action_name='" + action_name + '\'' +
                ", action_description='" + action_description + '\'' +
                ", action_date='" + action_date + '\'' +
                '}';
    }
}
