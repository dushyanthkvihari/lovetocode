package com.vihari.learn;

import java.io.*;
import java.util.*;

class QueryLogFiles
{
    private File parentFolder;
    private Map<String, String> logLocationMap;
    private Set extensions;

    public void setParentFolder(File folder)
    {
        parentFolder = folder;
    }
    public File getParentFolder()
    {
        return this.parentFolder;
    }
    public void setLogLocationMap(Map logMap)
    {
        this.logLocationMap = logMap;
    }
    public Map<String,String> getlogLocationMap()
    {
        return this.logLocationMap;
    }
    public void setExtensions(Set extensions)
    {
        this.extensions = extensions;
    }
    public Set getExtensions()
    {
        return this.extensions;
    }
    public QueryLogFiles()
    {
        this.parentFolder = null;
        this.logLocationMap = new HashMap<>();
        this.extensions = new HashSet();
    }
    public void scanFolderForLogs(String  path)
    {
        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                scanFolderForLogs( f.getAbsolutePath() );
                //System.out.println( "Dir:" + f.getAbsoluteFile() );
            }
            else {
               if(extensions.contains(f.getName().substring(f.getName().lastIndexOf(".")+1)))
                {
                    if(logLocationMap.get(f.getParent())!=null) {
                        logLocationMap.put(f.getParent(), logLocationMap.get(f.getParent())+"\n" +f.getName());
                    }
                    else
                    {
                        logLocationMap.put(f.getParent(), f.getName());
                    }
                }
            }
        }
    }
    public static void main(String vv[])
    {
        String parentFolderString = new String("C:\\test");
        File parentFolder = new File(parentFolderString);
        if( !parentFolder.exists() )
        {
            System.out.println("Invalid root folder specified");
            System.exit(0);
        }

        QueryLogFiles query = new QueryLogFiles();
        query.setParentFolder(parentFolder);
        Set ext = new HashSet();
        ext.add("log");
        ext.add("mf");
        query.setExtensions(ext);
        query.scanFolderForLogs(parentFolderString);
        for(Map.Entry entry : query.getlogLocationMap().entrySet())
        {
            System.out.println("Log Name "+entry.getKey() + " Log Location " + entry.getValue());
            System.out.println("****************************************************************");

        }
        TreeMap tmap = new TreeMap();
        tmap.putAll(query.getlogLocationMap());
    }
}
