package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;

import javax.swing.ImageIcon;

// observable

public class FigureModel 
{
    private ImageIcon imageIcon; 
    private String caption; 

    PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    protected Set<PropertyChangeListener> observers = new HashSet<PropertyChangeListener>();

    // register the observer with the observable
    public void register(PropertyChangeListener pcl, String propertyName){
        observers.add(pcl);
        propertyChangeSupport.addPropertyChangeListener(propertyName, pcl);
    }

    // removes the observer from the observable
    public void unRegister(PropertyChangeListener pcl, String propertyName){
        observers.remove(pcl);
        propertyChangeSupport.removePropertyChangeListener(propertyName, pcl);
    }
    

    // gets the image icon from private variable 
    public ImageIcon getImage() {
	    return this.imageIcon;
    }

    /**
     * Sets the image to the given non-null ImageIcon.
     *
     * @param newImage The ImageIcon must be non-null
     *
     * @throws IllegalArgumentException if the ImageIcon is null
     */
    public void setImage(ImageIcon newImage) {
        ImageIcon oldValue = this.imageIcon; 
        if(newImage == null){
            throw new IllegalArgumentException("no null value allowed");
        }
        this.imageIcon = newImage;
        
        // tells observers theres a change and fires it only if oldval is changed
        propertyChangeSupport.firePropertyChange("image", oldValue, this.imageIcon);
    }

    public String getCaption() {
	    return this.caption;
    }

    /**
     * Sets the caption to the given non-null and non-empty String.
     *
     * @param newCaption The String must be non-null and non-empty
     *
     * @throws IllegalArgumentException if the String is null or empty
     */
    public void setCaption(String newCaption) {
        String oldValue = this.caption;

        if(newCaption == null){
            throw new IllegalArgumentException("no null value allowed");
        }
        this.caption = newCaption; 

        // tells observers theres a change. 
        propertyChangeSupport.firePropertyChange("caption", oldValue, this.imageIcon);
    }

    /**
     * Returns true if this figure is complete, meaning its Image 
     * is non-null and its caption is non-null and non-empty, and
     * false otherwise.
     *
     * @return True if this figure is complete and false otherwise
     */
    public boolean isComplete() {
        if(caption != null && imageIcon != null){
            if(caption.length() != 0){
                return true; 
            }
        }
        return false;
    }
}
