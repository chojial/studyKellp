package com.study.file.excel;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class OutTxt {
    public static void executeInfo() throws IOException{

        String filePath = "D:/testExcel.xlsx";    //指定本地的数据目录
        String slqPath = "D:/testSql.sql";    //指定生成文件目录
        try {
            InputStream in = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(in);
            in.close();
            String sql = "";
            Sheet sheetAt = wb.getSheetAt(0);
            int lastRowNum = sheetAt.getLastRowNum();

            Map map = new HashMap();
            sql = "";
            List<ExcelBean> excelBean = getExcelBean(sql, sheetAt, lastRowNum);
//            Map<String,String> map1 =new HashMap<>();
//            for(ExcelBean bean :excelBean){
//                map1.put(bean.getTestName(),bean.getUser_());
//            }
//            Iterator<Map.Entry<String, String>> it = map1.entrySet().iterator();
//            while (it.hasNext()) {
//                Map.Entry<String, String> entry = it.next();
//                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//
//                sql += String.format("INSERT IGNORE INTO `test_table_info` (`testName`, `updateTime`, `createTime`, `user_`) VALUES ('%s', now(), now(), '%s');\n", entry.getKey(), entry.getValue());
//            }
//            System.out.println(map1);
//            System.out.println(map1.size());
            int sum = excelBean.size();
            JSONArray jsonArray = new JSONArray();
            for (ExcelBean bean :excelBean) {
                if(sum % 2 != 0){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("testName",bean.getTestName());
                    jsonObject.put("user_",bean.getUser_());
                    jsonArray.add(jsonObject);
                    if(jsonArray.size() % 2 == 0){

                    }
                }

            }
            sql = String.format("update `t_product` set car_model_list = '%s' where id = '' ", jsonArray);
            File file = new File(slqPath);
            if(!file.exists()){
                file.createNewFile();
            }
            byte[] bytes = sql.getBytes();
            OutputStream os = new FileOutputStream(slqPath);
            os.write(bytes);
            os.flush();
            os.close();
            System.out.println("sheets");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<ExcelBean> getExcelBean(String sql, Sheet sheetAt, int lastRowNum) {
        List<ExcelBean> list = new ArrayList<>();
        for (int rowNum=0; rowNum <= lastRowNum; rowNum++){
            ExcelBean bean = new ExcelBean();    //创建一个单独Bean、
            System.out.println("rowNum = "+rowNum);
            Row row = sheetAt.getRow(rowNum);
            String testName = "";
            String user_ = "";
            if (row != null){
                Cell cell = row.getCell(0);
                if (cell != null) {
                    testName = cell.getStringCellValue();
                    bean.setTestName(testName);
                }
                cell = row.getCell(1);
                if (cell != null) {
                    user_ = cell.getStringCellValue();
                    bean.setUser_(user_);
                }
                /**
                 * 更多列在这里补充
                 */
            }
            list.add(bean);
        }
        return list;
    }


    public static void main(String args[]) throws IOException{
        long startTime = System.currentTimeMillis();
        executeInfo();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时为m:" + (endTime - startTime)/1000);
    }

}
