import java.io.*;
class ReadMyFile
{  
   public static void main(String[] args)
  {   
	    ReadMyFile obj=new ReadMyFile();	
	    obj.fileOperation();
	}
	public void fileOperation()
  {
       int lineCount=0;
       int characterCount=0;
       File fileOrginal=new File("C:\\Users\\anant\\Desktop\\today\\cricket\\ReadMyFile.java");
       File fileCopy=new File("C:\\Users\\anant\\Desktop\\today\\copyReadMyFile.java");
       try
       {    
          
           fileCopy.createNewFile();
           fileOrginal.createNewFile();
           FileWriter writer=new FileWriter(fileCopy);
           BufferedWriter write=new BufferedWriter(writer);
           FileReader reader=new FileReader(fileOrginal);
           BufferedReader  read=new BufferedReader(reader);
           String line=read.readLine();//read one line in file
           while(line!=null)
           {
             lineCount++;
             write.write(line+"\n");   //to write the line in another file
             String[] rowSplit=line.split("");  //to split the String in line
    	         for(int i=0;i<rowSplit.length;i++)
               {
    	         	 if(rowSplit[i]!=" ")
                 {
    	              characterCount++;
    	         	 }
    	         }
                line=read.readLine();
           }
           write.close();//over the write function to close the file;
   }
   catch(Exception e)
   {
        System.out.println("File is not created");       
   }

   System.out.println("Line count is "+lineCount);//print line count 50
   System.out.println("Character count "+characterCount);//print character count: 1588;
   System.out.println("copy file path "+fileCopy);//file path "C:\\Users\\anant\\Desktop\\today\\copyReadMyFile.java"
	}	
}