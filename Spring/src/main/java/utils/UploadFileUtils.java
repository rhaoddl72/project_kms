package utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	/*
	 * 기능 : 파일 주소와 파일명과 파일이 주어지면 해당 파일주소에 업로드일을 기준으로 
	 * /년도/월/일 폴더를 만들어 해당 폴더에 파일을 업로드 하는 메소드
	 * 매개변수: uploadPath - 업로드할 파일경로 
	 *           originalName - 실제 파일명
	 *           fileData - 업로드할 실제 파일 데이터가 있는 배열
	 * 리턴타입: 지정된 파일경로와 파일명으로 된 문자열
	 * 
	 * 예시 : uploadPath = "D:\\java_kMS\\uploadfiles", originalName = "dog.jpg"
	 *        fileData에는 dog.jpg파일이 배열로 담겨있다고 생각하면 된다.
	 * */
	public static String uploadFile(String uploadPath, String originalName, byte[] 	
			fileData)throws Exception{
		//UUID 생성 (자동으로 만들어짐)  => ex)12345e400-20eo-kgk1
		UUID uid = UUID.randomUUID();
//		파일명에 UUID를 붙여줌 => ex)12345e400-20eo-kgk1_dog.jpg
		String savedName = uid.toString() +"_" + originalName;
		String savedPath = calcPath(uploadPath);
		File target = new File(uploadPath + savedPath, savedName);
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	/*
	 * 기능 : 업로드할 파일 경로를 알려주면 해당 파일 경로에 오늘 날짜에 해당하는 폴더가
	 * 있는지 확인하여 없으면 폴더를 생성하고, 날짜 폴더 경로를 알려주는 메소드
	 * (폴더를 만들어주는 이유는 속도 저하를 덜어줄 수 있어서)
	 * (ex: 업로드폴더에 파일1000개가 그냥있는 것과 폴더 3개에 333개씩 담겨있는 경우
	 *      폴더 3개에 나뉘어 담겨있을 때 처리 속도가 훨씬 빠르다.)
	 * 매개변수 : uploadPath - 업로드할 파일의 경로
	 * 
	 * 리턴타입 : 날짜 폴더 경로 => ex) 2021\\07\\14 이런식으로 리턴됨
	 * 
	 * */
	private static String calcPath(String uploadPath) {
		//실행되는 시간을 기준으로 달력 정보를 가져온다.
		//시간보다 년월일이 필요하므로 date말고 calender사용
		Calendar cal = Calendar.getInstance();
		
		//separator => 구분자  윈도우는 / 리눅스는 \\(역슬래쉬는 쓰려면 2번써야함)처리됨
		// \\2021
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		// \\2021\\07
		// cal.get만 월이 나오는데 0~11 그래서 +1해줌
		// DecimalForamt으로 00 01 02 이렇게 2자리로 만들어줌
		String monthPath = yearPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		// datePath는 \\2021\\07\\14 만들어줌
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		// makdir은 해당하는 연 월 일 폴더가 없으면 해당하는 연 월 일 폴더를 만듬
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	
	/*
	 * 기능 : 업로드 경로, 폴더들이 주어지면 업로드 경로에 폴더들이 있는지 확인하고
	 *        없으면 해당 폴더들을 생성하는 메소드
	 *      
	 * 매개변수 : uploadPath - 업로드 경로, paths - 폴더들
	 * 
	 * 리턴타입 : 없으면 폴더 만드는거라 리턴타입 없음
	 * 
	 *  String .... 인경우 첫번째 매개변수이후 타입이 같은 매개변수 여러개인경우 ...처리(배열상태로됨)
	 *  
	 *  코드에 uploadPath + 이부분 추가해줌
	 *  
	 *  length-1 은 배열의 마지막 번지
	 * */
	private static void makeDir(String uploadPath, String... paths) {
		// D:\\java_kMS\\uploadfiles\\2021\\07\\14
		// 년월일로 된 폴더가 이미 있으면 메소드를 종료
		if(new File(uploadPath + paths[paths.length-1]).exists())
			return;
		for(String path : paths) {
			// D:\\java_kMS\\uploadfiles\\2021\\07\14
			File dirPath = new File(uploadPath + path);
			//파일(여기선폴더)가 없으면 해당 폴더를 생성(mkdir이 폴더 생성하는부분)
			if( !dirPath.exists())
				dirPath.mkdir();
		}
	}
	/*
	 * 기능 : 날짜 폴더 경로와 파일명이 주어지면 합쳐서 하나의 문자열로 반환하는 메소드,
	 * 	      단, 경로에 \\ 대신 /로 가져온다.
	 * 
	 * 미리보기 기능을 빼서 매개변수 String uploadPath 과
	 *  .substring(uploadPath.length()) 빼줬다.
	 *  
 	 * */
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		// \\2021\\07\\14 + \\ + 12345e400-20eo-kgk1_dog.jpg
		// => \\2021\\07\\14\\12345e400-20eo-kgk1_dog.jpg
		String iconName = uploadPath + path + File.separator + fileName;
//		/2021/07/14/12345e400-20eo-kgk1_dog.jpg 구분자 문자를 /로 바꿔준다.
		return iconName.replace(File.separatorChar, '/');
	}
}
