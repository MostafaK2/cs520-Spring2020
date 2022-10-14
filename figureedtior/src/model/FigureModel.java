package model;

import javax.swing.ImageIcon;


public class FigureModel 
{
    private ImageIcon imageIcon; 
    private String caption; 

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
        if(newImage == null){
            throw new IllegalArgumentException("no null value allowed");
        }
        this.imageIcon = newImage; 
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
        if(newCaption == null){
            throw new IllegalArgumentException("no null value allowed");
        }
        this.caption = newCaption; 
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
