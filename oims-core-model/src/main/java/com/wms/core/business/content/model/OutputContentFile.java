package com.wms.core.business.content.model;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import com.wms.core.business.content.model.StaticContentFile;

/**
 * Data class responsible for carrying out static content data from Infispan cache to 
 * service layer.
 * 
 * @author Umesh Awasthi
 * @since 1.2
 */
public class OutputContentFile extends StaticContentFile implements Serializable
{
    private static final long serialVersionUID = 1L;
    private ByteArrayOutputStream file;
    public ByteArrayOutputStream getFile()
    {
        return file;
    }
    public void setFile( ByteArrayOutputStream file )
    {
        this.file = file;
    }
    
}