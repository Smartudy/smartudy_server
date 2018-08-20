package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.sharewith.smartudy.dao.BoardMapper;
import com.sharewith.smartudy.dto.Question;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardServiceTest {

	@Autowired
	private BoardMapper dao;
    @Autowired
    private WebApplicationContext context;
    
	@Test
	public void getQuestions() {
	
		ArrayList<Question> list = dao.getQuestions("Education",0);
		JSONObject obj = new JSONObject();
		if(list != null) {
			obj.put("success", true);
			for(int i=0; i<list.size(); i++) {//이미지 이름을 가지고 바이너리 데이터를 만듬.
				Question q = list.get(i);
				String imagename = q.getimage1();
				String imagepath = context.getServletContext().getRealPath("/images/");
				imagepath += imagename;
				q.setimage1(imagepath);
				System.out.println(imagepath);
			}
			JSONArray arr = JSONArray.fromObject(list);
			obj.put("datas", arr);
		}else {
			obj.put("success", false);
		}
		System.out.println(obj.toString());
	}
	
	@Test
	public void getQuestionCounttest() {
		System.out.println(dao.getQuestionCount("Education"));
	}

}
