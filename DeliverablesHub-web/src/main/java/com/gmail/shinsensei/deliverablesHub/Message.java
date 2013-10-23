package com.gmail.shinsensei.deliverablesHub;
/**
 * This Bean is used to pass messages to the presentation layer.
 * Each message is characterized by a text and a style associated to it.
 * @author Francesco Bux
 */
public class Message {
    
    private String text;

    public Message(String text, String status, Boolean closable) {
        this.text = text;
        this.status = status;
        this.closable = closable;
    }

    /**
     * Get the value of text
     *
     * @return the value of text
     */
    public String getText() {
        return text;
    }

    /**
     * Set the value of text
     *
     * @param textg new value of text
     */
    public void setText(String text) {
        this.text = text;
    }
    private String status;

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    
    private Boolean closable;

    /**
     * Get the value of closable
     *
     * @return the value of closable
     */
    public Boolean getClosable() {
        return closable;
    }

    /**
     * Set the value of closable
     *
     * @param closable new value of closable
     */
    public void setClosable(Boolean closable) {
        this.closable = closable;
    }

}
