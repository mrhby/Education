package com.util;

import com.dao.Impl.UserDaoImpl;
import com.dao.UserDao;
import com.entity.Course;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import java.util.List;

public class excelUtil {

    public static void CourseToExcel(){
        try{
            WritableWorkbook writableWorkbook;
            File file = new File("/Users/huangboyu/Desktop/course.xls");
            if(!file.exists()){
                file.createNewFile();
            }
            writableWorkbook = Workbook.createWorkbook(file);
            WritableSheet writableSheet = writableWorkbook.createSheet("Sheet 1",0);
            UserDao userDao = new UserDaoImpl();
            List<Course> courseList = userDao.selectAllCourse();
            Label label_couid = new Label(0,0,"课程id");
            Label label_counam = new Label(1,0,"课程名");
            Label label_coutimes = new Label(2,0,"课程时间");
            Label label_couroom = new Label(3,0,"教室");
            Label label_courtea = new Label(4,0,"老师");
            writableSheet.addCell(label_couid);
            writableSheet.addCell(label_counam);
            writableSheet.addCell(label_coutimes);
            writableSheet.addCell(label_couroom);
            writableSheet.addCell(label_courtea);
            for(int i=0;i<courseList.size();i++){
                Label couid = new Label(0,i+1,courseList.get(i).getCouid()+"");
                Label counam = new Label(1,i+1,courseList.get(i).getCounam());
                Label coutimes = new Label(2,i+1,courseList.get(i).getCoutimes()+"");
                Label couroom = new Label(3,i+1,courseList.get(i).getCouroom());
                Label courtea = new Label(4,i+1,courseList.get(i).getCourtea());
                writableSheet.addCell(couid);
                writableSheet.addCell(counam);
                writableSheet.addCell(coutimes);
                writableSheet.addCell(couroom);
                writableSheet.addCell(courtea);
            }
            writableWorkbook.write();
            writableWorkbook.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        excelUtil.CourseToExcel();
    }

}
