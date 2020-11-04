package com.ai.snmpvisual.model;

import java.util.ArrayList;
import java.util.List;

public class TreeModel {

    private String label;

    private List<TreeModel> children;

    public TreeModel(String label){
        this.label = label;
        children = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeModel{" +
                "label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
