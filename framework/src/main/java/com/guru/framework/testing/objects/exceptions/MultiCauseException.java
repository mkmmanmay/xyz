package com.guru.framework.testing.objects.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MultiCauseException extends Exception implements Iterable<Throwable>{

	private static final long serialVersionUID = -6283218913572764492L;
	
	private LinkedList<Throwable> causes = new LinkedList<Throwable>();
	
	private String multiMessage;
	
	public List<Throwable> getCauses() {
		return causes;
	}

    public MultiCauseException() {
    	super();
    }

    public MultiCauseException(final String msg) {
    	super ();
    	multiMessage = msg;
    }

    public MultiCauseException(final Throwable cause)  {
    	super();
    	causes.add (cause);
    }

    public MultiCauseException(final String msg, final Throwable cause)  {
    	super ();
    	causes.add (cause);
    	multiMessage = msg;
    }
	
    public int size()  {
    	return causes.size();
    }
    
    public boolean isEmpty() {
    	return this.size() == 0;
    }

    public Throwable get(final int i)  {
    	return causes.get (i);
    }
	
    public void add(final Throwable cause) {
    	if(null != cause)
    		{causes.add (cause);}
    }

    public Iterator<Throwable> iterator()  {
    	return causes.iterator();
    }
    
    public void printStackTrace() {
    	printStackTrace (System.err);
    }
    
    public void printStackTrace(final PrintStream out)  {
        super.printStackTrace (out);
        int i = 1;
        for (Throwable cause : causes) {
            out.printf ("MultiCauseException caused by [%d]: ", i++);
            cause.printStackTrace (out);
        }
    }
    
    public void printStackTrace(final PrintWriter out) {
    	super.printStackTrace (out);
        int i = 1;
        for (Throwable cause : causes) {
            out.printf ("MultiCauseException caused by [%d]: ", i ++);
            cause.printStackTrace (out);
        }
    }

    public synchronized Throwable getCause() {
    	return this.size() > 0 ? this.get(0).getCause() : null;
    }
    
    public String getMessage() {
    	final StringBuilder message = new StringBuilder(multiMessage == null ? "Exception(s):" + "\n": multiMessage + "\n");
    	int i = 0; 
    	for(Throwable each : causes)  
    		{message.append(++i).append(": ").append(each.getMessage()).append("\n");}
    	if(message.length() > 0)
    		{message.deleteCharAt(message.length()-1);}
    	return message.toString();
    }
    
    public String toString() {
    	final String s = getClass().getName();
    	final String message = getLocalizedMessage();
         return (message != null) ? (s + ": " + message) : s;
    }
    
    
    
    
    public void assertNotEmpty() throws MultiCauseException {
    	if(this.size() == 0)
    		{throw this;}
    }
    
    public void assertEmpty() throws MultiCauseException {
    	if(this.size() > 0)
    		{throw this;}
    }
}
