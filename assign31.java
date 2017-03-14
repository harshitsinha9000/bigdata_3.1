

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class assign31 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("LIst out files in a single directory");
		
		String file_path = new String(args[0]);
		 FileSystem fs = FileSystem.get(new Configuration());
         FileStatus[] status = fs.listStatus(new Path(file_path));  // you need to pass in your hdfs path

         for (int i=0;i<status.length;i++){
             BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(status[i].getPath())));
             String line;
             line=br.readLine();
             while (line != null){
                 System.out.println(line);
                 line=br.readLine();
                 
                
             }
         }

         System.out.println("LIst out files in a single directory recursively");
         
         printFilesRecursively(file_path);}
         

	private static void printFilesRecursively(String string) throws IOException {
		
		 FileSystem fs1 = FileSystem.get(new Configuration());
         FileStatus[] status1 = fs1.listStatus(new Path(string));
         
         for (int i = 0; i < status1.length; i++) {
             if (status1[i].isDir()) 
             {
                 printFilesRecursively(status1[i].getPath().toString());
             } 
             else 
             {
               try {
                     System.out.println(status1[i].getPath().toString());
                 	}
                 catch (Exception e) 
                 {
                     System.err.println(e.toString());
                 }

             }

         }
     }
	
		// TODO Auto-generated method stub
		
	}
         
	

