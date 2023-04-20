package org.myorg.persistence;

public class MessageServiceException extends Exception{
    public static final String NO_CONTROLLED = "Uncontrolled error";
    public MessageServiceException(String message) {
        super(message);
    }
}
