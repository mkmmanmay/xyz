package com.guru.framework.testing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;

import org.apache.commons.io.filefilter.WildcardFileFilter;
 
public class UnzipJar {
 
	//public static void main(String[] args) throws IOException {
	//	unzipJar("./src/dest", "./src/a.jar");
	//}
 
	public static void unzipJar(String destinationDir, String jarPath, String method, String matchPattern) {
		try
		{
			String fullPath = "";
			
			if (method.equals(""))
			{
				//nothing to do at all since we dont know what its asking us to do 
			}
			
			else if (method.equals("LATESTONLOCAL"))
			{
				//means we are unpacking the files from teh latest version of rainbow that is in the .m2 folder.  
				//we dont care to use the specific version
				//user.home = C:\\Users\\212303073 as an example	base for getting to the jars from the .m2 folder
				//user.dir = C:\\Users\\212303073\\workspace\\demo as an example    base for the test code that is running in order to get to the pom

				File directory = null;
				if (System.getProperty("os.name").toLowerCase().contains("win") == true)
				{		
					directory = new File(System.getProperty("user.home").toString() + "\\.m2\\repository\\com\\ge\\capital\\rainbow\\" + jarPath);
				}
				else
				{
					directory = new File(System.getProperty("user.home").toString() + "/.m2/repository/com/ge/capital/rainbow/" + jarPath);
				}
				File[] list = directory.listFiles();
				
				Arrays.sort(list, new Comparator<File>(){
					public int compare(File f1, File f2){
						return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
					}
				});
				
				for(File file : list)
				{
					if (file.isDirectory()){
						//the first directory in the sorted list is hte one we want to use
						fullPath = file.getPath();
						
						//now that we have the latest path, need to get the name of hte jar in that path to use
						
						File directory2 = new File(fullPath);
						FilenameFilter fileFilter = new WildcardFileFilter(jarPath + "-*-SNAPSHOT.jar");
						File[] list2 = directory2.listFiles(fileFilter);
						for(File file2 : list2)
						{
							fullPath = file2.toString();
						}
						break;
					}
				}
			}
			else if (method.equals("FROMPOM"))
			{
				//means we are unpacking the files from a specific version of rainbow specified by the pom file that is in the .m2 folder.  
				//user.home = C:\\Users\\212303073 as an example	base for getting to the jars from the .m2 folder
				//user.dir = C:\\Users\\212303073\\workspace\\demo as an example    base for the test code that is running in order to get to the pom

				//first get the pom file for the project running and get the version for the jarPath given
				File pomFile = null;
				if (System.getProperty("os.name").toLowerCase().contains("win") == true)
				{		
					pomFile = new File(System.getProperty("user.dir").toString() + "\\pom.xml");
				}
				else
				{
					pomFile = new File(System.getProperty("user.dir").toString() + "/pom.xml");
				}				
			    FileInputStream fis = new FileInputStream(pomFile);
			    byte[] data = new byte[(int)pomFile.length()];
			    fis.read(data);
			    fis.close();
			    //
			    String entireFile = new String(data, "UTF-8");
			    int packageStartLocation = entireFile.indexOf(jarPath);
			    int versionStartLocation = entireFile.indexOf("<version>", packageStartLocation) + 9; 
			    int versionStopLocation = entireFile.indexOf("</version>", versionStartLocation);
			    
			    if (versionStopLocation > versionStartLocation && versionStartLocation > 0)
			    {
			    	String versionFromPom = entireFile.substring(versionStartLocation, versionStopLocation);
			    	
			    	if (System.getProperty("os.name").toLowerCase().contains("win") == true)
					{		
			    		fullPath = System.getProperty("user.home").toString() + "\\.m2\\repository\\com\\ge\\capital\\rainbow\\" + jarPath + "\\" + versionFromPom + "\\" + jarPath + "-" + versionFromPom + ".jar";
					}
					else
					{
						fullPath = System.getProperty("user.home").toString() + "/.m2/repository/com/ge/capital/rainbow/" + jarPath + "/" + versionFromPom + "/" + jarPath + "-" + versionFromPom + ".jar";
					}				
			    }
			    
			}
			else if (method.equals("FROMSELF"))
			{
				//means we are unpacking the files from itself
				fullPath = "target/" + jarPath;					
			}
					
			
			File file = new File(fullPath);
			JarFile jar = new JarFile(file);
	 
			//make sure the destination folder exists
			new File(destinationDir).mkdirs();
			 
			//now create all files
			for (Enumeration<JarEntry> enums = jar.entries(); enums.hasMoreElements();) {
				JarEntry entry = (JarEntry) enums.nextElement();
	  
				if (!entry.getName().endsWith("/")) {
					if (matchPattern.equals("") == false)
					{
						if (entry.getName().contains(matchPattern) == true)
						{
							String fileName = destinationDir + File.separator + entry.getName().substring(entry.getName().lastIndexOf("/")+1);
							File f = new File(fileName);
							
							InputStream is = jar.getInputStream(entry);
							byte[] b = new byte[(int) entry.getSize()];
							
							int offset =0;
							int numRead=0;
							while (offset<b.length && (numRead=is.read(b,offset,b.length-offset)) >=0) {
								offset += numRead;
							}
							
							FileOutputStream fos = new FileOutputStream(f);
			 				fos.write(b);
					
							fos.close();
							is.close();
							
							f.setExecutable(true);							
						}
					}
					else
					{
						String fileName = destinationDir + File.separator + entry.getName().substring(entry.getName().lastIndexOf("/")+1);
						File f = new File(fileName);
						
						InputStream is = jar.getInputStream(entry);
						byte[] b = new byte[(int) entry.getSize()];
						
						int offset =0;
						int numRead=0;
						while (offset<b.length && (numRead=is.read(b,offset,b.length-offset)) >=0) {
							offset += numRead;
						}
						
						FileOutputStream fos = new FileOutputStream(f);
		 				fos.write(b);
				
						fos.close();
						is.close();	
						
						f.setExecutable(true);
					}				
				}
			}
			
			jar.close();	
		}
		catch (Exception ex)
		{
		//dont do anything for now	
		}		
	}
}
