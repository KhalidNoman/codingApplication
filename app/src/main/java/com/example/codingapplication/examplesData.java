package com.example.codingapplication;

public class examplesData {
    private String op;
    private String outer;
    private String variableName;
    private Object variable;
    private String end;

    public examplesData(String op, String outer, String variableName, Object variable, String end) {
        this.op = op;
        this.outer = outer;
        this.variableName = variableName;
        this.variable = variable;
        this.end = end;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getOuter() {
        return outer;
    }

    public void setOuter(String outer) {
        this.outer = outer;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public Object getVariable() {
        return variable;
    }

    public void setVariable(Object variable) {
        this.variable = variable;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}
