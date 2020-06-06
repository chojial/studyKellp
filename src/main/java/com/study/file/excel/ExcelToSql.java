package com.study.file.excel;

import jxl.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ExcelToSql {

    public static void main(String args[]){
        try{
            Workbook book= Workbook.getWorkbook(new File("D://workspaceuse6//foundation//test//com//shane//security//service//zdb.xls"));
            //获得第一个工作表对象
            Sheet sheet=book.getSheet(0);

            StringBuffer sql = new StringBuffer();
            for(int j = 1; j <= 929; j++){
            //  getCell（列,行）起始为0
            Cell cell1=sheet.getCell(0,j);
            Cell cell2=sheet.getCell(1,j);
            Cell cell3=sheet.getCell(2,j);
            Cell cell4=sheet.getCell(3,j);
            Cell cell5=sheet.getCell(4,j);
            String result1=cell1.getContents();
            String result2=cell2.getContents();
            String result3=cell3.getContents();
            String result4=cell4.getContents();
            String result5=cell5.getContents();
            System.out.print(result1);
            System.out.print(result2);
            System.out.print(result3);
            System.out.print(result4);
            System.out.print(result5);
            System.out.print("/n");

            sql.append("insert into tablename (citycode,cityname,qucode,quname,qu) values ('");
            sql.append(result1);
            sql.append("','");
            sql.append(result2);
            sql.append("','");
            sql.append(result3);
            sql.append("','");
            sql.append(result4);
            sql.append("','");
            sql.append(result5);
            sql.append("');");
            sql.append("/n");
            }
        book.close();
        writer(sql);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

         /**
    * 写sql写入文件
    * @param buffer
    * @throws Exception
    */
    private static void writer(StringBuffer buffer) throws Exception{
        PrintStream out = null ;
        try{
            out = new PrintStream(new FileOutputStream(new File("d://dic.sql"),true)) ;
            System.err.println(buffer.toString()) ;
            out.print(buffer.toString()) ;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(out!=null){
            out.close() ;
            }
        }
    }
}
