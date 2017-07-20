package com.hs.mymap;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /*  ArrayList<String> excelData = getExcelData("map.xls", 0);

        for(String name:excelData){
            Log.e("excel测试",name);
        }*/
        try {
            inputStream = getAssets().open("map.xls");//获取到文件的输入流
            File tempFile = new File(getCacheDir(), "test.xls");//临时文件，第二个参数为文件名字，可随便取
            outputStream = new FileOutputStream(tempFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {//while循环进行读取
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();

            book = Workbook.getWorkbook(tempFile);//用读取到的表格文件来实例化工作簿对象（符合常理，我们所希望操作的就是Excel工作簿文件）
           // Sheet sheet = book.getSheet(int );//得到第几张表格(0-excel里面的最大表数)
            Sheet[] sheets = book.getSheets(); //得到所有的工作表
            for (int m = 0; m < sheets.length; m++) {
                Sheet sheet = book.getSheet(m);
                int Rows = sheet.getRows();//得到当前工作表的行数
                int Cols = sheet.getColumns(); //得到当前工作表的列数
                for (int i = 0; i < Cols; i++) {    // 注意：这里是按列读取的！！！
                    for (int j = 0; j < Rows; j++) {
                        String content=sheet.getCell(i, j).getContents();//结果是String类型的，根据具体需求进行类型转换
                        Log.e("excel测试",content);
                    }
                }
            }
            book.close();//关闭流
        } catch (Exception e) {
            Log.e("excel测试",e.toString());
        }


    }

  private  InputStream inputStream = null;//输入流
  private  FileOutputStream outputStream = null;//输出流
  private  Workbook book = null;//Excel工作簿对象

    /**获取excel表格中的数据不能在主线程中调用
       xlsName 为表格的名称
       index 表示第几张表格
       */
    public ArrayList<String> getExcelData(String xlsName, int index) {
       ArrayList<String> list = new ArrayList<>();
        //获取文件管理器
        AssetManager manager = getAssets();

        try {
            Workbook workbook = Workbook.getWorkbook(manager.open(xlsName));
            Sheet sheet = workbook.getSheet(index);
            //表格一共有多少行
            int sheetRows = sheet.getRows();
            //将数据添加到集合中
            for (int i = 0; i < sheetRows; i++) {
                //获取列的数据
                list.add(sheet.getCell(0, i).getContents());
                list.add(sheet.getCell(1, i).getContents());
                list.add(sheet.getCell(2, i).getContents());
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }






}
