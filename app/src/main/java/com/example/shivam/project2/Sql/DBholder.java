package com.example.shivam.project2.Sql;

import java.io.Serializable;
import java.io.StringReader;
import java.util.List;

public class DBholder implements Serializable {
  String id;
  String projectname;
  String reference;
  String amountpro;
  String amountfianl;
  String quatation;
  String name;
  String perc;


    public DBholder() {
        this.id = id;
       this.projectname = projectname;
        this.reference = reference;
        this.amountpro = amountpro;
        this.amountfianl = amountfianl;
        this.quatation = quatation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerc() {
        return perc;
    }

    public void setPerc(String perc) {
        this.perc = perc;
    }

    public String getProjectName() {
        return projectname;
    }

    public void setProjectName(String projectName) {
        projectname = projectName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getAmountProposed() {
        return amountpro;
    }

    public void setAmountProposed(String amountProposed) {
        this.amountpro = amountProposed;
    }

    public String getAmountFianl() {
        return amountfianl;
    }

    public void setAmountFianl(String amountFianl) {
        this.amountfianl = amountFianl;
    }

    public String getQuatation() {
        return quatation;
    }

    public void setQuatation(String quatation) {
        this.quatation = quatation;
    }

}
