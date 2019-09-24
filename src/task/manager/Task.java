/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task.manager;

import java.beans.PropertyChangeSupport;

/**
 *
 * @author George
 */
class Task {
    enum Prio {
        HIGH, MEDIUM, LOW
    }
    
    private Prio priority;
    private String title;
    private String desc;
    
    public Task(Prio prio_, String title_, String desc_) {
        priority = prio_;
        title = title_;
        desc = desc_;
    }
    
    public String toString() {
        String out = "";
        
        switch(getPriority()) {
            case HIGH: out += "High | "; break;
            case MEDIUM: out += "Medium | "; break;
            case LOW: out += "Low | "; break;
        }
        
        out += getTitle();
        out += getDesc();
        
        return out;
    }

    /**
     * @return the priority
     */
    public Prio getPriority() {
        return priority;
    }
    
    public String getPriorityStr() {return priority.toString();}

    /**
     * @param priority the priority to set
     */
    public void setPriority(Prio priority) {
        task.manager.Task.Prio oldPriority = this.priority;
        this.priority = priority;
        propertyChangeSupport.firePropertyChange(PROP_PRIORITY, oldPriority, priority);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        java.lang.String oldTitle = this.title;
        this.title = title;
        propertyChangeSupport.firePropertyChange(PROP_TITLE, oldTitle, title);
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        java.lang.String oldDesc = this.desc;
        this.desc = desc;
        propertyChangeSupport.firePropertyChange(PROP_DESC, oldDesc, desc);
    }
    
    public String toCSV() {return "" + priority.toString() + "," + title;}
    
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    public static final String PROP_PRIORITY = "priority";
    public static final String PROP_TITLE = "title";
    public static final String PROP_DESC = "desc";
    
    
    
    
}
